package za.hendrikdelange.mycompletefitnesstracker.core.startup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.runtime.LaunchedEffect
import za.hendrikdelange.mycompletefitnesstracker.core.startup.StartupResult
import za.hendrikdelange.mycompletefitnesstracker.viewmodel.StartupViewModel

@Composable
fun SplashScreen(

    onFinished: (StartupResult) -> Unit,

    viewModel: StartupViewModel = hiltViewModel()

) {

    val state by viewModel.state.collectAsStateWithLifecycle()
    val result by viewModel.result.collectAsStateWithLifecycle()

    // Start startup sequence once
    LaunchedEffect(Unit) {

        viewModel.start()

    }

    // Navigate when startup completes
    LaunchedEffect(result) {

        result?.let {

            onFinished(it)

        }

    }

    Column(

        modifier = Modifier.fillMaxSize(),

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.Center

    ) {

        Text("My Complete FitnessTracker")

        CircularProgressIndicator()

        Text(state.message)

    }

}