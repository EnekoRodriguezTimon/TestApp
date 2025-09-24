package com.eneko.testapp.data.repository

import arrow.core.Either
import com.eneko.testapp.data.mapper.toNetworkError
import com.eneko.testapp.data.remote.BreedApi
import com.eneko.testapp.domain.model.Breed
import com.eneko.testapp.domain.model.NetworkError
import com.eneko.testapp.domain.repository.BreedRepository
import javax.inject.Inject

class BreedRepositoryImpl @Inject constructor(
    private val breedApi: BreedApi
) : BreedRepository {

    override suspend fun getBreeds() : Either<NetworkError, List<Breed>> {
        return Either.catch {
            breedApi.getBreeds().data?:emptyList()
        }.mapLeft { it.toNetworkError() }
    }
}