package com.example.weatherapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp : Application() {
        override fun onCreate() {
           super.onCreate()
        // Debug-only memory leak detector or analytics init
    }
}

//https://github.com/Prashant-Chandel/MVVM-Clean-Architech-HILT-Jetpack-Compose-Junit-Mockito
//https://medium.com/@janishar.ali/android-mvvm-architecture-for-a-production-ready-app-2892b6dca02f
