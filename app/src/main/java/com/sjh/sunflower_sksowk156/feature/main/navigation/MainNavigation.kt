package com.sjh.sunflower_sksowk156.feature.main.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sjh.sunflower_sksowk156.feature.main.MainScreen

const val MAIN_ROUTE = "/main"

fun NavGraphBuilder.mainScreen(
    modifier: Modifier,
    onPlantItemClick: (String) -> Unit,
) {
    composable(route = MAIN_ROUTE) {
        MainScreen(modifier, onPlantItemClick)
    }
}
