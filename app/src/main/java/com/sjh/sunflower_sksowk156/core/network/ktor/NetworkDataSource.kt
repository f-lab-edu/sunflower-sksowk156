package com.sjh.sunflower_sksowk156.core.network.ktor

import com.sjh.sunflower_sksowk156.core.network.model.NetworkPlant

interface NetworkDataSource {

    suspend fun getPlantsResource() : List<NetworkPlant>
}
