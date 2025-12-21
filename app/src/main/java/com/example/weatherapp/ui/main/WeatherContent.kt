package com.example.weatherapp.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag

@Composable
fun WeatherContent(state: WeatherUiState) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when (state) {
            is WeatherUiState.Loading -> CircularProgressIndicator(  modifier = Modifier.testTag("loading"))
            is WeatherUiState.Success -> WeatherDataScreen(state.data)
            is WeatherUiState.Error -> Text("Location / Weather error ❌")
        }
    }
}