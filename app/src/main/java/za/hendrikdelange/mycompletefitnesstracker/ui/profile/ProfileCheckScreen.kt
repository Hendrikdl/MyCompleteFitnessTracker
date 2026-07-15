package za.hendrikdelange.mycompletefitnesstracker.ui.profile

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import za.hendrikdelange.mycompletefitnesstracker.viewmodel.ProfileCheckViewModel


@Composable
fun ProfileCheckScreen(
    uid: String,
    onProfileFound: () -> Unit,
    onProfileMissing: () -> Unit,
    viewModel: ProfileCheckViewModel = hiltViewModel()
) {


    val hasProfile by viewModel.hasProfile.collectAsState()


    LaunchedEffect(uid) {

        viewModel.checkProfile(uid)

    }


    LaunchedEffect(hasProfile) {

        when (hasProfile) {

            true -> {
                onProfileFound()
            }


            false -> {
                onProfileMissing()
            }


            null -> {
                // Still checking
            }

        }

    }


    Text(
        text = "Checking profile..."
    )

}