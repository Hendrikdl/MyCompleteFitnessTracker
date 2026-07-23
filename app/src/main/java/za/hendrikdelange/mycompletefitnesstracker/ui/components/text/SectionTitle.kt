package za.hendrikdelange.mycompletefitnesstracker.ui.components.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.FitnessDesign

@Composable
fun SectionTitle(

    text: String

) {

    Text(

        text = text,

        style = FitnessDesign.typography.TitleMedium,

        color = FitnessDesign.colors.Primary

    )

}