package com.sjh.sunflower_sksowk156.feature.plantfilterlist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sjh.sunflower_sksowk156.core.model.Plant
import com.sjh.sunflower_sksowk156.core.ui.PlantListItem

@Composable
fun PlantFilterListScreen(modifier: Modifier, onItemClick: (String) -> Unit) {
    val data = listOf<Plant>(
        Plant(plantId = "2", name = "abs2", description = "df2", growZoneNumber = 2),
        Plant(plantId = "3", name = "abs3", description = "df3", growZoneNumber = 3),
        Plant(plantId = "5", name = "abs5", description = "df5", growZoneNumber = 5),

        )
    LazyVerticalGrid(modifier = modifier.fillMaxSize(), columns = GridCells.Fixed(2)) {
        items(data) {
            PlantListItem(data = it, modifier = modifier, onClick = { onItemClick(it.plantId) })
        }
    }
}
