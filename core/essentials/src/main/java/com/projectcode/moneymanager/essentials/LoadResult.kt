package com.projectcode.moneymanager.essentials

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

sealed class LoadResult<out T> {

    data object Loading: LoadResult<Nothing>()

    data class Error(
        val exception: Exception
    ): LoadResult<Nothing>()

    data class Success<T>(
        val data: T
    ): LoadResult<T>()

}

fun <T, R> LoadResult<T>.map(mapper: (T) -> R): LoadResult<R> {
    return when (this) {
        is LoadResult.Error -> this
        LoadResult.Loading -> LoadResult.Loading
        is LoadResult.Success<T> -> {
            val mappedValue: R = mapper(data)
            LoadResult.Success(mappedValue)
        }
    }
}

fun <T, R> Flow<LoadResult<T>>.loadResultMap(mapper: (T) -> R): Flow<LoadResult<R>> {
    return map { loadResult ->
        loadResult.map(mapper)
    }
}