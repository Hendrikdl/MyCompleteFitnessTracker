package za.hendrikdelange.mycompletefitnesstracker.ui.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import za.hendrikdelange.mycompletefitnesstracker.ui.components.inputs.FitnessTextField
import za.hendrikdelange.mycompletefitnesstracker.viewmodel.ProfileViewModel

@Composable
fun MeasurementsStep(
    viewModel: ProfileViewModel = hiltViewModel()
) {

    val height by viewModel.heightCm.collectAsState()
    val weight by viewModel.weightKg.collectAsState()
    val waist by viewModel.waistCm.collectAsState()
    val chest by viewModel.chestCm.collectAsState()
    val leftBicep by viewModel.bicepLeftCm.collectAsState()
    val rightBicep by viewModel.bicepRightCm.collectAsState()
    val thigh by viewModel.thighCm.collectAsState()
    val calf by viewModel.calfCm.collectAsState()

    Column(

        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),

        verticalArrangement = Arrangement.spacedBy(16.dp)

    ) {

        Text("Body Measurements")

        FitnessTextField(
            value = height,
            label = "Height (cm)",
            keyboardType = KeyboardType.Decimal,
            onValueChange = viewModel::updateHeight
        )

        FitnessTextField(
            value = weight,
            label = "Weight (kg)",
            keyboardType = KeyboardType.Decimal,
            onValueChange = viewModel::updateWeight
        )

        FitnessTextField(
            value = waist,
            label = "Waist (Optional)",
            keyboardType = KeyboardType.Decimal,
            onValueChange = viewModel::updateWaist
        )

        FitnessTextField(
            value = chest,
            label = "Chest (Optional)",
            keyboardType = KeyboardType.Decimal,
            onValueChange = viewModel::updateChest
        )

        FitnessTextField(
            value = leftBicep,
            label = "Left Bicep (Optional)",
            keyboardType = KeyboardType.Decimal,
            onValueChange = viewModel::updateBicepLeft
        )

        FitnessTextField(
            value = rightBicep,
            label = "Right Bicep (Optional)",
            keyboardType = KeyboardType.Decimal,
            onValueChange = viewModel::updateBicepRight
        )

        FitnessTextField(
            value = thigh,
            label = "Thigh (Optional)",
            keyboardType = KeyboardType.Decimal,
            onValueChange = viewModel::updateThigh
        )

        FitnessTextField(
            value = calf,
            label = "Calf (Optional)",
            keyboardType = KeyboardType.Decimal,
            onValueChange = viewModel::updateCalf
        )

    }

}