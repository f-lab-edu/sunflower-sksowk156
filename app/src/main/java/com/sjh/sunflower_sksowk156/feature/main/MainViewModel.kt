package com.sjh.sunflower_sksowk156.feature.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.sjh.sunflower_sksowk156.core.data.di.DataFactory
import com.sjh.sunflower_sksowk156.core.data.repository.PlantsRepository

class MainViewModel(private val plantsRepository: PlantsRepository) :
    ViewModel() {

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                    @Suppress("UNCHECKED_CAST")
                    return MainViewModel(DataFactory.providePlantsRepository()) as T
                }
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }
    }
}
