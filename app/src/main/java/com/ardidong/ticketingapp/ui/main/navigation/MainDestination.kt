package com.ardidong.ticketingapp.ui.main.navigation

sealed class MainDestination(val route: String){
    object Home : MainDestination("home")
    object History : MainDestination("history")
    object Profile : MainDestination("profile")
}

val bottomNavItem = listOf(
    MainDestination.Home,
    MainDestination.History,
    MainDestination.Profile
)
