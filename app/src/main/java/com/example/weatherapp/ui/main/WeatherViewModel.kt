package com.example.weatherapp.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.repository.LocationRepository
import com.example.weatherapp.data.repository.WeatherRepository
import com.example.weatherapp.utils.ConnectivityObserver
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val locationRepo: LocationRepository,
    private val weatherRepo: WeatherRepository,
    val connectivityObserver: ConnectivityObserver,
) : ViewModel() {

    private val _uiState = MutableStateFlow<WeatherUiState>(WeatherUiState.Loading)
    val uiState: StateFlow<WeatherUiState> = _uiState

    init {
        fetchWeather()
    }

    fun fetchWeather() {
        viewModelScope.launch {
            try {
                _uiState.value = WeatherUiState.Loading
                locationRepo.getCurrentLocation()
                    .flatMapLatest { location ->
                        weatherRepo.getWeather(location.latitude, location.longitude)
                            .map { WeatherUiState.Success(it) }
                    }
                    .collect { _uiState.value = it }
            } catch (e: Exception) {
                _uiState.value = WeatherUiState.Error(e.message ?: "Something went wrong")
            }
        }
    }
}

