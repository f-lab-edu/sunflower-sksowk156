package com.sjh.sunflower_sksowk156.feature.main

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sjh.sunflower_sksowk156.R
import com.sjh.sunflower_sksowk156.core.model.Plant
import com.sjh.sunflower_sksowk156.feature.mygarden.MyGardenScreen
import com.sjh.sunflower_sksowk156.feature.plantlist.PlantListScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    modifier: Modifier,
    onClickPlantItem: (plantId : String) -> Unit,
    viewModel: MainViewModel = viewModel(
        factory = MainViewModel.Factory
    )
) {
    val pagerState = rememberPagerState(pageCount = { 2 })
    val topBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val coroutineScope = rememberCoroutineScope()
    var isPlantFilterListScreen by remember { mutableStateOf(false) }

    Scaffold(modifier = modifier
        .fillMaxSize()
        .nestedScroll(topBarScrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = {
                    MainToolbar(modifier = modifier,
                        currentPage = pagerState.currentPage,
                        onPlantToolbarMenuClick = {
                            isPlantFilterListScreen = !isPlantFilterListScreen
                        })
                }, scrollBehavior = topBarScrollBehavior
            )
        }) { contentPadding ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(contentPadding)
        ) {
            TabRow(
                modifier = modifier.fillMaxWidth(),
                selectedTabIndex = pagerState.currentPage ,
            ) {
                for (index in 0 until pagerState.pageCount) {
                    val (title, tabImageResource) = when (index) {
                        0 -> "My garden" to R.drawable.ic_my_garden_active
                        1 -> "Plant list" to R.drawable.ic_plant_list_active
                        else -> throw IllegalArgumentException("Invalid page index")
                    }
                    Tab(
                        text = { Text(text = title) },
                        selected = pagerState.currentPage == index,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        },
                        icon = {
                            Image(
                                painter = painterResource(tabImageResource),
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(Color.Black),
                            )
                        },
                        unselectedContentColor = MaterialTheme.colorScheme.secondary
                    )
                }
            }
            HorizontalPager(
                modifier = modifier.fillMaxHeight(), state = pagerState,
            ) { page ->
                when (page) {
                    0 -> MyGardenScreen(modifier, onItemClick = onClickPlantItem)
                    1 -> PlantListScreen(
                        modifier,
                        onItemClick = onClickPlantItem,
                    )
                }
            }
        }
    }
}


@Composable
fun MainToolbar(modifier: Modifier, currentPage: Int, onPlantToolbarMenuClick: () -> Unit) {
    if (currentPage == 0) {
        MyGardenToolbar(modifier)
    } else {
        PlantListToolbar(modifier, onPlantToolbarMenuClick)
    }
}

@Composable
fun PlantListToolbar(modifier: Modifier, onMenuClick: () -> Unit) {
    Row(modifier = modifier.fillMaxWidth()) {
        Box(
            modifier = modifier
                .statusBarsPadding()
                .weight(1f), contentAlignment = Alignment.Center
        ) {
            Text(text = "Sunflower", fontSize = 50.sp)
        }

        Image(
            painter = painterResource(id = R.drawable.ic_filter_list_24dp),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .size(30.dp)
                .clickable { onMenuClick() },
            colorFilter = ColorFilter.tint(Color.Black),
        )
    }
}

@Composable
fun MyGardenToolbar(modifier: Modifier) {
    Box(
        modifier = modifier
            .statusBarsPadding()
            .fillMaxWidth(), contentAlignment = Alignment.Center
    ) {
        Text(text = "Sunflower", fontSize = 50.sp)
    }
}

// Todo : ViewMdoel에서 처리
fun getPlantData(isFilter: Boolean): List<Plant> {
    if (isFilter) {
        return listOf<Plant>(
            Plant(plantId = "2", name = "abs2", description = "df2", growZoneNumber = 2),
            Plant(plantId = "3", name = "abs3", description = "df3", growZoneNumber = 3),
            Plant(plantId = "5", name = "abs5", description = "df5", growZoneNumber = 5),
        )
    } else {
        return listOf<Plant>(
            Plant(plantId = "1", name = "abs1", description = "df1", growZoneNumber = 1),
            Plant(plantId = "2", name = "abs2", description = "df2", growZoneNumber = 2),
            Plant(plantId = "3", name = "abs3", description = "df3", growZoneNumber = 3),
            Plant(plantId = "4", name = "abs4", description = "df4", growZoneNumber = 4),
            Plant(plantId = "5", name = "abs5", description = "df5", growZoneNumber = 5),
            Plant(plantId = "6", name = "abs6", description = "df6", growZoneNumber = 6),
        )
    }
}
