package com.example.weatherapp.data.repository

import com.example.weatherapp.data.model.CurrentWeather
import com.example.weatherapp.data.remote.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val api: ApiService
) {

    fun getWeather(lat: Double, lon: Double): Flow<CurrentWeather> = flow {
        val response = api.getWeather(lat, lon)
        emit(response.current_weather)
    }.catch { e ->
        throw e // let ViewModel handle UI state
    }
}
