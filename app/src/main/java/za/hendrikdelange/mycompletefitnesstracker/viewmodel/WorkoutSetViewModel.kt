package za.hendrikdelange.mycompletefitnesstracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import za.hendrikdelange.mycompletefitnesstracker.core.sync.SyncCoordinator
import javax.inject.Inject
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutSetEntity
import za.hendrikdelange.mycompletefitnesstracker.data.repository.WorkoutSetRepository

@HiltViewModel
class WorkoutSetViewModel @Inject constructor(

    private val repository: WorkoutSetRepository,
    private val syncCoordinator: SyncCoordinator

) : ViewModel() {

    fun addSet(
        set: WorkoutSetEntity
    ) {

        viewModelScope.launch {

            repository.addSet(set)
            syncCoordinator.requestSync()

        }

    }

    fun updateSet(
        set: WorkoutSetEntity
    ) {

        viewModelScope.launch {

            repository.updateSet(set)
            syncCoordinator.requestSync()

        }

    }

    fun deleteSet(
        set: WorkoutSetEntity
    ) {

        viewModelScope.launch {

            repository.deleteSet(set)
            syncCoordinator.requestSync()

        }

    }

    fun getSets(
        workoutExerciseId: Long
    ) = repository.getSets(workoutExerciseId)

}