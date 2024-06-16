package com.sjh.sunflower_sksowk156.core.data.repository

import com.sjh.sunflower_sksowk156.core.model.Plant
import com.sjh.sunflower_sksowk156.core.network.ktor.NetworkDataSource
import com.sjh.sunflower_sksowk156.core.network.model.NetworkPlant
import com.sjh.sunflower_sksowk156.core.network.model.toExternalModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PlantsRepositoryImpl(
    private val networkDataSource: NetworkDataSource,
) : PlantsRepository {
    override fun getPlantsResource(): Flow<List<Plant>> = flow {
        emit(networkDataSource.getPlantsResource().map { it.toExternalModel() })
    }.flowOn(Dispatchers.IO)
}
