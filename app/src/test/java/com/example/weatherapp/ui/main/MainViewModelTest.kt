package com.example.weatherapp.ui.main

import app.cash.turbine.test
import com.example.weatherapp.data.model.ItemDto
import com.example.weatherapp.data.repository.MainRepositoryImpl
import com.example.weatherapp.utils.Resource
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test


class MainViewModelTest {
//    private lateinit var viewModel: MainViewModel
//    private val repo: MainRepositoryImpl = mockk()
//
//    @Before
//    fun setup() {
//        Dispatchers.setMain(StandardTestDispatcher())
//    }
//
//    @After
//    fun tearDown() {
//        Dispatchers.resetMain()
//    }
//
//    @Test
//    fun `loadItems emits Loading then Success`() = runTest {
//        // Fake list
//        val fakeItems = listOf(ItemDto(id = 1, userId = 1, title = "Test", body =  "body"))
//
//        coEvery { repo.getItems() } returns flow {
//            emit(Resource.Loading())
//            emit(Resource.Success(fakeItems))
//        }
//
//        viewModel = MainViewModel(repo)
//
//        viewModel.uiState.test {
//            // 1st emission: loading
//            val loading = awaitItem()
//            assertTrue(loading.isLoading)
//
//            // 2nd emission: success
//            val success = awaitItem()
//            assertFalse(success.isLoading)
//            assertEquals(fakeItems, success.items)
//
//            cancelAndConsumeRemainingEvents()
//        }
//    }
//
//    @Test
//    fun `loadItems emits Error`() = runTest {
//        coEvery { repo.getItems() } returns flow {
//            emit(Resource.Loading())
//            emit(Resource.Error("Network Failed"))
//        }
//
//        viewModel = MainViewModel(repo)
//
//        viewModel.uiState.test {
//            val loading = awaitItem()
//            assertTrue(loading.isLoading)
//
//            val error = awaitItem()
//            assertEquals("Network Failed", error.error)
//
//            cancelAndConsumeRemainingEvents()
//        }
//    }

}