package com.example.weatherapp.data.repository

import androidx.compose.runtime.collectAsState
import com.example.weatherapp.data.remote.ApiService
import com.example.weatherapp.utils.ConnectivityObserver
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.*
import org.junit.Before

class MainRepositoryImplTest {

//    private val api = mockk<ApiService>()
//    private val connectivity = mockk<ConnectivityObserver>()
//    private val repo = MainRepositoryImpl(api,connectivity)
//
//    fun `repository returns items `() = runTest {
//        val fakeItems = listOf(ItemDto(1,1,"Test","body"))
//
//        every { connectivity.observe().collectAsState().value }
//    }


//    @Test
//    fun `repository returns items`() = runTest {
//        val fakeItems = listOf(UserDto(1, "Test"))
//
//        every { connectivity.isConnected() } returns true
//        coEvery { api.getItems() } returns fakeItems
//
//        repo.getItems().test {
//            assert(awaitItem() is Resource.Loading)
//
//            val success = awaitItem()
//            assert(success is Resource.Success)
//            assertEquals(fakeItems, success.data)
//
//            cancelAndConsumeRemainingEvents()
//        }
//    }

}