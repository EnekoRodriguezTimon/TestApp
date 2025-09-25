package com.eneko.testapp.data.mapper

import coil.network.HttpException
import com.eneko.testapp.domain.model.ApiError
import com.eneko.testapp.domain.model.NetworkError
import okio.IOException

fun Throwable.toNetworkError(): NetworkError {
    val error = when(this){
        is IOException -> ApiError.NetworkError
        is HttpException -> ApiError.UnknownResponse
        else -> ApiError.UnknownError
    }

    return NetworkError(
        error = error,
        t = this
    )
}