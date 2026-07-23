package za.hendrikdelange.mycompletefitnesstracker.ui.components.dialogs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutExerciseWithExercise
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.FitnessDesign
import za.hendrikdelange.mycompletefitnesstracker.ui.components.buttons.FitnessButton
import za.hendrikdelange.mycompletefitnesstracker.ui.components.inputs.FitnessTextField

@Composable
fun ExerciseSetupDialog(

    workoutExercise: WorkoutExerciseWithExercise,

    onDismiss: () -> Unit,

    onSave: (
        weight: Double,
        sets: Int,
        repsFrom: Int,
        repsTo: Int,
        applyToAll: Boolean
    ) -> Unit

) {

    var weight by remember {
        mutableStateOf(
            workoutExercise.workoutExercise.weight.toString()
        )
    }

    var sets by remember {
        mutableStateOf(
            workoutExercise.workoutExercise.sets.toString()
        )
    }

    var repsFrom by remember {
        mutableStateOf(
            workoutExercise.workoutExercise.repsFrom.toString()
        )
    }

    var repsTo by remember {
        mutableStateOf(
            workoutExercise.workoutExercise.repsTo.toString()
        )
    }

    var applyToAll by remember {
        mutableStateOf(false)
    }

    AlertDialog(

        onDismissRequest = onDismiss,

        title = {

            Text(
                text = workoutExercise.exercise.name,
                style = FitnessDesign.typography.TitleMedium
            )

        },

        text = {

            Column(

                verticalArrangement =
                    Arrangement.spacedBy(
                        FitnessDesign.spacing.Medium
                    )

            ) {

                FitnessTextField(

                    value = weight,

                    onValueChange = {

                        weight = it

                    },

                    label = "Weight (kg)",

                    keyboardType = KeyboardType.Decimal

                )

                FitnessTextField(

                    value = sets,

                    onValueChange = {

                        sets = it

                    },

                    label = "Sets",

                    keyboardType = KeyboardType.Number

                )

                Row(

                    horizontalArrangement =
                        Arrangement.spacedBy(
                            FitnessDesign.spacing.Small
                        )

                ) {

                    FitnessTextField(

                        value = repsFrom,

                        onValueChange = {

                            repsFrom = it

                        },

                        label = "From",

                        modifier = Modifier.weight(1f),

                        keyboardType = KeyboardType.Number

                    )

                    FitnessTextField(

                        value = repsTo,

                        onValueChange = {

                            repsTo = it

                        },

                        label = "To",

                        modifier = Modifier.weight(1f),

                        keyboardType = KeyboardType.Number

                    )

                }

                Row(

                    modifier = Modifier.fillMaxWidth(),

                    verticalAlignment = Alignment.CenterVertically

                ) {

                    Text(

                        text = "Apply to all sets",

                        modifier = Modifier.weight(1f)

                    )

                    Switch(

                        checked = applyToAll,

                        onCheckedChange = {

                            applyToAll = it

                        }

                    )

                }

            }

        },

        confirmButton = {

            FitnessButton(

                text = "Save",

                onClick = {

                    onSave(

                        weight.toDoubleOrNull() ?: 0.0,

                        sets.toIntOrNull() ?: 0,

                        repsFrom.toIntOrNull() ?: 0,

                        repsTo.toIntOrNull() ?: 0,

                        applyToAll

                    )

                }

            )


        },

        dismissButton = {

            FitnessButton(

                text = "Cancel",

                onClick = onDismiss

            )

        }

    )

}