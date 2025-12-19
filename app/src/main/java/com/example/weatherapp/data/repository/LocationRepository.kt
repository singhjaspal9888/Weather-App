package com.example.weatherapp.data.repository

import com.example.weatherapp.data.model.LocationData
import com.example.weatherapp.data.remote.LocationProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LocationRepository @Inject constructor(
    private val locationProvider: LocationProvider
) {
    fun getCurrentLocation(): Flow<LocationData> = flow {
        val location = locationProvider.getLastLocation()
            ?: throw IllegalStateException("Location not found")
        emit(LocationData(location.latitude, location.longitude))
    }
}

