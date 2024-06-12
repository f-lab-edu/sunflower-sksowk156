package com.sjh.sunflower_sksowk156

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sjh.sunflower_sksowk156.core.designsystem.theme.Sunflowersksowk156Theme
import com.sjh.sunflower_sksowk156.core.model.Plant
import com.sjh.sunflower_sksowk156.core.network.model.NetworkPlant
import com.sjh.sunflower_sksowk156.feature.SunflowerApp
import fi.iki.elonen.NanoHTTPD
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Sunflowersksowk156Theme {
                SunflowerApp()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        // 서버 중지
        (applicationContext as SunflowerApplication).server?.stop()
    }

}
