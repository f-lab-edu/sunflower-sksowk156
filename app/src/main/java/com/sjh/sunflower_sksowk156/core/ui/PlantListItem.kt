package com.sjh.sunflower_sksowk156.core.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.sjh.sunflower_sksowk156.core.model.Plant

@Composable
fun PlantListItem(data: Plant, modifier: Modifier, onClick : () -> Unit) {
    Card(
        modifier = modifier.padding(
            bottom = 26.dp, start = 12.dp, end = 12.dp, top = 12.dp
        ),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
        onClick = onClick
    ) {
        // Box는 카드 내부의 컨텐츠를 담는 컨테이너입니다.
        Box {
            Column(
                modifier = modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = modifier.fillMaxWidth(),
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = null
                )

                Text(modifier = modifier, text = "${data.name}")
            }
        }
    }
}
