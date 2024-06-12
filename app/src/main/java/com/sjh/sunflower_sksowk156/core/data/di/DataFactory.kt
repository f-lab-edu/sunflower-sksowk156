package com.sjh.sunflower_sksowk156.core.data.di

import com.sjh.sunflower_sksowk156.core.data.repository.PlantsRepository
import com.sjh.sunflower_sksowk156.core.data.repository.PlantsRepositoryImpl
import com.sjh.sunflower_sksowk156.core.network.di.NetworkFactory
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

object DataFactory {

    fun providePlantsRepository(): PlantsRepository {
        return PlantsRepositoryImpl(
            networkDataSource = NetworkFactory.provideNetworkDataSource(),
        )
    }
}
