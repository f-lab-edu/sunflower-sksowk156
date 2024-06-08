package com.sjh.sunflower_sksowk156.feature.plantdetail

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSavedStateRegistryOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sjh.sunflower_sksowk156.R
import com.sjh.sunflower_sksowk156.feature.plantdetail.navigation.PLANT_ID

@Composable
fun PlantDetailScreen(
    modifier: Modifier, plantId: String, onBackClick: () -> Unit,
    viewModel: PlantDetailViewModel = viewModel(
        factory = PlantDetailViewModelFactory()
    ),
) {
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

            Text(modifier = modifier, text = "${plantId}")
            Text(modifier = modifier, text = "Watering needs")
            Text(modifier = modifier, text = "${plantId}")
            Text(modifier = modifier, text = "Last Watered")
            Text(modifier = modifier, text = "${plantId}")
        }
        Image(
            modifier = modifier
                .padding(start = 10.dp, top = 20.dp)
                .statusBarsPadding()
                .clickable {
                    onBackClick()
                },
            painter = painterResource(id = com.google.android.material.R.drawable.ic_arrow_back_black_24),
            contentDescription = null,
            alignment = Alignment.TopStart
        )
    }
}
