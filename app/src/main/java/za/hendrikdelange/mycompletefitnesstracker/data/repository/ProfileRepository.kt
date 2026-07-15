package za.hendrikdelange.mycompletefitnesstracker.data.repository

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.MeasurementDao
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.ProfileDao
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.BodyMeasurementEntity
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.ProfileEntity


@Singleton
class ProfileRepository @Inject constructor(
    private val profileDao: ProfileDao,
    private val measurementDao: MeasurementDao
) {


    fun getProfile(
        uid: String
    ): Flow<ProfileEntity?> {

        return profileDao.getProfile(uid)

    }


    suspend fun saveProfile(
        profile: ProfileEntity
    ) {

        profileDao.insert(profile)

    }


    fun getMeasurements(
        uid: String
    ): Flow<List<BodyMeasurementEntity>> {

        return measurementDao.getMeasurements(uid)

    }


    suspend fun saveMeasurement(
        measurement: BodyMeasurementEntity
    ) {

        measurementDao.insertMeasurement(measurement)

    }

}