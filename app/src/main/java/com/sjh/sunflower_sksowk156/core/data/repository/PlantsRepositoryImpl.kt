package com.sjh.sunflower_sksowk156.core.data.repository

import com.sjh.sunflower_sksowk156.core.model.Plant
import com.sjh.sunflower_sksowk156.core.network.ktor.NetworkDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PlantsRepositoryImpl(
    private val networkDataSource: NetworkDataSource,
) : PlantsRepository {
    override fun getPlantsResource(): Flow<List<Plant>> = flow {
        emit(networkDataSource.getPlantsResource().map { networkPlant ->
            Plant(
                plantId = networkPlant.plantId,
                name = networkPlant.name,
                description = networkPlant.description,
                growZoneNumber = networkPlant.growZoneNumber,
                wateringInterval = networkPlant.wateringInterval,
                imageUrl = networkPlant.imageUrl,
            )
        })
    }.flowOn(Dispatchers.IO)
}
