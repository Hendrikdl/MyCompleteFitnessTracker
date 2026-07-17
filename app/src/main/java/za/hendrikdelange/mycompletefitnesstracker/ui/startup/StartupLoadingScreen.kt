package za.hendrikdelange.mycompletefitnesstracker.ui.startup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.AppTypography
import za.hendrikdelange.mycompletefitnesstracker.ui.theme.FitnessDesign

@Composable
fun StartupLoadingScreen(

    title: String,

    message: String,

    progress: Float? = null

) {

    Box(

        modifier = Modifier
            .fillMaxSize()
            .background(FitnessDesign.colors.Background)

    ) {

        Column(

            modifier = Modifier.align(Alignment.Center),

            horizontalAlignment = Alignment.CenterHorizontally,

            verticalArrangement = Arrangement.spacedBy(
                FitnessDesign.spacing.Medium
            )

        ) {

            // Logo comes here later

            Text(

                text = title,

                style = AppTypography.Heading,

                color = FitnessDesign.colors.TextPrimary

            )

            Text(

                text = message,

                style = AppTypography.Body,

                color = FitnessDesign.colors.TextSecondary

            )

            if (progress == null) {

                CircularProgressIndicator(

                    color = FitnessDesign.colors.Primary

                )

            } else {

                LinearProgressIndicator(

                    progress = { progress },

                    modifier = Modifier.fillMaxWidth(0.7f)

                )

            }

        }

    }

}