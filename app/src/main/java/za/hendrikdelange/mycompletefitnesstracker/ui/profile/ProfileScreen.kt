package za.hendrikdelange.mycompletefitnesstracker.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.FitnessDesign
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import za.hendrikdelange.mycompletefitnesstracker.viewmodel.ProfileViewModel

@Composable
fun ProfileScreen(

    viewModel: ProfileViewModel = hiltViewModel()

) {


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(FitnessDesign.colors.Background)
    ) {

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text("Profile")

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    viewModel.syncNow()
                }
            ) {
                Text("Sync Now")
            }
        }
    }

}