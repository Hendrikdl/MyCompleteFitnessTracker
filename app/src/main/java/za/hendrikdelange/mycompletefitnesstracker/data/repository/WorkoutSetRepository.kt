package za.hendrikdelange.mycompletefitnesstracker.data.repository

import kotlinx.coroutines.flow.Flow
import za.hendrikdelange.mycompletefitnesstracker.core.sync.SyncCoordinator
import javax.inject.Inject
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.WorkoutSetDao
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutSetEntity

class WorkoutSetRepository @Inject constructor(

    private val dao: WorkoutSetDao,

) {

    suspend fun addSet(
        set: WorkoutSetEntity
    ) {
        dao.insert(set)

    }

    suspend fun updateSet(
        set: WorkoutSetEntity
    ) {
        dao.update(set)

    }

    suspend fun deleteSet(
        set: WorkoutSetEntity
    ) {
        dao.delete(set)

    }

    fun getSets(
        workoutExerciseId: Long
    ): Flow<List<WorkoutSetEntity>> =
        dao.getSets(workoutExerciseId)

    suspend fun getSetsNeedingSync() =
        dao.getSetsNeedingSync()


    suspend fun markSetsSynced(
        id: Long
    ) =
        dao.markSetsSynced(id)

    suspend fun upsertSet(
        set: WorkoutSetEntity
    ) {
        dao.insert(set)

    }

}