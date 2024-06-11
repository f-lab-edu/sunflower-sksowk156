package com.sjh.sunflower_sksowk156.core.network.ktor

import com.sjh.sunflower_sksowk156.core.network.model.PlantSource

interface NetworkDataSource {

    suspend fun getPlantsResource() : List<PlantSource>
}
