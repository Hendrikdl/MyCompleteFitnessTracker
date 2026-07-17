package za.hendrikdelange.mycompletefitnesstracker.core.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import za.hendrikdelange.mycompletefitnesstracker.ui.theme.FitnessDesign

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

    NavigationBar(

        containerColor = FitnessDesign.colors.Card,

        tonalElevation = 0.dp

    ) {

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

                    Text(text = item.title,

                        fontSize = 10.sp,

                        maxLines = 1,

                        overflow = TextOverflow.Ellipsis)

                },
                colors = NavigationBarItemDefaults.colors(

                    selectedIconColor = FitnessDesign.colors.Primary,

                    selectedTextColor = FitnessDesign.colors.Primary,

                    unselectedIconColor = FitnessDesign.colors.TextSecondary,

                    unselectedTextColor = FitnessDesign.colors.TextSecondary,

                    indicatorColor = FitnessDesign.colors.Background

                )

            )

        }

    }

}