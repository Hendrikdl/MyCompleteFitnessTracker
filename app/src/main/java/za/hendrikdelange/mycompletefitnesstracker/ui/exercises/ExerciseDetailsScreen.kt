package za.hendrikdelange.mycompletefitnesstracker.ui.exercises

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import za.hendrikdelange.mycompletefitnesstracker.ui.components.chips.FitnessChipGroup
import za.hendrikdelange.mycompletefitnesstracker.ui.components.header.FitnessHeader
import za.hendrikdelange.mycompletefitnesstracker.ui.theme.FitnessDesign
import za.hendrikdelange.mycompletefitnesstracker.viewmodel.ExerciseDetailsViewModel
import za.hendrikdelange.mycompletefitnesstracker.ui.components.display.InfoSection

@Composable
fun ExerciseDetailsScreen(

    exerciseId: Int,

    viewModel: ExerciseDetailsViewModel = hiltViewModel()

) {

    val exercise by viewModel.exercise.collectAsState(initial = null)

    exercise?.let { exercise ->
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            FitnessHeader(
                title = "Exercise Details",
                onBackClick = {
                    //we'll hook this up next
                }
            )

            LazyColumn(

                modifier = Modifier.fillMaxSize(),

                contentPadding = PaddingValues(
                    FitnessDesign.spacing.Medium
                ),

                verticalArrangement = Arrangement.spacedBy(
                    FitnessDesign.spacing.Medium
                )

            ) {
                item {

                    Text(

                        text = exercise.name,

                        style = FitnessDesign.typography.Heading,

                        color = FitnessDesign.colors.TextPrimary

                    )

                }

                item {

                    Box(

                        modifier = Modifier.fillMaxWidth(),

                        contentAlignment = Alignment.Center

                    ) {

                        AsyncImage(

                            model = exercise.imageUrl,

                            contentDescription = exercise.name,

                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(220.dp)

                        )

                    }

                }

                item {

                    InfoSection(

                        title = "Category",
                        value = exercise.category

                    )

                }

                item {

                    AsyncImage(

                        model = exercise.imageUrl,

                        contentDescription = exercise.name,

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(220.dp)

                    )

                }
                item {

                    InfoSection(

                        title = "Equipment",

                        value = exercise.equipment

                    )

                }

                item {

                    FitnessChipGroup(

                        title = "Target Muscles",

                        chips = exercise.muscleGroup
                            ?.split(",")
                            ?.map { it.trim() }
                            ?.filter { it.isNotBlank() }
                            ?: emptyList()

                    )

                }

                item {

                    InfoSection(

                        title = "Instructions",

                        value = exercise.description

                    )

                }

            }
        }
    }
}