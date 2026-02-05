package com.example.basearchitecture.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.basearchitecture.screens.HomeScreen
import com.example.basearchitecture.screens.ProfileScreen

@Composable
fun AppNavigation() {

    val backStack: SnapshotStateList<AppRoutes> = remember { mutableStateListOf(AppRoutes.Home) }
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppRoutes.Home) {
        composable<AppRoutes.Home> {
            HomeScreen { userName ->
                val profileScreen = AppRoutes.Profile(userName)
                backStack.add(profileScreen)
                navController.navigate(profileScreen)
            }
        }

        composable<AppRoutes.Profile> { backStackEntry ->
            val profileScreen = backStackEntry.toRoute<AppRoutes.Profile>()
            ProfileScreen(userName = profileScreen.name) {
                backStack.removeAt(backStack.size - 1)
                navController.popBackStack()
            }
        }
    }

}