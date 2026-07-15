package za.hendrikdelange.mycompletefitnesstracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.BodyMeasurementEntity
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.ProfileEntity
import za.hendrikdelange.mycompletefitnesstracker.data.repository.ProfileRepository


@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: ProfileRepository
) : ViewModel() {


    // Personal Information

    private val _firstName = MutableStateFlow("")
    val firstName = _firstName.asStateFlow()


    private val _surname = MutableStateFlow("")
    val surname = _surname.asStateFlow()


    private val _dateOfBirth = MutableStateFlow("")
    val dateOfBirth = _dateOfBirth.asStateFlow()


    private val _gender = MutableStateFlow("")
    val gender = _gender.asStateFlow()


    // Fitness Information

    private val _fitnessGoal = MutableStateFlow("")
    val fitnessGoal = _fitnessGoal.asStateFlow()


    private val _experienceLevel = MutableStateFlow("")
    val experienceLevel = _experienceLevel.asStateFlow()


    // Measurements

    private val _heightCm = MutableStateFlow("")
    val heightCm = _heightCm.asStateFlow()


    private val _weightKg = MutableStateFlow("")
    val weightKg = _weightKg.asStateFlow()


    private val _waistCm = MutableStateFlow("")
    val waistCm = _waistCm.asStateFlow()


    private val _chestCm = MutableStateFlow("")
    val chestCm = _chestCm.asStateFlow()


    private val _bicepLeftCm = MutableStateFlow("")
    val bicepLeftCm = _bicepLeftCm.asStateFlow()


    private val _bicepRightCm = MutableStateFlow("")
    val bicepRightCm = _bicepRightCm.asStateFlow()


    private val _thighCm = MutableStateFlow("")
    val thighCm = _thighCm.asStateFlow()


    private val _calfCm = MutableStateFlow("")
    val calfCm = _calfCm.asStateFlow()


    // Update functions

    fun updateFirstName(value: String) {
        _firstName.value = value
    }


    fun updateSurname(value: String) {
        _surname.value = value
    }


    fun updateDateOfBirth(value: String) {
        _dateOfBirth.value = value
    }


    fun updateGender(value: String) {
        _gender.value = value
    }


    fun updateFitnessGoal(value: String) {
        _fitnessGoal.value = value
    }


    fun updateExperienceLevel(value: String) {
        _experienceLevel.value = value
    }


    fun updateHeight(value: String) {
        _heightCm.value = value
    }


    fun updateWeight(value: String) {
        _weightKg.value = value
    }


    fun updateWaist(value: String) {
        _waistCm.value = value
    }


    fun updateChest(value: String) {
        _chestCm.value = value
    }


    fun updateBicepLeft(value: String) {
        _bicepLeftCm.value = value
    }


    fun updateBicepRight(value: String) {
        _bicepRightCm.value = value
    }


    fun updateThigh(value: String) {
        _thighCm.value = value
    }


    fun updateCalf(value: String) {
        _calfCm.value = value
    }


    fun saveProfile(
        firebaseUid: String,
        onSaved: () -> Unit
    ) {

        viewModelScope.launch {

            val profile = ProfileEntity(

                firebaseUid = firebaseUid,
                firstName = _firstName.value,
                surname = _surname.value,
                dateOfBirth = _dateOfBirth.value,
                gender = _gender.value,
                fitnessGoal = _fitnessGoal.value,
                experienceLevel = _experienceLevel.value

            )


            repository.saveProfile(profile)


            val measurement = BodyMeasurementEntity(

                firebaseUid = firebaseUid,

                weightKg = _weightKg.value.toDoubleOrNull() ?: 0.0,

                heightCm = _heightCm.value.toDoubleOrNull() ?: 0.0,

                waistCm = _waistCm.value.toDoubleOrNull(),

                chestCm = _chestCm.value.toDoubleOrNull(),

                bicepLeftCm = _bicepLeftCm.value.toDoubleOrNull(),

                bicepRightCm = _bicepRightCm.value.toDoubleOrNull(),

                thighCm = _thighCm.value.toDoubleOrNull(),

                calfCm = _calfCm.value.toDoubleOrNull()
            )


            repository.saveMeasurement(measurement)


            onSaved()

        }

    }
}