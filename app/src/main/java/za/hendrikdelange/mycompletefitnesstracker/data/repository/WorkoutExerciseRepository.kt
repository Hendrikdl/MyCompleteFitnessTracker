package za.hendrikdelange.mycompletefitnesstracker.data.repository

import kotlinx.coroutines.flow.Flow
import za.hendrikdelange.mycompletefitnesstracker.core.sync.SyncCoordinator
import javax.inject.Inject
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.WorkoutExerciseDao
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutExerciseEntity
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutExerciseWithExercise

class WorkoutExerciseRepository @Inject constructor(

    private val dao: WorkoutExerciseDao,


) {

    suspend fun addExercise(
        exercise: WorkoutExerciseEntity
    ) {
        dao.insert(exercise)

    }

    suspend fun updateExercise(
        exercise: WorkoutExerciseEntity
    ) {
        dao.update(exercise)

    }

    suspend fun deleteExercise(
        exercise: WorkoutExerciseEntity
    ) {
        dao.delete(exercise)

    }

    suspend fun addExerciseToWorkout(
        workoutId: Long,
        exerciseId: Long
    ) {

        dao.insert(

            WorkoutExerciseEntity(

                planId = workoutId,

                exerciseId = exerciseId.toInt(),

                orderIndex = 0

            )

        )

    }

    fun getExercisesForWorkout(
        workoutId: Long
    ): Flow<List<WorkoutExerciseWithExercise>> =
        dao.getExercisesForWorkout(workoutId)

    suspend fun getExercisesNeedingSync() =
        dao.getExercisesNeedingSync()

    suspend fun markExercisesSynced(
        id: Long
    ) =
        dao.markExercisesSynced(id)

    suspend fun upsertExercise(
        exercise: WorkoutExerciseEntity
    ) {
        dao.insert(exercise)

    }

    suspend fun mergeFromCloud(
        exercise: WorkoutExerciseEntity
    ) {

        val existing =
            dao.getBySyncId(exercise.syncId)

        if (existing == null) {

            dao.insert(

                exercise.copy(
                    needsSync = false
                )

            )

            return
        }

        dao.update(

            exercise.copy(

                id = existing.id,

                needsSync = false

            )

        )

    }

}