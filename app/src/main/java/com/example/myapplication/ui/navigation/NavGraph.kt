package com.example.myapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun NavGraph (
    navController: NavHostController,
) {
    NavHost(
        navController = NavController,
        startDestination = BottomNavigationItem.Home.route
    ) {
        composable(route = BottomNavigationItem.Home.route) {
            HomePage()
        }
    }
}