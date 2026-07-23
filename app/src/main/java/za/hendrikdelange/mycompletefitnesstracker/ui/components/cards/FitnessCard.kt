package za.hendrikdelange.mycompletefitnesstracker.ui.components.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.FitnessDesign


@Composable
fun FitnessCard(

    modifier: Modifier = Modifier,

    content: @Composable ColumnScope.() -> Unit

) {

    Card(

        modifier = modifier
            .fillMaxWidth()
            .height(100.dp),

        shape = FitnessDesign.shapes.Medium,

        border = BorderStroke(

            1.dp,

            FitnessDesign.colors.Primary

        ),

        colors = CardDefaults.cardColors(

            containerColor = FitnessDesign.colors.Card

        ),

        elevation = CardDefaults.cardElevation(

            defaultElevation = 8.dp

        )

    ) {

        Column(

            modifier = Modifier.padding(

                FitnessDesign.spacing.Medium

            ),

            content = content

        )

    }
}