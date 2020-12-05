package com.example.kats.dagger

import com.example.kats.ui.main.repository.CatsRepository
import com.example.kats.ui.main.repository.UserRepository
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
    fun providesCatsRepository(): CatsRepository {
        return CatsRepository()
    }
}