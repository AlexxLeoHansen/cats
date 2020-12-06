package com.example.movies.dagger.component

import androidx.lifecycle.ViewModelProvider
import com.example.movies.dagger.AppModule
import com.example.movies.dagger.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class, ViewModelModule::class])
@Singleton
interface AppComponent {
    val factory: ViewModelProvider.Factory

    @Component.Factory
    interface Factory {
        fun create(): AppComponent
    }
}