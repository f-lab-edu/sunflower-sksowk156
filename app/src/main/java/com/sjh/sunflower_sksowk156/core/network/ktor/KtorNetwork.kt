package com.sjh.sunflower_sksowk156.core.network.ktor

import com.sjh.sunflower_sksowk156.core.network.model.NetworkPlant
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class KtorNetwork(
    networkJson: Json,
) : NetworkDataSource {
    companion object {
        const val URL = "http://localhost:8081"
    }

    private val networkApi = HttpClient(Android) {
        install(ContentNegotiation) {
            json(networkJson)
        }
    }

    override suspend fun getPlantsResource(): List<NetworkPlant> =
        networkApi.get(URL).body()
}
