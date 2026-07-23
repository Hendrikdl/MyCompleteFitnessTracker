package za.hendrikdelange.mycompletefitnesstracker.core.sync

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.ProfileEntity
import za.hendrikdelange.mycompletefitnesstracker.data.repository.ProfileRepository
import za.hendrikdelange.mycompletefitnesstracker.data.repository.WorkoutRepository
import javax.inject.Inject
import javax.inject.Singleton
import android.util.Log
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutExerciseEntity
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutPlanEntity
import za.hendrikdelange.mycompletefitnesstracker.data.repository.WorkoutExerciseRepository
import za.hendrikdelange.mycompletefitnesstracker.data.repository.WorkoutSetRepository

@Singleton
class SyncManager @Inject constructor(
    private val profileRepository: ProfileRepository,

    private val workoutRepository: WorkoutRepository,

    private val workoutExerciseRepository: WorkoutExerciseRepository,

    private val workoutSetRepository: WorkoutSetRepository,

    private val firestore: FirebaseFirestore

) {

    suspend fun synchronize() {

        Log.d("SYNCD", "Synchronization started")

        upload()

        Log.d("SYNCD", "Upload completed")

        download()

        Log.d("SYNCD", "Download completed")

    }

    private suspend fun download() {
        downloadProfiles()
        downloadWorkoutPlans()
        downloadWorkoutExercises()


    }


    private suspend fun upload() {
        uploadProfiles()
        uploadWorkoutPlans()
        uploadWorkoutExercises()
        uploadWorkoutSets()
    }

    private suspend fun uploadWorkoutExercises() {

        val exercises =
            workoutExerciseRepository.getExercisesNeedingSync()

        Log.d(
            "SYNCD",
            "Exercises needing sync = ${exercises.size}"
        )

        for (exercise in exercises) {

            Log.d(
                "SYNCD",
                "Uploading exercise ${exercise.syncId}"
            )

            userRef()
                .collection("exercises")
                .document(exercise.syncId)
                .set(exercise)
                .await()

            workoutExerciseRepository.markExercisesSynced(
                exercise.id
            )
        }
    }

    //All uploads
    private suspend fun uploadProfiles() {

        val profiles =
            profileRepository.getProfilesNeedingSync()
        Log.d("SYNCD", "profile = $profiles")

        for (profile in profiles) {

            try {

                userRef()
                    .collection("profile")
                    .document("profile")
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
    private suspend fun uploadWorkoutPlans() {

        val plans =
            workoutRepository.getPlansNeedingSync()

        for (plan in plans) {

            if (plan.isDeleted) {

                userRef()
                    .collection("workoutPlans")
                    .document(plan.syncId)
                    .delete()
                    .await()

                workoutRepository.deletePermanently(plan.id)

            } else {

                userRef()
                    .collection("workoutPlans")
                    .document(plan.syncId)
                    .set(plan)
                    .await()

                workoutRepository.markPlanSynced(plan.id)

            }

        }

    }
    private suspend fun uploadWorkoutSets() {

        val sets =
            workoutSetRepository.getSetsNeedingSync()

        for (set in sets) {

            userRef()
                .collection("workoutSets")
                .document(set.syncId)
                .set(set)
                .await()

            workoutSetRepository.markSetsSynced(
                set.id
            )

        }

    }

    //All downloads



    private suspend fun downloadWorkoutExercises() {

        val snapshot =
            userRef()
                .collection("workoutExercises")
                .get()
                .await()

        for (document in snapshot.documents) {

            val workoutExercise =
                document.toObject(
                    WorkoutExerciseEntity::class.java
                )

            if (workoutExercise != null) {

                workoutExerciseRepository
                    .mergeFromCloud(workoutExercise)

            }

        }

    }
    private suspend fun downloadProfiles() {

        try {

            val snapshot = userRef()
                .collection("profile")
                .document("profile")
                .get()
                .await()

            if (snapshot.exists()) {

                val profile =
                    snapshot.toObject(ProfileEntity::class.java)

                if (profile != null) {

                    profileRepository.upsertProfile(

                        profile.copy(
                            needsSync = false
                        )

                    )

                }

            }

        } catch (e: Exception) {

            Log.e("SYNCD", "Download failed", e)

        }

    }
    private suspend fun downloadWorkoutPlans() {

        val snapshot = userRef()
            .collection("workoutPlans")
            .get()
            .await()

        for (document in snapshot.documents) {

            val plan =
                document.toObject(
                    WorkoutPlanEntity::class.java
                )

            if (plan != null) {

                // Synchronization responsibilities:
                // - SyncManager coordinates uploads/downloads.
                // - Repositories resolve local vs. cloud data.
                // - DAOs provide storage operations.

                workoutRepository.mergeFromCloud(
                    plan
                )

            }

        }

    }


    private fun currentUid(): String =
        FirebaseAuth.getInstance().currentUser?.uid
            ?: throw IllegalStateException("No authenticated user")

    private fun userRef() =
        firestore
            .collection("users")
            .document(currentUid())
}