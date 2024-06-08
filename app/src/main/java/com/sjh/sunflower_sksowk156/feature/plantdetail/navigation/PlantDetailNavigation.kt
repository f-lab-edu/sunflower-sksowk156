package com.sjh.sunflower_sksowk156.feature.plantdetail.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.sjh.sunflower_sksowk156.feature.plantdetail.PlantDetailScreen

const val PLANT_ID = "plantResourceId"
const val PLANTDETAIL_ROUTE = "/plantdetail"
const val PLANTDETAIL_ROUTE_WITH_ARG = "$PLANTDETAIL_ROUTE/{$PLANT_ID}"

fun NavController.navigateToPlantDetail(plantId: String) {
    navigate("$PLANTDETAIL_ROUTE/$plantId")
}

fun NavGraphBuilder.plantDetailScreen(
    modifier: Modifier,
    onBackClick: () -> Unit,
) {
    composable(
        route = PLANTDETAIL_ROUTE_WITH_ARG,
        arguments = listOf(navArgument(PLANT_ID) {
            type = NavType.StringType
        })
    ) {
        PlantDetailScreen(
            modifier = modifier,
            onBackClick = onBackClick,
        )
    }
}
