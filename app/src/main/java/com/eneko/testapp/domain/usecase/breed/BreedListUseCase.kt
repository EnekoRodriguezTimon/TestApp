package com.eneko.testapp.domain.usecase.breed

import android.util.Log
import arrow.core.Either
import com.eneko.testapp.domain.model.Breed
import com.eneko.testapp.domain.model.NetworkError
import com.eneko.testapp.domain.repository.BreedRepository
import javax.inject.Inject


class BreedListUseCase @Inject constructor(
    private val repository: BreedRepository
) {
    suspend operator fun invoke(): Either<NetworkError, List<Breed>> {
        val result = repository.getBreeds()
        return result
    }
}
