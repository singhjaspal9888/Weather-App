package com.example.weatherapp.data.repository

import com.example.weatherapp.data.model.ItemDto
import com.example.weatherapp.data.remote.ApiService
import com.example.weatherapp.utils.ConnectivityObserver
import com.example.weatherapp.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val connectivity: ConnectivityObserver
) : MainRepository {
    override fun getItems(): Flow<Resource<List<ItemDto>>> = flow {
        emit(Resource.Loading())
        val status = connectivity.observe().first()
        if (status == ConnectivityObserver.Status.Unavailable) {
            emit(Resource.Error("No internet"))
            return@flow
        }


        try {
            val items = api.getItems()
            emit(Resource.Success(items))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown error", e))
        }
    }.flowOn(Dispatchers.IO)
}