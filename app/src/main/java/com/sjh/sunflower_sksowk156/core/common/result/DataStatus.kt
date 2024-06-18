package com.sjh.sunflower_sksowk156.core.common.result

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

sealed interface DataStatus<out T> {
    data class Success<T>(val data: T) : DataStatus<T>
    data class Error(val exception: Throwable) : DataStatus<Nothing>
    data object Loading : DataStatus<Nothing>
}

fun <T> Flow<T>.toSafeFlow(): Flow<DataStatus<T>> =
    map<T, DataStatus<T>> { DataStatus.Success(it) }.onStart { emit(DataStatus.Loading) }
        .catch { emit(DataStatus.Error(it)) }
