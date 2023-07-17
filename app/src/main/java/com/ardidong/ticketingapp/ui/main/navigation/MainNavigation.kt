package com.ardidong.ticketingapp.ui.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ardidong.ticketingapp.ui.main.history.HistoryScreen
import com.ardidong.ticketingapp.ui.main.home.HomeScreen
import com.ardidong.ticketingapp.ui.main.profile.ProfileScreen


@Composable
fun MainNavigation(modifier: Modifier, navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = MainDestination.Home.route
    ){
        composable(
            route = MainDestination.Home.route
        ){
            HomeScreen()
        }

        composable(
            route = MainDestination.History.route
        ){
            HistoryScreen()
        }

        composable(
            route = MainDestination.Profile.route
        ){
            ProfileScreen()
        }
    }
}
