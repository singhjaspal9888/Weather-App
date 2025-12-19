package com.example.weatherapp.data.repository

import com.example.weatherapp.data.remote.ApiService
import com.example.weatherapp.ui.main.WeatherUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val api: ApiService
) {

    fun getWeather(lat: Double, lon: Double): Flow<WeatherUiState> = flow {
        emit(WeatherUiState.Loading)

        val response = api.getWeather(
            lat = lat,
            lon = lon
        )

        emit(WeatherUiState.Success(response.current_weather))
    }.catch {
        emit(WeatherUiState.Error("Something went wrong"))
    }
}
