package com.sjh.sunflower_sksowk156.feature.mygarden

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sjh.sunflower_sksowk156.feature.plantlist.NumberHolder

@Composable
fun MyGardenScreen(modifier:Modifier) {
    LazyColumn(modifier.fillMaxSize()) {
        items(25) { index ->
            NumberHolder(number = index)
        }
    }
}
