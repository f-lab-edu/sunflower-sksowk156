package com.sjh.sunflower_sksowk156.feature.plantlist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sjh.sunflower_sksowk156.core.model.Plant
import com.sjh.sunflower_sksowk156.core.ui.PlantListItem

@Composable
fun PlantListScreen(modifier: Modifier, onItemClick: (String) -> Unit, data : List<Plant>) {
    LazyVerticalGrid(modifier = modifier.fillMaxSize(), columns = GridCells.Fixed(2)) {
        items(data) {
            PlantListItem(data = it, modifier = modifier, onClick = { onItemClick(it.plantId) })
        }
    }
}
