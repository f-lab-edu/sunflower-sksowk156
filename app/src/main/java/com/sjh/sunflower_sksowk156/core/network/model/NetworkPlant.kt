package com.sjh.sunflower_sksowk156.core.network.model

import com.sjh.sunflower_sksowk156.core.model.Plant
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

fun NetworkPlant.asExternalModel() = Plant(
    plantId = plantId,
    name = name,
    description = description,
    growZoneNumber = growZoneNumber,
    wateringInterval = wateringInterval,
    imageUrl = imageUrl,
)
