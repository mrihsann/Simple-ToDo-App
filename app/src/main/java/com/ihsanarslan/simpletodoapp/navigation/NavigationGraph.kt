package com.ihsanarslan.simpletodoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ihsanarslan.simpletodoapp.navigation.Screen.Add
import com.ihsanarslan.simpletodoapp.navigation.Screen.Detail
import com.ihsanarslan.simpletodoapp.navigation.Screen.Home
import com.ihsanarslan.simpletodoapp.presentation.add.AddScreen
import com.ihsanarslan.simpletodoapp.presentation.detail.DetailScreen
import com.ihsanarslan.simpletodoapp.presentation.home.HomeScreen

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Home,
    ) {
        composable<Home> {
            HomeScreen(navController)
        }
        composable<Detail> {
            DetailScreen(navController)
        }
        composable<Add> {
            AddScreen(navController)
        }
    }
}