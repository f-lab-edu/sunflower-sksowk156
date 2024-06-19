package com.sjh.sunflower_sksowk156.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkPlant(
    val plantId: String,
    val name: String,
    val description: String,
    val growZoneNumber: Int,
    val wateringInterval: Int = 7,
    val imageUrl: String = "",
)
