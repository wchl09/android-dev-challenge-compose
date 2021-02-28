package com.example.androiddevchallenge.view

import android.util.Log
import android.widget.Space
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.module.dogPicArray
import com.example.androiddevchallenge.module.dogs
import com.example.androiddevchallenge.module.smallDogs
import com.example.androiddevchallenge.ui.Screen

val defaultPadding = 16.dp

@Composable
fun HomeContent(navigateTo: (Screen) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        item {
            Title("最新收录")
        }
        items(3) { dogId ->
            VerticalItem(dogId, navigateTo)
        }
        item {
            Title("正在申请领养")
        }
        item {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(defaultPadding, 0.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(smallDogs) { dogId ->
                    HorizontalItem(dogId, navigateTo)
                }
            }
        }
//        item {
//            Spacer(modifier = Modifier.size(0.dp, 20.dp))
//        }
        item {
            Title("其它狗狗")
        }
        items(dogs.size) { dogId ->
            VerticalItem(dogId, navigateTo)
        }
    }
}

@Composable
fun HorizontalItem(dogId: Int, navigateTo: (Screen) -> Unit) {
    BoxWithConstraints(
        contentAlignment = Alignment.BottomStart,
        modifier = Modifier
            .size(150.dp, 140.dp)
            .clickable {
                navigateTo(Screen.Details(dogId))
            }
    ) {
        Surface(modifier = Modifier.fillMaxSize(), shape = RoundedCornerShape(10.dp)) {
            Image(
                painter = painterResource(dogPicArray.random()), contentDescription = "",
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(Color(0xFFF2F2F2), BlendMode.Modulate)
            )
        }
        Surface(
            modifier = Modifier
                .size(150.dp, 30.dp)
                .align(
                    Alignment.BottomStart
                ),
            color = Color(0xAA000000),
            shape = RoundedCornerShape(0.dp, 0.dp, 10.dp, 10.dp),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
            ) {
                Text(
                    "领养中",
                    color = Color.White,
                    fontSize = 13.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        }
    }
}

@Composable
fun VerticalItem(dogId: Int, navigateTo: (Screen) -> Unit) {
    Card(
        backgroundColor = Color(0xFFF2F2F2),
        modifier = Modifier
            .padding(horizontal = defaultPadding)
            .fillMaxWidth()
            .clickable {
                navigateTo(Screen.Details(dogId))
            },
        elevation = 0.dp,
        shape = RoundedCornerShape(10.dp, 5.dp, 5.dp, 10.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Surface(shape = RoundedCornerShape(10.dp)) {
                Image(
                    painter = painterResource(dogPicArray.random()),
                    contentDescription = "",
                    modifier = Modifier.size(100.dp, 100.dp),
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop,
                    colorFilter = ColorFilter.tint(Color(0xFFF2F2F2), BlendMode.Modulate)
                )
            }
            Spacer(modifier = Modifier.size(width = 10.dp, height = 0.dp))
            Text(text = dogs[dogId])
            Spacer(modifier = Modifier.size(width = 10.dp, height = 0.dp))
        }
    }
}

@Composable
fun Title(title: String) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(defaultPadding, 15.dp, defaultPadding, 10.dp)
    ) {
        Text(title, fontSize = 22.sp, color = Color.Black, fontWeight = FontWeight.Bold)
    }
}