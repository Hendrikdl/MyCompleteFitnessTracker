package za.hendrikdelange.mycompletefitnesstracker.core.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomBar(
    navController: NavHostController
) {

    val items = listOf(

        NavigationItem.Home,

        NavigationItem.Exercises,

        NavigationItem.Workouts,

        NavigationItem.Progress,

        NavigationItem.Profile

    )

    val navBackStackEntry =
        navController.currentBackStackEntryAsState()

    val currentRoute =
        navBackStackEntry.value?.destination?.route

    NavigationBar {

        items.forEach { item ->

            NavigationBarItem(

                selected = currentRoute == item.route,

                onClick = {

                    navController.navigate(item.route) {

                        popUpTo(navController.graph.startDestinationId)

                        launchSingleTop = true

                        restoreState = true

                    }

                },

                icon = {

                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )

                },

                label = {

                    Text(item.title)

                }

            )

        }

    }

}