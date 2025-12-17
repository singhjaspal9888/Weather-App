package com.example.weatherapp.ui.main

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.weatherapp.data.model.ItemDto

@Composable
//@Preview(showBackground = true, showSystemUi = true)
fun MainScreen( viewModel: MainViewModel = hiltViewModel()) {

    val state by viewModel.uiState.collectAsState()


    Column(
        Modifier.background(
            color = Color(0xFF6da7f1)
        )
    ) {
        when {
            state.isLoading -> Log.d("qqqqqqqqqqqqq", "loading.....${state.isLoading}")
            state.error != null -> Log.d("qqqqqqqqqqqqq", "error ${state.error}")
            else -> LazyColumn {
                items(state.items) { item ->
                    Log.d("qqqqqqqqqqqqq", "item -> ${item.title}")
                    ListItem(item)
                }
            }
        }
        // Show error as snackbar
//        LaunchedEffect(state.error) {
//            state.error?.let { scaffoldState.snackbarHostState.showSnackbar(it) }
//        }

//        Column(
//            modifier = Modifier
//                .padding(20.dp)
//                .fillMaxSize()
//                .shadow(
//                    elevation = 6.dp,           // Shadow size
//                    shape = RoundedCornerShape(26.dp), // Rounded corners
//                    clip = false
//                )
//                .background(
//                    brush = Brush.linearGradient(
//                        colors = listOf(
//                            Color(0xFF4e83c5),
//                            Color(0xFF275CA0),
//                            Color(0xFF275CA0),
//                        ),
//                    ),
//                    shape = RoundedCornerShape(26.dp)
//                )
//        ) {
//
//            Row(
//                Modifier.padding(20.dp)
//            ) {
//                Column(
//                    Modifier
//                        .weight(1f)
//                        .fillMaxWidth()
//
//                ) {
//                    Text("Berlin, Germany", color = Color.White
//                    , fontSize = 18.sp)
//                    Text("Berlin, Germany", color = Color.White,
//                        fontSize = 14.sp)
//                }
//                Icon(
//                    imageVector = Icons.Filled.Home,
//                    contentDescription = null,
//                    tint = Color.White,
//                    modifier = Modifier
//                        .padding(end = 10.dp)
//                        .background(
//                            color = Color(0xFFFFFFFF).copy(alpha = 0.25f),
//                            shape = RoundedCornerShape(6.dp)
//                        )
//                        .padding(5.dp)
//                        .size(24.dp)
//                )
//                Icon(
//                    imageVector = Icons.Filled.Home,
//                    contentDescription = null,
//                    tint = Color.White,
//                    modifier = Modifier
//                        .background(
//                            color = Color(0xFFFFFFFF).copy(alpha = 0.25f),
//                            shape = RoundedCornerShape(6.dp)
//                        )
//                        .padding(5.dp)
//                        .size(24.dp)
//                )
//
//
//            }
//
//        }
//        Row() {
//
//        }
//
//        Column(
//            Modifier.fillMaxSize()
//        ) { }

    }
}

@Composable
fun ListItem(item: ItemDto) {
    Row(modifier = Modifier.padding(16.dp)) {
// Use an image loader (Coil) properly sized
        Text(item.title)
    }
}