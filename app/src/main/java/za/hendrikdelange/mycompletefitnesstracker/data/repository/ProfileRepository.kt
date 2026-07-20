package za.hendrikdelange.mycompletefitnesstracker.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import za.hendrikdelange.mycompletefitnesstracker.core.sync.SyncCoordinator
import javax.inject.Inject
import javax.inject.Singleton
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.MeasurementDao
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.ProfileDao
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.BodyMeasurementEntity
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.ProfileEntity


@Singleton
class ProfileRepository @Inject constructor(
    private val profileDao: ProfileDao,
    private val measurementDao: MeasurementDao,
    private val firestore: FirebaseFirestore,

) {


    fun getProfile(
        uid: String
    ): Flow<ProfileEntity?> {

        return profileDao.getProfile(uid)

    }

    suspend fun getProfilesNeedingSync(): List<ProfileEntity> {

        return profileDao.getProfilesNeedingSync()

    }

    suspend fun upsertProfile(
        profile: ProfileEntity
    ) {

        profileDao.insert(profile)


    }

    suspend fun markProfileSynced(
        uid: String
    ) {

        profileDao.markProfileSynced(uid)


    }

    suspend fun downloadProfile(
        uid: String
    ): Boolean {

        // TODO:
        // Download profile from Firestore
        // Save it to Room

        return false

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