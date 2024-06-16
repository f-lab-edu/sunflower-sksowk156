package com.sjh.sunflower_sksowk156.feature.plantlist.state

import com.sjh.sunflower_sksowk156.core.model.Plant

sealed class PlantListScreenState {
    object Loading : PlantListScreenState()
    data class Success(val plantItems: List<Plant>) : PlantListScreenState()
    data class Error(val exception: Exception) : PlantListScreenState()
}
