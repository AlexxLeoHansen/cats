package com.example.movies.dagger

import com.example.movies.network.MoviesService
import com.example.movies.ui.main.repository.MoviesRepository
import com.example.movies.ui.main.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun providesUserRepository(): UserRepository {
        return UserRepository()
    }

    @Provides
    @Singleton
    fun providesCatsRepository(): MoviesRepository {
        return MoviesRepository(MoviesService())
    }

    @Provides
    @Singleton
    fun providesCatsService(): MoviesService {
        return MoviesService()
    }
}