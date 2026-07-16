package za.hendrikdelange.mycompletefitnesstracker.ui.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.Colors
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.Spacing

@Composable
fun FitnessScreen(
    content: @Composable () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Colors.Background)
            .padding(Spacing.Large)
    ) {

        content()

    }

}