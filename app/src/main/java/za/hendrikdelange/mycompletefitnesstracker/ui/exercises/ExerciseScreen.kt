package za.hendrikdelange.mycompletefitnesstracker.ui.exercises

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import za.hendrikdelange.mycompletefitnesstracker.ui.components.cards.ExerciseLibraryHeader
import za.hendrikdelange.mycompletefitnesstracker.ui.components.input.FitnessSearchBar
import za.hendrikdelange.mycompletefitnesstracker.ui.theme.FitnessDesign
import za.hendrikdelange.mycompletefitnesstracker.viewmodel.ExerciseViewModel

@Composable
fun ExerciseScreen(

    viewModel: ExerciseViewModel = hiltViewModel()

) {

    val search by viewModel.searchText.collectAsState()

    val exercises by viewModel.exercises.collectAsState()

    val count by viewModel.exerciseCount.collectAsState()

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(FitnessDesign.colors.Background)
            .padding(FitnessDesign.spacing.Medium),

        verticalArrangement = Arrangement.spacedBy(
            FitnessDesign.spacing.Medium
        )

    ) {

        ExerciseLibraryHeader(
            count = count
        )

        FitnessSearchBar(

            value = search,

            onValueChange = viewModel::onSearchChanged

        )

        LazyColumn(

            verticalArrangement = Arrangement.spacedBy(
                FitnessDesign.spacing.Small
            )

        ) {

            items(exercises) { exercise ->

                ExerciseCard(
                    exercise = exercise
                )

            }

        }

    }

}