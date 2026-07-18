package za.hendrikdelange.mycompletefitnesstracker.ui.components.cards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.Colors.TextPrimary
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.Colors.TextSecondary
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.AppTypography.Heading
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.AppTypography.Title

@Composable
fun ExerciseLibraryHeader(
    count: Int
) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {


        Text(
            text = "Exercise Library",
            style = Heading,
            color = TextPrimary
        )


        Text(
            text = "$count exercises available",
            style = Title,
            color = TextSecondary
        )

    }

}