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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sjh.sunflower_sksowk156.R
import com.sjh.sunflower_sksowk156.core.designsystem.theme.Sunflowersksowk156Theme
import com.sjh.sunflower_sksowk156.feature.mygarden.MyGardenScreen
import com.sjh.sunflower_sksowk156.feature.plantfilterlist.PlantFilterListScreen
import com.sjh.sunflower_sksowk156.feature.plantlist.PlantListScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(modifier: Modifier, onPlantItemClick: (String)->Unit) {
    val tabs = listOf("My garden", "MyPlant list")
    val pagerState = rememberPagerState(pageCount = { tabs.size })
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val coroutineScope = rememberCoroutineScope()
    var isPlantDetailList by remember { mutableStateOf(false) }

    Scaffold(modifier = modifier
        .fillMaxSize()
        .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = {
                    MainToolbar(modifier = modifier,
                        currentPage = pagerState.currentPage,
                        onPlantToolbarMenuClick = {
                            isPlantDetailList = !isPlantDetailList
                        })
                }, scrollBehavior = scrollBehavior
            )
        }) { contentPadding ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(contentPadding)
        ) {
            TabRow(
                modifier = modifier.fillMaxWidth(),
                selectedTabIndex = pagerState.currentPage,
            ) {
                tabs.forEachIndexed { index, title ->
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
                                painter = painterResource(if (index == 0) R.drawable.ic_my_garden_active else R.drawable.ic_my_garden_active),
                                contentDescription = null
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
                    0 -> MyGardenScreen(modifier, onItemClick = onPlantItemClick)
                    1 -> {
                        if (isPlantDetailList) {
                            PlantFilterListScreen(modifier, onItemClick = onPlantItemClick)
                        } else {
                            PlantListScreen(modifier, onItemClick = onPlantItemClick)
                        }
                    }
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

@Preview
@Composable
fun MyAppPreview() {
    Sunflowersksowk156Theme {
//        MainScreen(Modifier)
    }
}
