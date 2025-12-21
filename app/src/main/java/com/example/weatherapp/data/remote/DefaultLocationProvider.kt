package com.example.weatherapp.data.remote

import android.content.Context
import android.location.Location
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class DefaultLocationProvider @Inject constructor(
    @ApplicationContext private val context: Context
) : LocationProvider {
    override suspend fun getLastLocation(): Location? {
        val client = LocationServices.getFusedLocationProviderClient(context)
        return client.lastLocation.await()
    }
}