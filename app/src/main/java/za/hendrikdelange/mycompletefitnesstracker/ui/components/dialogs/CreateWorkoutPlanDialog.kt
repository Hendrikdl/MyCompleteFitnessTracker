package za.hendrikdelange.mycompletefitnesstracker.ui.components.dialogs

import android.R.attr.category
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.AppTypography
import za.hendrikdelange.mycompletefitnesstracker.ui.components.buttons.FitnessButton
import za.hendrikdelange.mycompletefitnesstracker.ui.components.inputs.FitnessTextField
import za.hendrikdelange.mycompletefitnesstracker.ui.theme.FitnessDesign
import za.hendrikdelange.mycompletefitnesstracker.data.model.WorkoutCategory

@Composable
fun CreateWorkoutPlanDialog(

    onDismiss: () -> Unit,

    onSave: (
        String,
        WorkoutCategory,
        Int
    ) -> Unit

) {

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



            }

        },

        confirmButton = {

            Row(

                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement = Arrangement.End

            ) {

                FitnessButton(

                    enabled = name.isNotBlank(),

                    onClick = {

                        onSave(

                            name,

                            selectedCategory,

                            selectedDay

                        )

                    }

                ) {

                    Text("Save")

                }

            }

        },

        dismissButton = {

            FitnessButton(

                onClick = onDismiss

            ) {

                Text("Cancel")

            }

        }

    )

}