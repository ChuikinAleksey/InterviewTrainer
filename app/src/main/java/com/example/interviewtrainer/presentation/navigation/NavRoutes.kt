package com.example.interviewtrainer.presentation.navigation

sealed class Screen(val route: String){
    object PlatformSelection: Screen("platform_selection")
    object AndroidMain : Screen("android_main")
    object Empty : Screen("empty")
}