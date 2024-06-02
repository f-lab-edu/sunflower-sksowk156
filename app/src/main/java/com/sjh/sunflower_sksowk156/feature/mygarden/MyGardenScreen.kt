package com.sjh.sunflower_sksowk156.feature.mygarden

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sjh.sunflower_sksowk156.R
import com.sjh.sunflower_sksowk156.core.model.MyPlant

@Composable
fun MyGardenScreen(modifier: Modifier) {
    val data = listOf<MyPlant>(
        MyPlant(name = "df1", plantDate = "asd", lastWateredDate = "fffe"),
        MyPlant(name = "df2", plantDate = "ewf", lastWateredDate = "fff"),
        MyPlant(name = "df3", plantDate = "vv", lastWateredDate = "rrr"),
        MyPlant(name = "df4", plantDate = "ee", lastWateredDate = "eee")
    )
    LazyVerticalGrid (modifier=modifier.fillMaxSize(),columns = GridCells.Fixed(2)) {
        items(data) {
            MyGardenListItem(data = it, modifier = modifier)
        }
    }
}

@Composable
fun MyGardenListItem(data: MyPlant, modifier: Modifier) {
    Card(
        modifier = modifier.padding(
            bottom = 26.dp, start = 12.dp, end = 12.dp, top=12.dp
        ),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
    ) {
        // Box는 카드 내부의 컨텐츠를 담는 컨테이너입니다.
        Box {
            Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                Image(
                    modifier = modifier.fillMaxWidth(),
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = null
                )

                Text(modifier = modifier, text = "${data.name}")
                Text(modifier = modifier, text = "Planted")
                Text(modifier = modifier, text = "${data.plantDate}")
                Text(modifier = modifier, text = "Last Watered")
                Text(modifier = modifier, text = "${data.lastWateredDate}")
                Text(modifier = modifier, text = "물 줘야하는 정보")
            }
        }
    }
}
