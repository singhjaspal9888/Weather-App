package com.example.weatherapp.ui.main

import com.example.weatherapp.data.model.ItemDto

data class MainUiState(
    val isLoading: Boolean = false,
    val items: List<ItemDto> = emptyList(),
    val error: String? = null
)