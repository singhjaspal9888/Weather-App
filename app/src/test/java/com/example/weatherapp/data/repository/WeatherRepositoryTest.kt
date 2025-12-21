package com.example.weatherapp.data.repository

import com.example.weatherapp.data.model.CurrentWeather
import com.example.weatherapp.data.model.WeatherResponse
import com.example.weatherapp.data.remote.ApiService
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class WeatherRepositoryTest {

    private val apiService = mockk<ApiService>()
    private val repository = WeatherRepository(apiService)

    private val mockWeather = CurrentWeather(temperature = 25.0, windspeed = 5.0)

    @Test
    fun `getWeather returns CurrentWeather`() = runBlocking {
        coEvery { apiService.getWeather(28.61, 77.20) } returns WeatherResponse(
            current_weather = mockWeather
        )

        val result = repository.getWeather(28.61, 77.20).first()
        assertEquals(mockWeather, result)
    }
}