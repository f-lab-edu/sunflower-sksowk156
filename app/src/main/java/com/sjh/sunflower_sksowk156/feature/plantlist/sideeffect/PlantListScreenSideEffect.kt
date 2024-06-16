package com.sjh.sunflower_sksowk156.feature.plantlist.sideeffect

sealed interface PlantListScreenSideEffect {
    data class Toast(val message: String) : PlantListScreenSideEffect
}
