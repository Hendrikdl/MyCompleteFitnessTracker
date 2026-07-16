package za.hendrikdelange.mycompletefitnesstracker.ui.components.cards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.Shapes
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.Colors
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.Spacing



@Composable
fun FitnessCard(

    modifier: Modifier = Modifier,

    content: @Composable ColumnScope.() -> Unit

) {

    Card(

        modifier = modifier,

        shape = Shapes.Medium,

        colors = CardDefaults.cardColors(

            containerColor = Colors.Card

        ),

        elevation = CardDefaults.cardElevation(

            defaultElevation = 8.dp

        )

    ) {

        Column(

            modifier = Modifier.padding(

                Spacing.Medium

            ),

            content = content

        )

    }

}