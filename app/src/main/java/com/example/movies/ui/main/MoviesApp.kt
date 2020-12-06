package com.example.movies.ui.main

import android.app.Application
import com.example.movies.dagger.component.AppComponent
import com.example.movies.dagger.component.DaggerAppComponent

class MoviesApp : Application() {

    fun getComponent(): AppComponent {
        return DaggerAppComponent.factory().create()
    }
}