package com.sjh.sunflower_sksowk156.feature.plantlist

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun PlantList() {
    LazyColumn {
        items(25) { index ->
            NumberHolder(number = index)
        }
    }
}

@Composable
fun NumberHolder(number: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = number.toString(), style = TextStyle(
                fontSize = 40.sp, fontWeight = FontWeight.Bold
            )
        )
    }
}
