package za.hendrikdelange.mycompletefitnesstracker.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.filterNotNull
import javax.inject.Inject
import za.hendrikdelange.mycompletefitnesstracker.data.repository.ExerciseRepository

@HiltViewModel
class ExerciseDetailsViewModel @Inject constructor(

    savedStateHandle: SavedStateHandle,

    repository: ExerciseRepository

) : ViewModel() {

    private val exerciseId =
        checkNotNull(
            savedStateHandle.get<String>("exerciseId")
        ).toInt()

    val exercise =
        repository
            .getExerciseById(exerciseId)
            .filterNotNull()

}