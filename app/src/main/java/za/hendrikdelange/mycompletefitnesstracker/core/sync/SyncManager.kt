package za.hendrikdelange.mycompletefitnesstracker.core.sync

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import za.hendrikdelange.mycompletefitnesstracker.data.repository.ProfileRepository
import za.hendrikdelange.mycompletefitnesstracker.data.repository.WorkoutRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SyncManager @Inject constructor(
    private val profileRepository: ProfileRepository,

    private val workoutRepository: WorkoutRepository,

    private val firestore: FirebaseFirestore

) {

    suspend fun synchronize() {


        upload()

        download()

    }

    private fun download() {
        TODO("Not yet implemented")
    }

    private suspend fun upload() {
        uploadProfiles()
    }

    private suspend fun uploadProfiles() {

        val profiles =
            profileRepository.getProfilesNeedingSync()

        for (profile in profiles) {

            try {

                firestore
                    .collection("profiles")
                    .document(profile.firebaseUid)
                    .set(profile)
                    .await()

                profileRepository.markProfileSynced(
                    profile.firebaseUid
                )

            } catch (e: Exception) {

                // Leave needsSync = true

            }

        }

    }
}