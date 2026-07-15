package za.hendrikdelange.mycompletefitnesstracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import za.hendrikdelange.mycompletefitnesstracker.data.repository.ProfileRepository


@HiltViewModel
class ProfileCheckViewModel @Inject constructor(
    private val repository: ProfileRepository
) : ViewModel() {


    private val _hasProfile = MutableStateFlow<Boolean?>(null)

    val hasProfile = _hasProfile.asStateFlow()



    fun checkProfile(
        uid: String
    ) {

        viewModelScope.launch {

            repository
                .getProfile(uid)
                .collect { profile ->

                    _hasProfile.value = profile != null

                }

        }

    }

}