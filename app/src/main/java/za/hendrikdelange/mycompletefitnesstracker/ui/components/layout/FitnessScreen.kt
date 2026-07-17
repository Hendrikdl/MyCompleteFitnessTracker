package za.hendrikdelange.mycompletefitnesstracker.ui.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import za.hendrikdelange.mycompletefitnesstracker.ui.theme.FitnessDesign

@Composable
fun FitnessScreen(

    modifier: Modifier = Modifier,

    content: @Composable ColumnScope.() -> Unit

) {

    Column(

        modifier = modifier
            .fillMaxSize()
            .background(FitnessDesign.colors.Background)
            .padding(FitnessDesign.spacing.Medium)
            .navigationBarsPadding(),

        content = content

    )

}