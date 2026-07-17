package za.hendrikdelange.mycompletefitnesstracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
import za.hendrikdelange.mycompletefitnesstracker.data.repository.ExerciseRepository

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

    init {

        viewModelScope.launch {

            repository.initializeExerciseLibrary()

        }

    }

    fun onSearchChanged(
        text: String
    ) {

        _searchText.value = text

    }

}