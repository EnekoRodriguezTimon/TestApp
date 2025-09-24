package com.eneko.testapp.domain.repository


import arrow.core.Either
import com.eneko.testapp.domain.model.Breed
import com.eneko.testapp.domain.model.NetworkError

interface BreedRepository {

    suspend fun getBreeds(): Either<NetworkError, List<Breed>>
}