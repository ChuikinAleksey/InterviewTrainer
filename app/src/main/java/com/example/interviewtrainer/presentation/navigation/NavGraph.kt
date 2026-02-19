package com.example.interviewtrainer.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.interviewtrainer.data.database.AppDatabase
import com.example.interviewtrainer.data.repository.PlatformRepository
import com.example.interviewtrainer.presentation.screen.androidmain.AndroidMainScreen
import com.example.interviewtrainer.presentation.screen.empty.EmptyScreen
import com.example.interviewtrainer.presentation.screen.platform.PlatformSelectionScreen
import com.example.interviewtrainer.presentation.screen.platform.PlatformViewModel
import com.example.interviewtrainer.presentation.screen.platform.PlatformViewModelFactory


@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.PlatformSelection.route
    ) {
        composable(Screen.PlatformSelection.route) {
                val context = LocalContext.current
                val database = AppDatabase.getInstance(context)
                val repository = PlatformRepository(database.platformDao())
                val factory = PlatformViewModelFactory(repository)
                val viewModel: PlatformViewModel = viewModel(factory = factory)

                PlatformSelectionScreen(
                    viewModel = viewModel,
                    navController = navController
                )
        }

        composable(Screen.AndroidMain.route) {
            AndroidMainScreen()
        }

        composable(Screen.Empty.route) {
            EmptyScreen()
        }
    }
}