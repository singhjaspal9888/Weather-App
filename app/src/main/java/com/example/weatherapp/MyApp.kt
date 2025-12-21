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
