package za.hendrikdelange.mycompletefitnesstracker.ui.exercises

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import za.hendrikdelange.mycompletefitnesstracker.ui.components.chips.FitnessChipGroup
import za.hendrikdelange.mycompletefitnesstracker.ui.components.display.ExerciseInstructions
import za.hendrikdelange.mycompletefitnesstracker.ui.components.header.FitnessHeader
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.FitnessDesign
import za.hendrikdelange.mycompletefitnesstracker.viewmodel.ExerciseDetailsViewModel

@Composable
fun ExerciseDetailsScreen(

    exerciseId: Int,

    onBackClick: () -> Unit,

    viewModel: ExerciseDetailsViewModel = hiltViewModel()

) {

    val exercise by viewModel.exercise.collectAsState(initial = null)


    exercise?.let { exercise ->
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            FitnessHeader(
                title = "Exercise Details",
                color = FitnessDesign.colors.Primary,
                onBackClick =
                    onBackClick

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

                        modifier = Modifier.fillMaxWidth(),

                        textAlign = TextAlign.Center,


                        style = FitnessDesign.typography.Heading,

                        color = FitnessDesign.colors.Primary

                    )

                }

                item {

                    Box(

                        modifier = Modifier.fillMaxWidth(),

                        contentAlignment = Alignment.Center

                    ) {

                        if (exercise.imageUrl != null) {

                            AsyncImage(

                                model = exercise.imageUrl,

                                contentDescription = exercise.name,

                                modifier = Modifier
                                    .fillMaxWidth(0.8f)
                                    .height(220.dp)
                                    .clip(RoundedCornerShape(16.dp))

                            )

                        } else {

                            Column(

                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(220.dp),

                                verticalArrangement = Arrangement.Center,

                                horizontalAlignment = Alignment.CenterHorizontally

                            ) {

                                Text(

                                    text = "No image available",

                                    style = FitnessDesign.typography.TitleMedium,

                                    color = FitnessDesign.colors.TextSecondary

                                )

                            }

                        }

                    }

                }

                item {

                    FitnessChipGroup(

                        title = "Category",

                        chips = listOfNotNull(exercise.category),

                        useAlternatingColors = true

                    )

                }


                item {

                    FitnessChipGroup(

                        title = "Equipment",

                        chips = exercise.equipment
                            ?.split(",")
                            ?.map { it.trim() }
                            ?.filter { it.isNotBlank() }
                            ?: emptyList(),

                            useAlternatingColors = true

                    )

                }

                item {

                    FitnessChipGroup(

                        title = "Target Muscles",

                        chips = exercise.muscleGroup
                            ?.split(",")
                            ?.map { it.trim() }
                            ?.filter { it.isNotBlank() }
                            ?: emptyList(),

                        useAlternatingColors = true

                    )
                }

                item {

                    ExerciseInstructions(

                        html = exercise.description

                    )

                }

            }
        }
    }
}