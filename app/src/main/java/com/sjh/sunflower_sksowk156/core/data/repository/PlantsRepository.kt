package com.sjh.sunflower_sksowk156.core.data.repository

import com.sjh.sunflower_sksowk156.core.model.Plant
import kotlinx.coroutines.flow.Flow

interface PlantsRepository {
    fun getPlantsResource(): Flow<List<Plant>>
}
