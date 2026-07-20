package za.hendrikdelange.mycompletefitnesstracker.ui.components.header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import za.hendrikdelange.mycompletefitnesstracker.ui.theme.FitnessDesign

@Composable
fun FitnessHeader(

    title: String,

    onBackClick: () -> Unit

) {

    Row(

        modifier = Modifier.fillMaxWidth(),

        verticalAlignment = Alignment.CenterVertically,

        horizontalArrangement = Arrangement.spacedBy(
            FitnessDesign.spacing.Small
        )

    ) {

        IconButton(

            onClick = onBackClick

        ) {

            Icon(

                imageVector = Icons.AutoMirrored.Filled.ArrowBack,

                contentDescription = "Back",

                tint = FitnessDesign.colors.Primary

            )

        }

        Text(

            text = title,

            style = FitnessDesign.typography.Heading,

            color = FitnessDesign.colors.TextPrimary

        )

    }

}

class InfoSection {
}