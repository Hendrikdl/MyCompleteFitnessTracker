package za.hendrikdelange.mycompletefitnesstracker.ui.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import za.hendrikdelange.mycompletefitnesstracker.viewmodel.ProfileViewModel


@Composable
fun ProfileStepPersonal(
    viewModel: ProfileViewModel = hiltViewModel()
) {


    val firstName by viewModel.firstName.collectAsState()
    val surname by viewModel.surname.collectAsState()
    val dateOfBirth by viewModel.dateOfBirth.collectAsState()
    val gender by viewModel.gender.collectAsState()


    Column(

        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),

        verticalArrangement = Arrangement.spacedBy(12.dp)

    ) {


        Text(
            text = "Personal Information"
        )


        OutlinedTextField(

            value = firstName,

            onValueChange = {
                viewModel.updateFirstName(it)
            },

            label = {
                Text("First Name")
            },

            modifier = Modifier.fillMaxWidth()

        )


        OutlinedTextField(

            value = surname,

            onValueChange = {
                viewModel.updateSurname(it)
            },

            label = {
                Text("Surname")
            },

            modifier = Modifier.fillMaxWidth()

        )


        OutlinedTextField(

            value = dateOfBirth,

            onValueChange = {
                viewModel.updateDateOfBirth(it)
            },

            label = {
                Text("Date of Birth")
            },

            modifier = Modifier.fillMaxWidth()

        )


        OutlinedTextField(

            value = gender,

            onValueChange = {
                viewModel.updateGender(it)
            },

            label = {
                Text("Gender")
            },

            modifier = Modifier.fillMaxWidth()

        )

    }

}