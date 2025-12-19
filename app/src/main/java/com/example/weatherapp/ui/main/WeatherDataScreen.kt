package com.example.weatherapp.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import com.example.weatherapp.data.model.CurrentWeather

@Composable
fun WeatherDataScreen(data: CurrentWeather) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Current Location")
        Text("${data.temperature} °C", fontSize = 40.sp)
        Text("Wind: ${data.windspeed} km/h")
    }
}