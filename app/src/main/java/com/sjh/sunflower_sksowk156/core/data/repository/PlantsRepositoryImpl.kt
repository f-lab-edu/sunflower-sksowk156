package com.sjh.sunflower_sksowk156.core.data.repository

import com.sjh.sunflower_sksowk156.core.model.Plant
import com.sjh.sunflower_sksowk156.core.network.ktor.NetworkDataSource
import com.sjh.sunflower_sksowk156.core.network.model.PlantSource
import com.sjh.sunflower_sksowk156.core.network.model.asExternalModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PlantsRepositoryImpl(
    private val networkDataSource: NetworkDataSource,
    private val ioDispatcher: CoroutineDispatcher,
) : PlantsRepository {
    override fun getPlantsResource(): Flow<List<Plant>> = flow {
        emit(networkDataSource.getPlantsResource().map { it.asExternalModel() })
    }.flowOn(ioDispatcher)
}
