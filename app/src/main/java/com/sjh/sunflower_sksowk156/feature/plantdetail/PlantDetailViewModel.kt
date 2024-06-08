package com.sjh.sunflower_sksowk156.feature.plantdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import com.sjh.sunflower_sksowk156.feature.plantdetail.navigation.PLANT_ID

class PlantDetailViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    val selectedPlantId = savedStateHandle.get<String>(PLANT_ID)
}

class PlantDetailViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if (modelClass.isAssignableFrom(PlantDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PlantDetailViewModel(
                extras.createSavedStateHandle(),
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
