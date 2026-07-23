package za.hendrikdelange.mycompletefitnesstracker.ui.components.dialogs

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import za.hendrikdelange.mycompletefitnesstracker.ui.components.buttons.FitnessButton
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.FitnessDesign

@Composable
fun FitnessConfirmDeleteDialog(

    workoutName: String,

    onDismiss: () -> Unit,

    onDelete: () -> Unit

) {

    AlertDialog(

        onDismissRequest = onDismiss,

        title = {

            Text(

                "Delete Workout",

                color = FitnessDesign.colors.Primary

            )

        },

        text = {

            Text(

                "Delete \"$workoutName\"?\n\nThis action cannot be undone.",

                color = FitnessDesign.colors.textBlack

            )

        },

        confirmButton = {

            FitnessButton(

                text = "Cancel",

                onClick = onDismiss

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