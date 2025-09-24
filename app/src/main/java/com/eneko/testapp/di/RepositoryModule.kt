package com.eneko.testapp.di

import com.eneko.testapp.data.repository.BreedRepositoryImpl
import com.eneko.testapp.domain.repository.BreedRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindBreedRepository(
        breedRepositoryImpl: BreedRepositoryImpl
    ): BreedRepository
}