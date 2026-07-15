package za.hendrikdelange.mycompletefitnesstracker.ui.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ProfileSetupScreen(
    onComplete: () -> Unit
) {

    var currentStep by remember {
        mutableIntStateOf(1)
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.Center
    ) {


        Text(
            text = "Profile Setup Step $currentStep / 3"
        )


        when (currentStep) {

            1 -> {
                ProfileStepPersonal()
            }


            2 -> {
                ProfileStepFitness()
            }


            3 -> {
                ProfileStepMeasurements()
            }

        }


        Button(

            onClick = {

                if (currentStep < 3) {

                    currentStep++

                } else {

                    onComplete()

                }

            }

        ) {

            Text(
                text =
                    if (currentStep < 3)
                        "Next"
                    else
                        "Save Profile"
            )

        }

    }

}