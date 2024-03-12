package com.example.myapplication.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.myapplication.data.BottomNavigationItem
import androidx.compose.material3.Text as Text
@Composable
fun NavigationBar(
    navController: NavController
) {
    val items = listOf(
        BottomNavigationItem.Home,
        BottomNavigationItem.Camera,
        BottomNavigationItem.HeadPhones
    )
    val backStackEntry = navController.currentBackStackEntry

    androidx.compose.material3.NavigationBar {
        items.forEach { item ->
            val selected =
                (item.route == backStackEntry.value?.destination?.parent?.route) || (item.route == backStackEntry.value?.destination?.route)

            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(imageVector = item.icon.invoke(), contentDescription = null,
                                modifier = Modifier.fillMaxSize())
                },
                label = {
                    Text(text = "")
                }
            )
        }
    }
}