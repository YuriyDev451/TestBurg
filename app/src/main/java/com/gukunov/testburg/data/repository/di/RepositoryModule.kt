package com.gukunov.testburg.data.repository.di

import com.gukunov.testburg.data.repository.BurgerRepository
import com.gukunov.testburg.data.repository.BurgerRepositoryInterface
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
    abstract fun provideBurgerRepository(repository: BurgerRepository): BurgerRepositoryInterface
}
