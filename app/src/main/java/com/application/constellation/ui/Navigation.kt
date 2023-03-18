package com.application.constellation.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.application.constellation.data.LISTSOURCE

@Composable
fun ConstellationApp(viewModel: ViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            ConstellationHome(list = LISTSOURCE, viewModel = viewModel) {
                navController.navigate("detail")
            }
        }
        composable("detail") {
            ConstellationDetail(dataHolder = viewModel.showDetails())
        }
    }
}

