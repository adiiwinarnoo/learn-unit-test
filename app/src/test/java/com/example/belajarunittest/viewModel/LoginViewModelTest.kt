package com.example.belajarunittest.viewModel

import android.util.Log
import com.example.belajarunittest.network.repository.LoginRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutionException

class LoginViewModelTest {

    @Mock
    private lateinit var loginRepository: LoginRepository

    private lateinit var loginViewModel: LoginViewModel
    // Inisialisasi TestCoroutineDispatcher
    private val testDispatcher = TestCoroutineDispatcher()


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        loginViewModel = LoginViewModel(loginRepository)
        // Set Dispatchers.Main to test Dispatcher
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        // Reset Dispatchers.Main after the test is done
        Dispatchers.resetMain()
        // Cleanup TestCoroutineDispatcher
        testDispatcher.cleanupTestCoroutines()
    }


    @Test
    fun loginVM() {
        var user = "adiw1234"
        var password = "123456"

        var result = loginViewModel.loginMock(user,password)
        assertEquals("berhasil",result)
    }
}