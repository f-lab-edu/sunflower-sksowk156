package com.sjh.sunflower_sksowk156.feature.plantdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sjh.sunflower_sksowk156.R
import com.sjh.sunflower_sksowk156.core.designsystem.theme.Sunflowersksowk156Theme

@Composable
fun PlantDetailScreen(
    modifier: Modifier, onBackClick: () -> Unit,
    viewModel: PlantDetailViewModel = viewModel(
        factory = PlantDetailViewModelFactory()
    ),
) {
    val plantId = viewModel.selectedPlantId

    Box(modifier = modifier.fillMaxSize()) {
        PlantDetailContent(modifier = modifier)

        Image(
            modifier = modifier
                .padding(start = 10.dp, top = 20.dp)
                .statusBarsPadding()
                .clickable {
                    onBackClick()
                },
            painter = painterResource(id = com.google.android.material.R.drawable.ic_arrow_back_black_24),
            contentDescription = null,
            alignment = Alignment.TopStart,
            colorFilter = ColorFilter.tint(Color.White)
        )
    }
}

@Composable
private fun PlantDetailContent(modifier: Modifier) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier.verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            Image(
                modifier = modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(bottom = 30.dp)
                    .background(color = Color.Black),
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null
            )
            PlantFab(modifier = modifier.align(Alignment.BottomEnd), {})
        }

        Text(modifier = modifier, text = "식물 이름")
        Text(modifier = modifier, text = "Watering needs")
        Text(modifier = modifier, text = "물 줘야 하는 날")
        Column(
            modifier = modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(20.dp)
        ) {
            Text(
                modifier = modifier,
                text = "식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명 식물 설명"
            )
            Text(modifier = modifier, text = "(From Wikipedia)")
        }
    }
}

@Composable
private fun PlantFab(
    modifier: Modifier = Modifier,
    onFabClick: () -> Unit,
) {
    FloatingActionButton(
        onClick = onFabClick, shape = MaterialTheme.shapes.small,
        // Semantics in parent due to https://issuetracker.google.com/184825850
        modifier = modifier
    ) {
        Icon(
            Icons.Filled.Add, contentDescription = null
        )
    }
}

@Preview
@Composable
fun MyAppPreview() {
    Sunflowersksowk156Theme {
        PlantDetailContent(Modifier)
    }
}
