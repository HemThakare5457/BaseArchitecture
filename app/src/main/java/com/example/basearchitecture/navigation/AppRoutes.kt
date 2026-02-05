package com.example.basearchitecture.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class AppRoutes {
    @Serializable
    object Home: AppRoutes()

    @Serializable
    data class Profile(val name: String): AppRoutes()

}