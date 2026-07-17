package za.hendrikdelange.mycompletefitnesstracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
import za.hendrikdelange.mycompletefitnesstracker.data.repository.ExerciseRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import za.hendrikdelange.mycompletefitnesstracker.data.model.ExerciseSyncState

@HiltViewModel
class ExerciseViewModel @Inject constructor(

    private val repository: ExerciseRepository

) : ViewModel() {

    private val _searchText = MutableStateFlow("")

    val searchText = _searchText.asStateFlow()

    val exercises = searchText
        .debounce(300)
        .flatMapLatest { query ->

            if (query.isBlank()) {

                repository.getExercises()

            } else {

                repository.searchExercises(query)

            }

        }
        .stateIn(

            scope = viewModelScope,

            started = SharingStarted.WhileSubscribed(5000),

            initialValue = emptyList()

        )


    private val _syncState =
        MutableStateFlow<ExerciseSyncState>(
            ExerciseSyncState.Idle
        )

    val syncState =
        _syncState.asStateFlow()

    fun onSearchChanged(
        text: String
    ) {

        _searchText.value = text

    }

    val exerciseCount = repository
        .observeExerciseCount()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = 0
        )

    fun initializeLibrary() {

        viewModelScope.launch {

            try {

                _syncState.value =
                    ExerciseSyncState.Checking


                repository.initializeExerciseLibrary {

                        count ->

                    _syncState.value =
                        ExerciseSyncState.Downloading(
                            count
                        )

                }


                val total =
                    repository.getExerciseCount()


                _syncState.value =
                    ExerciseSyncState.Complete(
                        total
                    )


            } catch (e: Exception) {

                _syncState.value =
                    ExerciseSyncState.Error(
                        e.message ?: "Unknown error"
                    )

            }

        }

    }

    init {
        initializeLibrary()
    }


}