package com.sjh.sunflower_sksowk156.feature

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sjh.sunflower_sksowk156.core.designsystem.theme.Sunflowersksowk156Theme
import com.sjh.sunflower_sksowk156.feature.main.MainScreen
import com.sjh.sunflower_sksowk156.feature.plantdetail.PlantDetailScreen

@Composable
fun SunflowerApp() {
    val navController = rememberNavController()
    SunFlowerNavHost(
        navController = navController
    )
}

@Composable
fun SunFlowerNavHost(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = "main") {
        composable(route = "main") {
            MainScreen(
                modifier = Modifier,
                onPlantItemClick = { plantId ->
                    navController.navigate("plantdetail/$plantId")
                }
            )
        }
        composable(
            route = "plantdetail/{plantId}",
            arguments = listOf(navArgument("plantId") { type = NavType.StringType })
        ) { backStackEntry ->
            val plantId = backStackEntry.arguments?.getString("plantId")
            plantId?.let {
                PlantDetailScreen(
                    modifier = Modifier,
                    plantId = it,
                    onBackClick = { navController.navigateUp() },
                )
            }
        }
    }
}

@Preview
@Composable
fun MyAppPreview() {
    Sunflowersksowk156Theme {
        SunflowerApp()
    }
}
