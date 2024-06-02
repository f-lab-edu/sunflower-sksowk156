package com.sjh.sunflower_sksowk156.feature.mygarden

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import com.sjh.sunflower_sksowk156.core.model.Plant

@Composable
fun MyGardenScreen(modifier: Modifier, onItemClick : (String) -> Unit) {
    val data = listOf<MyPlant>(
        MyPlant(plantDate = "asd", plant = Plant(plantId = "2", name = "abs2", description = "df2", growZoneNumber = 2)),
        MyPlant(plantDate = "ewf", plant = Plant(plantId = "3", name = "abs3", description = "df3", growZoneNumber = 3)),
        MyPlant(plantDate = "vv", plant =Plant(plantId = "4", name = "abs4", description = "df4", growZoneNumber = 4)),
        MyPlant(plantDate = "ee", plant = Plant(plantId = "5", name = "abs5", description = "df5", growZoneNumber = 5))
    )
    LazyVerticalGrid (modifier=modifier.fillMaxSize(),columns = GridCells.Fixed(2)) {
        items(data) {
            MyGardenListItem(data = it, modifier = modifier, onClick = {  onItemClick(it.plant.plantId) })
        }
    }
}

@Composable
fun MyGardenListItem(data: MyPlant, modifier: Modifier, onClick : () -> Unit) {
    Card(
        modifier = modifier.padding(
            bottom = 26.dp, start = 12.dp, end = 12.dp, top=12.dp
        ),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
        onClick = onClick
    ) {
        // Box는 카드 내부의 컨텐츠를 담는 컨테이너입니다.
        Box {
            Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                Image(
                    modifier = modifier.fillMaxWidth(),
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = null
                )

                Text(modifier = modifier, text = "${data.plant.name}")
                Text(modifier = modifier, text = "Planted")
                Text(modifier = modifier, text = "${data.plantDate}")
                Text(modifier = modifier, text = "Last Watered")
                Text(modifier = modifier, text = "${data.plant.wateringInterval}")
                Text(modifier = modifier, text = "물 줘야하는 정보")
            }
        }
    }
}
