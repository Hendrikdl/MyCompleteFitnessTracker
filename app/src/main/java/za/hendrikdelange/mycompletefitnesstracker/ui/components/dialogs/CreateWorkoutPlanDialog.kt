package za.hendrikdelange.mycompletefitnesstracker.ui.components.dialogs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.AppTypography
import za.hendrikdelange.mycompletefitnesstracker.ui.components.buttons.FitnessButton
import za.hendrikdelange.mycompletefitnesstracker.ui.components.inputs.FitnessTextField
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.FitnessDesign
import za.hendrikdelange.mycompletefitnesstracker.data.model.WorkoutCategory
import za.hendrikdelange.mycompletefitnesstracker.ui.components.cards.FitnessChip

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateWorkoutPlanDialog(

    onDismiss: () -> Unit,

    onSave: (
        String,
        WorkoutCategory,
        Int
    ) -> Unit

) {

    var expanded by remember {
        mutableStateOf(false)
    }

    var name by remember {
        mutableStateOf("")
    }

    var selectedCategory by remember {
        mutableStateOf(WorkoutCategory.PUSH)
    }

    var selectedDay by remember {
        mutableIntStateOf(1)
    }

    AlertDialog(

        onDismissRequest = onDismiss,

        title = {

            Text(

                text = "Create Workout Plan",

                style = AppTypography.Title

            )

        },

        text = {

            Column(

                verticalArrangement = Arrangement.spacedBy(
                    FitnessDesign.spacing.Medium
                )

            ) {

                FitnessTextField(

                    value = name,

                    label = "Workout Name",

                    onValueChange = {
                        name = it
                    }

                )

                Text(

                    text = "Category",

                    style = FitnessDesign.typography.Title,

                    color = FitnessDesign.colors.Primary

                )

                ExposedDropdownMenuBox(

                    expanded = expanded,

                    onExpandedChange = {

                        expanded = !expanded

                    }

                ) {

                    OutlinedTextField(

                        value = selectedCategory.name,

                        onValueChange = {},

                        readOnly = true,

                        label = {

                            Text("Category")

                        },

                        trailingIcon = {

                            ExposedDropdownMenuDefaults.TrailingIcon(
                                expanded = expanded
                            )

                        },

                        modifier = Modifier
                            .menuAnchor()
                            .fillMaxWidth()

                    )

                    ExposedDropdownMenu(

                        expanded = expanded,

                        onDismissRequest = {

                            expanded = false

                        }

                    ) {

                        WorkoutCategory.entries.forEach { category ->

                            DropdownMenuItem(

                                text = {

                                    Text(category.name)

                                },

                                onClick = {

                                    selectedCategory = category

                                    expanded = false

                                }

                            )

                        }

                    }

                }

                Text(

                    text = "Training Day",

                    style = FitnessDesign.typography.Title,

                    color = FitnessDesign.colors.Primary

                )

                val days = listOf(

                    "Mon",

                    "Tue",

                    "Wed",

                    "Thu",

                    "Fri",

                    "Sat",

                    "Sun"

                )

                FlowRow(

                    horizontalArrangement = Arrangement.spacedBy(
                        FitnessDesign.spacing.Small
                    ),

                    verticalArrangement = Arrangement.spacedBy(
                        FitnessDesign.spacing.Small
                    )

                ) {

                    days.forEachIndexed { index, day ->

                        FitnessChip(

                            text = day,

                            color =
                                if (selectedDay == index + 1)
                                    FitnessDesign.colors.Primary
                                else
                                    FitnessDesign.colors.TextSecondary,

                            onClick = {

                                selectedDay = index + 1

                            }

                        )

                    }

                }


            }

        },

        confirmButton = {

            Row(

                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement = Arrangement.End

            ) {

                FitnessButton(

                    text = "Save",

                    enabled = name.isNotBlank(),

                    onClick = {

                        onSave(

                            name,

                            selectedCategory,

                            selectedDay

                        )

                    }

                )
            }

        },

        dismissButton = {

            FitnessButton(

                text = "Cancel",

                onClick = onDismiss

            )

        }

    )

}

@Composable
fun ExposedDropdownMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    content: @Composable () -> Unit
) {
    TODO("Not yet implemented")
}