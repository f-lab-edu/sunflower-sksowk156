package com.sjh.sunflower_sksowk156.feature.plantlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.sjh.sunflower_sksowk156.core.common.result.DataStatus
import com.sjh.sunflower_sksowk156.core.common.result.asResult
import com.sjh.sunflower_sksowk156.core.data.di.DataFactory
import com.sjh.sunflower_sksowk156.core.data.repository.PlantsRepository
import com.sjh.sunflower_sksowk156.core.model.Plant
import com.sjh.sunflower_sksowk156.feature.plantlist.event.PlantListScreenEvent
import com.sjh.sunflower_sksowk156.feature.plantlist.sideeffect.PlantListScreenSideEffect
import com.sjh.sunflower_sksowk156.feature.plantlist.state.PlantListScreenState
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.annotation.OrbitExperimental
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.syntax.simple.subIntent
import org.orbitmvi.orbit.viewmodel.container

class PlantListViewModel(private val plantsRepository: PlantsRepository) : ViewModel(),
    ContainerHost<PlantListScreenState, PlantListScreenSideEffect> {

    override val container =
        container<PlantListScreenState, PlantListScreenSideEffect>(PlantListScreenState.Loading) {
            if (state !is PlantListScreenState.Success) {
                fetchPlantList()
            }
        }

    @OptIn(OrbitExperimental::class)
    private suspend fun fetchPlantList() = subIntent {
        plantsRepository.getPlantsResource().asResult().collect { dataStatus ->
            reduce {
                when (dataStatus) {
                    DataStatus.Loading -> PlantListScreenState.Loading
                    is DataStatus.Success -> PlantListScreenState.Success(dataStatus.data)
                    is DataStatus.Error -> PlantListScreenState.Error(dataStatus.exception as Exception)
                }
            }
        }
    }

    fun processIntent(intent: PlantListScreenEvent) {
        when (intent) {
            is PlantListScreenEvent.OnClickPlant -> {
                showToast(intent.plant)
            }
        }
    }

    private fun showToast(plant: Plant) = intent {
        postSideEffect(PlantListScreenSideEffect.Toast("${plant.name} 클릭!!"))
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                if (modelClass.isAssignableFrom(PlantListViewModel::class.java)) {
                    @Suppress("UNCHECKED_CAST") return PlantListViewModel(DataFactory.providePlantsRepository()) as T
                }
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }
    }

}
