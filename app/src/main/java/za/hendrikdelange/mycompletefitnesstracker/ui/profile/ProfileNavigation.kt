package za.hendrikdelange.mycompletefitnesstracker.ui.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import za.hendrikdelange.mycompletefitnesstracker.ui.components.buttons.FitnessButton

@Composable
fun ProfileNavigation(
    currentStep: Int,
    totalSteps: Int,
    canContinue: Boolean,
    onPrevious: () -> Unit,
    onNext: () -> Unit,
    onFinish: () -> Unit
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        if (currentStep > 1) {

            OutlinedButton(
                onClick = onPrevious
            ) {

                Text("Previous")

            }

        }

        val buttonText =
            if (currentStep == totalSteps)
                "Finish"
            else
                "Next"

        FitnessButton(

            text = buttonText,

            enabled = canContinue,

            onClick = {

                if (currentStep == totalSteps)
                    onFinish()
                else
                    onNext()

            }

        )

            }

}