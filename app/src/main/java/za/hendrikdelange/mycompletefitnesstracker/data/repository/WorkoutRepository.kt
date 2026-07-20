package za.hendrikdelange.mycompletefitnesstracker.data.repository

import kotlinx.coroutines.flow.Flow
import za.hendrikdelange.mycompletefitnesstracker.core.sync.SyncCoordinator
import javax.inject.Inject
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.WorkoutPlanDao
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.WorkoutSetDao
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutPlanEntity
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutSetEntity

class WorkoutRepository @Inject constructor(

    private val workoutDao: WorkoutPlanDao,
    private val setDao: WorkoutSetDao,

) {

    fun getWorkouts(): Flow<List<WorkoutPlanEntity>> =
        workoutDao.getAllWorkouts()

    suspend fun createWorkout(
        workout: WorkoutPlanEntity
    ): Long {

        return workoutDao.insert(workout)

    }

    suspend fun mergeFromCloud(
        plan: WorkoutPlanEntity
    ) {

        val existing =
            workoutDao.getBySyncId(plan.syncId)

        if (existing == null) {

            workoutDao.insert(

                plan.copy(
                    needsSync = false
                )

            )

        } else {

            workoutDao.update(

                plan.copy(

                    id = existing.id,

                    needsSync = false

                )

            )

        }

    }

    suspend fun updateWorkout(
        workout: WorkoutPlanEntity
    ) {

        workoutDao.update(workout)


    }

    suspend fun deleteWorkout(
        workout: WorkoutPlanEntity
    ) {

        workoutDao.delete(workout)


    }





    suspend fun getPlansNeedingSync() =
        workoutDao.getPlansNeedingSync()

    suspend fun markPlanSynced(id: Long) =
        workoutDao.markPlanSynced(id)

    suspend fun upsertPlan(plan: WorkoutPlanEntity) =
        workoutDao.insert(plan)


    fun getWorkoutById(
        workoutId: Long
    ) = workoutDao.getWorkoutById(workoutId)


    suspend fun addSet(
        set: WorkoutSetEntity
    ) {

        setDao.insert(set)

    }





    fun getSets(
        workoutExerciseId: Long
    ) = setDao.getSets(workoutExerciseId)

}