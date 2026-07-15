package za.hendrikdelange.mycompletefitnesstracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.BodyMeasurementEntity
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.ProfileEntity
import za.hendrikdelange.mycompletefitnesstracker.data.repository.ProfileRepository


@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: ProfileRepository
) : ViewModel() {


    var firstName: String = ""
    var surname: String = ""
    var dateOfBirth: String = ""
    var gender: String = ""

    var fitnessGoal: String = ""
    var experienceLevel: String = ""


    var heightCm: String = ""
    var weightKg: String = ""
    var waistCm: String = ""
    var chestCm: String = ""
    var bicepLeftCm: String = ""
    var bicepRightCm: String = ""
    var thighCm: String = ""
    var calfCm: String = ""


    fun saveProfile(
        firebaseUid: String
    ) {

        viewModelScope.launch {


            val profile = ProfileEntity(

                firebaseUid = firebaseUid,

                firstName = firstName,

                surname = surname,

                dateOfBirth = dateOfBirth,

                gender = gender,

                fitnessGoal = fitnessGoal,

                experienceLevel = experienceLevel

            )


            repository.saveProfile(profile)


            val measurement = BodyMeasurementEntity(

                firebaseUid = firebaseUid,

                weightKg = weightKg.toDoubleOrNull() ?: 0.0,

                heightCm = heightCm.toDoubleOrNull() ?: 0.0,

                waistCm = waistCm.toDoubleOrNull(),

                chestCm = chestCm.toDoubleOrNull(),

                bicepLeftCm = bicepLeftCm.toDoubleOrNull(),

                bicepRightCm = bicepRightCm.toDoubleOrNull(),

                thighCm = thighCm.toDoubleOrNull(),

                calfCm = calfCm.toDoubleOrNull()

            )


            repository.saveMeasurement(measurement)

        }

    }

}