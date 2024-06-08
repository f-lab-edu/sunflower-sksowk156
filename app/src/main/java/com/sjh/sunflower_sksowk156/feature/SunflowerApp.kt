package com.sjh.sunflower_sksowk156.feature

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.sjh.sunflower_sksowk156.core.designsystem.theme.Sunflowersksowk156Theme
import com.sjh.sunflower_sksowk156.feature.main.navigation.MAIN_ROUTE
import com.sjh.sunflower_sksowk156.feature.main.navigation.mainScreen
import com.sjh.sunflower_sksowk156.feature.plantdetail.navigation.navigateToPlantDetail
import com.sjh.sunflower_sksowk156.feature.plantdetail.navigation.plantDetailScreen

@Composable
fun SunflowerApp() {
    val navController = rememberNavController()
    SunFlowerNavHost(
        navController = navController,
        modifier = Modifier
    )
}

@Composable
fun SunFlowerNavHost(
    navController: NavHostController,
    startDestination: String = MAIN_ROUTE,
    modifier: Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        mainScreen(modifier = modifier, onPlantItemClick = navController::navigateToPlantDetail)
        plantDetailScreen(modifier = modifier, onBackClick = navController::popBackStack)
    }
}

@Preview
@Composable
fun MyAppPreview() {
    Sunflowersksowk156Theme {
        SunflowerApp()
    }
}
