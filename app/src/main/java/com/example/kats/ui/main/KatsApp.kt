package com.example.kats.ui.main

import android.app.Application
import com.example.kats.dagger.component.AppComponent
import com.example.kats.dagger.component.DaggerAppComponent

class KatsApp: Application() {

    fun getComponent(): AppComponent {
        return DaggerAppComponent.factory().create()
    }
}