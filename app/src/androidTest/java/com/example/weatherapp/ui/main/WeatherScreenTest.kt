package com.example.weatherapp.ui.main

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.example.weatherapp.data.model.CurrentWeather
import org.junit.Rule
import org.junit.Test

class WeatherScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun loadingIndicatorDisplayed() {
        composeTestRule.setContent {
            WeatherContent(state =WeatherUiState.Loading)
        }
//        composeTestRule.onNodeWithText("loading").assertIsDisplayed()
        composeTestRule.onNodeWithTag("loading").assertIsDisplayed()
    }

    @Test
    fun errorMessageDisplayed() {
        composeTestRule.setContent {
            WeatherContent(WeatherUiState.Error("Location / Weather error ❌"))
        }
        composeTestRule.onNodeWithText("Location / Weather error ❌").assertIsDisplayed()
    }

    @Test
    fun successDataDisplayed() {
        val weather = CurrentWeather(temperature = 25.0, windspeed = 5.0)
        composeTestRule.setContent {
            WeatherContent(WeatherUiState.Success(weather))
        }
        composeTestRule.onNodeWithText("25.0 °C").assertIsDisplayed()
        composeTestRule.onNodeWithText("Wind: 5.0 km/h").assertIsDisplayed()
    }
}