package za.hendrikdelange.mycompletefitnesstracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import za.hendrikdelange.mycompletefitnesstracker.core.navigation.AppNavigation
import za.hendrikdelange.mycompletefitnesstracker.ui.theme.FitnessTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            FitnessTheme {

                AppNavigation()

            }

        }
    }
}



