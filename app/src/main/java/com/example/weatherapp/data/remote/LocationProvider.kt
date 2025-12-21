package com.example.weatherapp.data.remote

import android.location.Location
interface LocationProvider {
    suspend fun getLastLocation(): Location?
}
