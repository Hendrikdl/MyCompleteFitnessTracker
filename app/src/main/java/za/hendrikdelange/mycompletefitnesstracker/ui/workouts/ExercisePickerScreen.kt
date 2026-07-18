package za.hendrikdelange.mycompletefitnesstracker.ui.workouts

import androidx.compose.runtime.Composable
import za.hendrikdelange.mycompletefitnesstracker.ui.exercises.ExerciseScreen

@Composable
fun ExercisePickerScreen(

    workoutId: Long,

    onExerciseSelected: (Int) -> Unit

) {

    ExerciseScreen(

        onExerciseClick = { exercise ->

            onExerciseSelected(exercise.id)

        }

    )

}