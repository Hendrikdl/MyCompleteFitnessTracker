package za.hendrikdelange.mycompletefitnesstracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutPlanEntity
import za.hendrikdelange.mycompletefitnesstracker.data.model.WorkoutCategory
import za.hendrikdelange.mycompletefitnesstracker.data.repository.WorkoutRepository

@HiltViewModel
class WorkoutViewModel @Inject constructor(

    private val repository: WorkoutRepository

) : ViewModel() {

    val workouts =
        repository
            .getWorkouts()
            .stateIn(

                viewModelScope,

                SharingStarted.WhileSubscribed(5000),

                emptyList()

            )

    fun createWorkout(

        name: String,

        category: WorkoutCategory,

        dayOfWeek: Int,


    ) {

        viewModelScope.launch {

            repository.createWorkout(

                WorkoutPlanEntity(

                    name = name,

                    category = category.name,

                    dayOfWeek = dayOfWeek

                )

            )

        }

    }

    fun addExerciseToWorkout(

        workoutId: Long,

        exerciseId: Long

    ) {

        viewModelScope.launch {

            repository.addExerciseToWorkout(

                workoutId,

                exerciseId

            )

        }

    }

    fun getExercisesForWorkout(

        workoutId: Long

    ) = repository.getExercisesForWorkout(workoutId)

    fun getWorkout(

        workoutId: Long

    ) = repository.getWorkoutById(workoutId)

}