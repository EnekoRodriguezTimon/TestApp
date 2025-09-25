package com.eneko.testapp.di

import com.eneko.testapp.data.repository.BreedRepositoryImpl
import com.eneko.testapp.data.repository.ItemRepositoryImpl
import com.eneko.testapp.domain.repository.BreedRepository
import com.eneko.testapp.domain.repository.ItemRepository
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

    @Binds
    @Singleton
    abstract fun bindItemRepository(
        itemRepositoryImpl: ItemRepositoryImpl
    ): ItemRepository
}