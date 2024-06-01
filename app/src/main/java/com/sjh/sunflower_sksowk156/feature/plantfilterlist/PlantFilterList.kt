package com.sjh.sunflower_sksowk156.feature.plantfilterlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PlantFilterListScreen(modifier: Modifier) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(25) { index ->
            Box {
                Text(text = "1")
            }
        }
    }
}
