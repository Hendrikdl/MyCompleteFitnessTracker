package za.hendrikdelange.mycompletefitnesstracker.ui.profile

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ProfileProgress(
    currentStep: Int,
    totalSteps: Int
) {

    val progress = animateFloatAsState(
        targetValue = currentStep.toFloat() / totalSteps.toFloat(),
        label = "Profile Progress"
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp)
    ) {

        Text(
            text = "Step $currentStep of $totalSteps",
            fontWeight = FontWeight.Bold
        )

        LinearProgressIndicator(
            progress = { progress.value },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )

    }

}