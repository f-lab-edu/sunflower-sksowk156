package com.sjh.sunflower_sksowk156.feature.plantlist.event

import com.sjh.sunflower_sksowk156.core.model.Plant

sealed class PlantListScreenEvent {
    data class OnClickPlant(val plant: Plant) : PlantListScreenEvent()
}
