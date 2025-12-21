package com.example.weatherapp.ui.main

//import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.example.weatherapp.data.model.CurrentWeather
import com.example.weatherapp.data.model.LocationData
import com.example.weatherapp.data.repository.LocationRepository
import com.example.weatherapp.data.repository.WeatherRepository
import com.example.weatherapp.utils.ConnectivityObserver
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import com.example.weatherapp.MainDispatcherRule

@OptIn(ExperimentalCoroutinesApi::class)
class WeatherViewModelTest {

    @get:Rule(order = 0)
    val mainDispatcherRule = MainDispatcherRule()


    private val locationRepo = mockk<LocationRepository>()
    private val weatherRepo = mockk<WeatherRepository>()
    private val connectivityObserver = mockk<ConnectivityObserver>(relaxed = true)

    private lateinit var viewModel: WeatherViewModel

    private val mockWeather = CurrentWeather(temperature = 25.0, windspeed = 5.0)
    private val mockLocation = LocationData(latitude = 28.61, longitude = 77.20)

    @Before
    fun setup() {
        // ViewModel yahan create hoga (rule ke baad)
        viewModel = WeatherViewModel(
            locationRepo,
            weatherRepo,
            connectivityObserver
        )
    }

    @Test
    fun `uiState emits Success when weather fetched successfully`() = runTest {
        coEvery { locationRepo.getCurrentLocation() } returns flow { emit(mockLocation) }
        coEvery { weatherRepo.getWeather(28.61, 77.20) } returns flow { emit(mockWeather) }

        viewModel.fetchWeather()

        advanceUntilIdle()

        viewModel.uiState.test {
            val item = awaitItem()
            assertTrue(item is WeatherUiState.Success)
            assertEquals(mockWeather, (item as WeatherUiState.Success).data)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `uiState emits Error when location not found`() = runTest {
        coEvery { locationRepo.getCurrentLocation() } returns flow {
            throw Exception("Location not found")
        }

        viewModel.fetchWeather()

        advanceUntilIdle()

        viewModel.uiState.test {
            val item = awaitItem()
            assertTrue(item is WeatherUiState.Error)
            assertEquals(
                "Location not found",
                (item as WeatherUiState.Error).message
            )
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `uiState emits Error when weather API fails`() = runTest {
        coEvery { locationRepo.getCurrentLocation() } returns flow { emit(mockLocation) }
        coEvery { weatherRepo.getWeather(28.61, 77.20) } returns flow {
            throw Exception("API Error")
        }

        viewModel.fetchWeather()

        advanceUntilIdle()

        viewModel.uiState.test {
            val item = awaitItem()
            assertTrue(item is WeatherUiState.Error)
            assertEquals(
                "API Error",
                (item as WeatherUiState.Error).message
            )
            cancelAndIgnoreRemainingEvents()
        }
    }
}






//import app.cash.turbine.test
//import com.example.weatherapp.data.model.CurrentWeather
//import com.example.weatherapp.data.model.LocationData
//import com.example.weatherapp.data.repository.LocationRepository
//import com.example.weatherapp.data.repository.WeatherRepository
//import com.example.weatherapp.utils.ConnectivityObserver
//import io.mockk.coEvery
//import io.mockk.mockk
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.flow.flow
//import kotlinx.coroutines.test.StandardTestDispatcher
//import kotlinx.coroutines.test.runTest
//import org.junit.Assert.assertEquals
//import org.junit.Test
//
//@OptIn(ExperimentalCoroutinesApi::class)
//class WeatherViewModelTest {
//
//    private val dispatcher = StandardTestDispatcher()
//    private val locationRepo = mockk<LocationRepository>()
//    private val weatherRepo = mockk<WeatherRepository>()
//    private val connectivityObserver = mockk<ConnectivityObserver>(relaxed = true)
//
//    private val mockWeather = CurrentWeather(temperature = 25.0, windspeed = 5.0)
//    private val mockLocation = LocationData(latitude = 28.61, longitude = 77.20)
//
//    @Test
//    fun `uiState emits Success when weather fetched successfully`() = runTest(dispatcher) {
//        coEvery { locationRepo.getCurrentLocation() } returns flow { emit(mockLocation) }
//        coEvery { weatherRepo.getWeather(28.61, 77.20) } returns flow { emit(mockWeather) }
//
//        val viewModel = WeatherViewModel(locationRepo, weatherRepo, connectivityObserver)
//
//        viewModel.uiState.test {
//            val item = awaitItem()
//            assert(item is WeatherUiState.Success)
//            assertEquals(mockWeather, (item as WeatherUiState.Success).data)
//            cancelAndIgnoreRemainingEvents()
//        }
//    }
//
//    @Test
//    fun `uiState emits Error when location not found`() = runTest(dispatcher) {
//        coEvery { locationRepo.getCurrentLocation() } returns flow { throw Exception("Location not found") }
//
//        val viewModel = WeatherViewModel(locationRepo, weatherRepo, connectivityObserver)
//
//        viewModel.uiState.test {
//            val item = awaitItem()
//            assert(item is WeatherUiState.Error)
//            assertEquals("Location not found", (item as WeatherUiState.Error).message)
//            cancelAndIgnoreRemainingEvents()
//        }
//    }
//
//    @Test
//    fun `uiState emits Error when weather API fails`() = runTest(dispatcher) {
//        coEvery { locationRepo.getCurrentLocation() } returns flow { emit(mockLocation) }
//        coEvery { weatherRepo.getWeather(28.61, 77.20) } returns flow { throw Exception("API Error") }
//
//        val viewModel = WeatherViewModel(locationRepo, weatherRepo, connectivityObserver)
//
//        viewModel.uiState.test {
//            val item = awaitItem()
//            assert(item is WeatherUiState.Error)
//            assertEquals("API Error", (item as WeatherUiState.Error).message)
//            cancelAndIgnoreRemainingEvents()
//        }
//    }
//}