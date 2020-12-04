package com.example.kats.dagger.component

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.example.kats.dagger.AppModule
import com.example.kats.dagger.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named
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