package com.example.weatherapp.ui.main

import com.example.weatherapp.data.model.CurrentWeather

sealed class WeatherUiState {
    object Loading : WeatherUiState()
    data class Success(val data: CurrentWeather) : WeatherUiState()
    data class Error(val message: String) : WeatherUiState()
}
