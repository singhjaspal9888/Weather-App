package com.example.weatherapp.utils

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {

    enum class Status { Available, Unavailable }

    fun observe(): Flow<Status>
}