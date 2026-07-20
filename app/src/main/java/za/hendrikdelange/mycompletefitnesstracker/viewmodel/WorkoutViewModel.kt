package za.hendrikdelange.mycompletefitnesstracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import za.hendrikdelange.mycompletefitnesstracker.core.sync.SyncCoordinator
import javax.inject.Inject
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutPlanEntity
import za.hendrikdelange.mycompletefitnesstracker.data.model.WorkoutCategory
import za.hendrikdelange.mycompletefitnesstracker.data.repository.WorkoutExerciseRepository
import za.hendrikdelange.mycompletefitnesstracker.data.repository.WorkoutRepository

@HiltViewModel
class WorkoutViewModel @Inject constructor(

    private val workoutRepository: WorkoutRepository,
    private val workoutExerciseRepository: WorkoutExerciseRepository,
    private val auth: FirebaseAuth,
    private val syncCoordinator: SyncCoordinator

) : ViewModel() {

    val workouts =
        workoutRepository
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

            val uid = auth.currentUser?.uid ?: return@launch

            workoutRepository.createWorkout(

                WorkoutPlanEntity(

                    firebaseUid = uid,

                    name = name,

                    category = category.name,

                    dayOfWeek = dayOfWeek

                )

            )

        }
        syncCoordinator.requestSync()
    }

    fun addExerciseToWorkout(

        workoutId: Long,

        exerciseId: Long

    ) {

        viewModelScope.launch {

            workoutExerciseRepository.addExerciseToWorkout(

                workoutId,

                exerciseId

            )
            syncCoordinator.requestSync()
        }

    }

    fun getExercisesForWorkout(

        workoutId: Long

    ) = workoutExerciseRepository.getExercisesForWorkout(workoutId)

    fun getWorkout(

        workoutId: Long

    ) = workoutRepository.getWorkoutById(workoutId)

}