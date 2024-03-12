package com.example.myapplication.data

import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationItem (
    val route: String,
    val title: String,
    val descriptionContent: String,
    val icon: @composable () -> ImageVector
) {
    data object Home : BottomNavigationItem(
        route = "home_screen",
        title = "Home",
        descriptionContent = "Home screen",
        icon = { ImageVector.vectorResource(R.drawable.baseline_home_24) }
    )

    data object HeadPhones : BottomNavigationItem(
        route = "headphone_screen",
        title = "Head phone",
        descriptionContent = "headphones screen",
        icon = { ImageVector.vectorResource(R.drawable.baseline_headset_24) }
    )

    data object Camera : BottomNavigationItem(
        route = "camera_screen",
        title = "Camera",
        descriptionContent = "Camera screen",
        icon = { ImageVector.vectorResource(R.drawable.baseline_camera_24) }
    )
}