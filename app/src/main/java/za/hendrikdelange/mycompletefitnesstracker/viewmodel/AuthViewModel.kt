package za.hendrikdelange.mycompletefitnesstracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import za.hendrikdelange.mycompletefitnesstracker.data.repository.AuthRepository
import javax.inject.Inject


@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {


    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()


    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage = _errorMessage.asStateFlow()


    fun register(
        email: String,
        password: String,
        onSuccess: () -> Unit
    ) {

        viewModelScope.launch {

            _loading.value = true
            _errorMessage.value = null


            val result = authRepository.register(
                email,
                password
            )


            _loading.value = false


            result
                .onSuccess {
                    onSuccess()
                }
                .onFailure {

                    _errorMessage.value =
                        it.message ?: "Registration failed"

                }

        }

    }


    fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit
    ) {

        viewModelScope.launch {

            _loading.value = true
            _errorMessage.value = null


            val result = authRepository.login(
                email,
                password
            )


            _loading.value = false


            result
                .onSuccess {
                    onSuccess()
                }
                .onFailure {

                    _errorMessage.value =
                        it.message ?: "Login failed"

                }

        }

    }


    fun logout() {

        authRepository.logout()

    }

}