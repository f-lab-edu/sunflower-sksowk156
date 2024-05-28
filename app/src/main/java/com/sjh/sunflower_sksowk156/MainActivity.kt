package com.sjh.sunflower_sksowk156

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sjh.sunflower_sksowk156.core.designsystem.theme.Sunflowersksowk156Theme
import com.sjh.sunflower_sksowk156.feature.mygarden.MyGardenScreen
import com.sjh.sunflower_sksowk156.feature.plantlist.PlantList
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Sunflowersksowk156Theme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val tabs = listOf("My garden", "Plant list")
    val pagerState = rememberPagerState(pageCount = { tabs.size })
    val showTopBar = remember { mutableStateOf(true) }

    // NestedScrollConnection을 사용하여 스크롤에 따라 TopAppBar를 숨기거나 표시
    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                // 스크롤 방향에 따라 TopAppBar의 보이기/숨기기 상태를 변경
                val delta = available.y
                showTopBar.value = delta > 0 || (delta == 0f && showTopBar.value)
                return Offset.Zero
            }
        }
    }
    Scaffold(
        modifier = Modifier.nestedScroll(nestedScrollConnection)
    ) { paddingValues ->
        Column(modifier = Modifier.fillMaxSize()) {
            MainToolbar(showTopBar = showTopBar, currentPage = pagerState.currentPage)
            MainContent(pagerState = pagerState, tabs = tabs)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainContent(tabs: List<String>, pagerState: PagerState) {
    val coroutineScope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage, modifier = Modifier.fillMaxWidth()
    ) {
        tabs.forEachIndexed { index, title ->
            Tab(text = { Text(text = title) },
                selected = pagerState.currentPage == index,
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                })
        }
    }

    HorizontalPager(
        state = pagerState, modifier = Modifier.fillMaxHeight()
    ) { page ->
        when (page) {
            0 -> MyGardenScreen()
            1 -> PlantList()
        }
    }
}

@Composable
fun MainToolbar(showTopBar: MutableState<Boolean>, currentPage: Int) {
    AnimatedVisibility(
        visible = showTopBar.value, enter = slideInVertically(
            // TopAppBar가 아래로 나타날 때
            initialOffsetY = { -it },
            animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)
        ), exit = slideOutVertically(
            // TopAppBar가 위로 사라질 때
            targetOffsetY = { -it },
            animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)
        )
    ) {
        if (currentPage == 0) {
            MyGardenToolbar()
        } else {
            PlantListToolbar()
        }
    }
}

@Composable
fun PlantListToolbar() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Sunflower", fontSize = 50.sp)
        }
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .size(30.dp)
        )
    }
}

@Composable
fun MyGardenToolbar() {
    Box(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Sunflower", fontSize = 50.sp)
    }
}

@Preview
@Composable
fun MyAppPreview() {
    Sunflowersksowk156Theme {
        MainScreen()
    }
}