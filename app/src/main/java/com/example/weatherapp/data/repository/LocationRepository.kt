package com.example.weatherapp.data.repository

import android.content.Context
import com.example.weatherapp.data.model.LocationData
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class LocationRepository @Inject constructor(
    @ApplicationContext private val context: Context
) {

    private val client = LocationServices.getFusedLocationProviderClient(context)

    fun getCurrentLocation(): Flow<LocationData> = flow {
        val location = client.lastLocation.await()

        if (location != null) {
            emit(
                LocationData(
                    latitude = location.latitude,
                    longitude = location.longitude
                )
            )
        } else {
            throw Exception("Location not found")
        }
    }
}
