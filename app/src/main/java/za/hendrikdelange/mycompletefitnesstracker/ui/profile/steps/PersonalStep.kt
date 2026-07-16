package za.hendrikdelange.mycompletefitnesstracker.ui.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import za.hendrikdelange.mycompletefitnesstracker.viewmodel.ProfileViewModel
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import za.hendrikdelange.mycompletefitnesstracker.ui.components.cards.FitnessCard
import za.hendrikdelange.mycompletefitnesstracker.ui.components.input.FitnessDatePicker
import za.hendrikdelange.mycompletefitnesstracker.ui.components.input.FitnessDropdown
import za.hendrikdelange.mycompletefitnesstracker.ui.components.inputs.FitnessTextField
import za.hendrikdelange.mycompletefitnesstracker.ui.components.text.FitnessSectionTitle


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonalStep(
    viewModel: ProfileViewModel = hiltViewModel()
) {


    val firstName by viewModel.firstName.collectAsState()
    val surname by viewModel.surname.collectAsState()
    val dateOfBirth by viewModel.dateOfBirth.collectAsState()
    val gender by viewModel.gender.collectAsState()

    FitnessCard {

        FitnessSectionTitle(
            text = "Personal Information"
        )

        FitnessTextField(
            value = firstName,
            onValueChange = viewModel::updateFirstName,
            label = "First Name"
        )

        FitnessTextField(
            value = surname,
            onValueChange = viewModel::updateSurname,
            label = "Surname"
        )

        FitnessDatePicker(

            value = dateOfBirth,

            label = "Date of Birth",

            onValueChange = viewModel::updateDateOfBirth

        )

        val genders = listOf(

            "Male",

            "Female",

            "Other",

            "Prefer not to say"

        )

        FitnessDropdown(

            value = gender,

            label = "Gender",

            options = genders,

            onValueChange = viewModel::updateGender

        )
    }
}
