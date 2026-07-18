package za.hendrikdelange.mycompletefitnesstracker.core.startup

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

@HiltViewModel
class StartupViewModel @Inject constructor(

    private val startupManager: StartupManager

) : ViewModel() {

    private val _state =
        MutableStateFlow(StartupState())

    val state = _state.asStateFlow()

    private val _startupResult =
        MutableStateFlow<StartupResult?>(null)

    val startupResult =
        _startupResult.asStateFlow()

    init {

        initialize()

    }

    private fun initialize() {

        viewModelScope.launch {

            _state.value = StartupState(

                step = StartupStep.INITIALIZING,

                message = "Initializing...",

                progress = 0.2f

            )

            _startupResult.value =
                startupManager.initialize()

        }

    }

}