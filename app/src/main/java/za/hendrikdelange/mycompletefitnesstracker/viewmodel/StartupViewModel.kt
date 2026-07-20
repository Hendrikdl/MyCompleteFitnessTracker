package za.hendrikdelange.mycompletefitnesstracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import za.hendrikdelange.mycompletefitnesstracker.core.startup.StartupManager
import za.hendrikdelange.mycompletefitnesstracker.core.startup.StartupProgress
import za.hendrikdelange.mycompletefitnesstracker.core.startup.StartupResult

@HiltViewModel
class StartupViewModel @Inject constructor(

    private val startupManager: StartupManager

) : ViewModel() {

    val state = startupManager.progress

    private val _result =
        MutableStateFlow<StartupResult?>(null)

    val result = _result.asStateFlow()

    fun start() {

        viewModelScope.launch {

            _result.value =
                startupManager.initialize()

        }

    }

}