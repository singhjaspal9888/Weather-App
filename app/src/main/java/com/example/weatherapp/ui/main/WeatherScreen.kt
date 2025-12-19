package com.example.weatherapp.ui.main

import android.Manifest
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = hiltViewModel()
) {

    var hasPermission by remember { mutableStateOf(false) }

    val requestPermission = rememberLocationPermissionLauncher {
        hasPermission = true
    }

    LaunchedEffect(Unit) {
        requestPermission()
    }

    if (!hasPermission) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Location permission required")
        }
        return
    }


    val state by viewModel.uiState.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when (state) {
            is WeatherUiState.Loading -> CircularProgressIndicator()

            is WeatherUiState.Success -> {
                val data = (state as WeatherUiState.Success).data
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Current Location")
                    Text("${data.temperature} °C", fontSize = 40.sp)
                    Text("Wind: ${data.windspeed} km/h")
                }
            }

            is WeatherUiState.Error -> {
                Text("Location / Weather error ❌")
            }
        }
    }
}
@Composable
fun rememberLocationPermissionLauncher(
    onPermissionGranted: () -> Unit
): () -> Unit {

    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) onPermissionGranted()
        else Toast.makeText(context, "Permission denied", Toast.LENGTH_SHORT).show()
    }

    return { launcher.launch(Manifest.permission.ACCESS_FINE_LOCATION) }
}
