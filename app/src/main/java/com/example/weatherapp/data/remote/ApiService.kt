package com.example.weatherapp.data.remote

import com.example.weatherapp.data.model.ItemDto
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getItems(): List<ItemDto>
}