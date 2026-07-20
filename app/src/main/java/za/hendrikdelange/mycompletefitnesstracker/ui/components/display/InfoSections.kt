package za.hendrikdelange.mycompletefitnesstracker.ui.components.display

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import za.hendrikdelange.mycompletefitnesstracker.ui.theme.FitnessDesign

@Composable
fun InfoSection(

    title: String,

    value: String?

) {

    Column(

        verticalArrangement = Arrangement.spacedBy(
            FitnessDesign.spacing.ExtraSmall
        )

    ) {

        Text(

            text = title,

            style = FitnessDesign.typography.Title,

            color = FitnessDesign.colors.Primary

        )

        Text(

            text = value ?: "Not available",

            style = FitnessDesign.typography.Body,

            color = FitnessDesign.colors.TextPrimary

        )

    }

}