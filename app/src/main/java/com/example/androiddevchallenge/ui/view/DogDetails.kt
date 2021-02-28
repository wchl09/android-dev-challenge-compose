package com.example.androiddevchallenge.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.module.dogPicArray
import com.example.androiddevchallenge.view.defaultPadding

@Composable
fun ShowDetails(dogId: Int) {
    var state = remember { mutableStateOf(0) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(text = "狗狗详情")
                    }
                }, navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = ""
                        )
                    }
                })

        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                state.value = 1
            }, backgroundColor = Color.Blue) {
                Text(text = if (state.value != 1) "领养" else "已领养", color = Color.White)
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = defaultPadding)
                .verticalScroll(state = rememberScrollState())
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(4.div(2f))
                    .padding(0.dp, 20.dp, 0.dp, 0.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Image(
                    painter = painterResource(dogPicArray[dogId]), contentDescription = "",
                    contentScale = ContentScale.Crop,
                    colorFilter = ColorFilter.tint(Color(0xFFF2F2F2), BlendMode.Modulate)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "狗狗名字", fontWeight = FontWeight.Bold, fontSize = 25.sp)
            Spacer(modifier = Modifier.height(7.dp))
            Text(
                text = """
                狗（拉丁文Canis lupus familiaris）属于脊索动物门、脊椎动物亚门、哺乳纲、真兽亚纲、食肉目、裂脚亚目、犬科动物。中文亦称“犬”，狗分布于世界各地。狗与马、牛、羊、猪、鸡并称“六畜”。有科学家认为狗是由早期人类从灰狼驯化而来，驯养时间在4万年前~1.5万年前。被称为“人类最忠实的朋友”，是饲养率最高的宠物，其寿命大约在12~18年 [1]  。在中国文化中，狗属于十二生肖之一，在十二生肖中的第11位。
                狗是由狼驯化而来的。早在狩猎采集时代，人们就已驯养狗为狩猎时的助手。因此，狗算是人类最早驯养的家畜。河北武安磁山、河南新郑裴李岗、浙江余姚河姆渡等遗址，都发现了狗骨骼，足证其驯养历史之久远。 山东胶县三里河出土的狗形鬶，造型生动逼真，使我们得见新石器时代家犬的形态特征。陕西西安半坡遗址出土的狗骨，头骨较小，额骨突出，肉裂齿小，下颌骨水平边缘弯曲，与华北狼有很大区别，说明人类驯养狗的历史确实很早。 [3]
                犬类祖先
                没有人确切知道人与狼第一次互动发生在什么时候。有科学家认为可能是在5万年之前，因为至少要花这么久的时间野狼才能发展出如今的基因差异。当时人与野狼分布在地球表面的许多地方，演化过程可能发生在好几个不同的地区。有些学者则认为狼在14000年前，甚至可能在16000年前的亚洲东南部，就已经被人类从野生狼驯化为家畜、即狗，用来玩、打猎、看家护院。 [3] 
                目前世界所有种类的犬都起源于约1.6万年前中国长江流域南部驯养的狼。(瑞典皇家理工学院科学家彼得·萨弗莱宁确认了犬类的起源地点和时间) 。
                驯化历程
                犬的生物学起源可追溯到几千万年前，犬的驯化史大约在一万五千年前的中石器时代，甚至有科学家从遗传学的角度论证称，可能早在距今10万年前，犬就已被人类驯化。 人类首次破译犬的基因组是在2005年——甚至比研究人员利用遗传学工具追踪犬类最早的家园还要早。早期研究在东亚发现了犬基因的高度多样性，并在许多乡村犬群里发现了其他一些关键性的标记，他们因此指出东亚地区是犬被人类驯养最早的地方。 [5] 
                美国亚利桑那大学的研究人员分别从比利时和西伯利亚地区出土的两个距今至少3.3万年前的狗头骨表明，狗早在远古时代就已经被人类驯服。
                基因密码
                在过去 1.4 万年中，经过不断地驯化，产生了400多种犬。每一种都具有独特的体格、皮毛颜色以及习性。为了发现造成犬的特定性状的基因突变，2009 年 Akey等分析了 10 个品种共 275 头家犬的基因组。此前的研究发现带来产生地特定特性的基因，诸如达克斯犬的短腿。他们分析了一系列品种的犬，从而确定数个世纪的选择性育种对于整个犬基因组的影响。这组作者扫描了将近 300 头犬的遗传记录，包括小猎犬、博德牧羊犬、杰克罗素 犬、沙皮犬以及标准贵妇犬，并确定了选择性育种如何影响了这些动物的基因组。作者发现了155 个不同的遗传位置可能在产生纯种犬的特性方面起到了作用，并提出这些信息可能为找到产生特定品种形状的基因提供线索。例如，这组科学家提出不同版本的 HAS2 基因可能为沙皮犬带来了它的独特的褶皱或光滑的外皮。相对于犬外貌特性的研究，生理特性的研究比较少。2012 年 Chen 等对犬和狼的嗅觉受体基因家族进行分类及测序分析，发现由于驯养导致的生殖隔离，犬和狼中嗅觉受体基因进化的方向不一致，中国乡村犬中嗅觉受体基因序列比较保守。
            """.trimIndent()
            )
        }
    }
}