package com.sjh.sunflower_sksowk156.feature.plantlist

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sjh.sunflower_sksowk156.core.ui.PlantListItem
import com.sjh.sunflower_sksowk156.feature.plantlist.event.PlantListScreenEvent
import com.sjh.sunflower_sksowk156.feature.plantlist.sideeffect.PlantListScreenSideEffect
import com.sjh.sunflower_sksowk156.feature.plantlist.state.PlantListScreenState

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun PlantListScreen(
    modifier: Modifier,
    onItemClick: (plantName: String) -> Unit,
    viewModel: PlantListViewModel = viewModel(factory = PlantListViewModel.Factory),
) {
    val context = LocalContext.current

    val state = viewModel.container.stateFlow.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel) {
        viewModel.container.sideEffectFlow.collect {
            handleSideEffect(it, context)
        }
    }

    when (val currentState = state.value) {
        PlantListScreenState.Loading -> {}
        is PlantListScreenState.Success -> {
            LazyVerticalGrid(modifier = modifier.fillMaxSize(), columns = GridCells.Fixed(2)) {
                items(items = currentState.plantItems) {
                    PlantListItem(data = it, modifier = modifier, onClick = {
                        viewModel.processIntent(PlantListScreenEvent.OnClickPlant(it))
                        onItemClick(it.name)
                    })
                }
            }
        }

        is PlantListScreenState.Error -> {}
    }
}

private fun handleSideEffect(sideEffect: PlantListScreenSideEffect, context: Context) {
    when (sideEffect) {
        is PlantListScreenSideEffect.Toast -> {
            Toast.makeText(context, sideEffect.message, Toast.LENGTH_SHORT).show()
        }
    }
}
