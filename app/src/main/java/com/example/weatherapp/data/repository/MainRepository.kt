package com.example.weatherapp.data.repository

import com.example.weatherapp.data.model.ItemDto
import com.example.weatherapp.utils.Resource
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun getItems(): Flow<Resource<List<ItemDto>>>
}