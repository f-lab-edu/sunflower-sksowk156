package com.sjh.sunflower_sksowk156.core.network.di

import com.sjh.sunflower_sksowk156.core.network.ktor.KtorNetwork
import com.sjh.sunflower_sksowk156.core.network.ktor.NetworkDataSource
import kotlinx.serialization.json.Json

object NetworkFactory {
    private fun createJson(): Json = Json {
        Json {
            prettyPrint = true
            isLenient = true
        }
    }
    fun provideNetworkDataSource(): NetworkDataSource {
        return KtorNetwork(createJson())
    }
}
