package za.hendrikdelange.mycompletefitnesstracker.data.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutPlanEntity
import za.hendrikdelange.mycompletefitnesstracker.data.model.WorkoutWithExerciseCount

@Dao
interface WorkoutPlanDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(
        workout: WorkoutPlanEntity
    ): Long

    @Update
    suspend fun update(
        workout: WorkoutPlanEntity
   )

    @Query("""
SELECT
    workout_plans.*,
    COUNT(workout_exercises.id) AS exerciseCount
FROM workout_plans
LEFT JOIN workout_exercises
ON workout_plans.id = workout_exercises.planId
WHERE workout_plans.isDeleted = 0
GROUP BY workout_plans.id
ORDER BY workout_plans.createdDate DESC
""")
    fun getWorkoutsWithExerciseCount():
            Flow<List<WorkoutWithExerciseCount>>

    @Query("DELETE FROM workout_plans WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Delete
    suspend fun delete(workout: WorkoutPlanEntity)

    @Query("""
SELECT *
FROM workout_plans
WHERE syncId = :syncId
LIMIT 1
""")
    suspend fun getBySyncId(
        syncId: String
    ): WorkoutPlanEntity?


    @Query("""
SELECT *
FROM workout_plans
WHERE needsSync = 1
""")
    suspend fun getPlansNeedingSync(): List<WorkoutPlanEntity>

    @Query("""
UPDATE workout_plans
SET needsSync = 0
WHERE id = :id
""")
    suspend fun markPlanSynced(id: Long)

    @Delete
    suspend fun deleteWorkout(
        workout: WorkoutPlanEntity
    )

    @Query("""
UPDATE workout_plans
SET
    isDeleted = 1,
    needsSync = 1,
    lastModified = :lastModified
WHERE id = :id
""")
    suspend fun markDeleted(
        id: Long,
        lastModified: Long = System.currentTimeMillis()
    )

    @Query("""
SELECT *
FROM workout_plans
WHERE isDeleted = 0
ORDER BY createdDate DESC
""")
    fun getWorkouts(): Flow<List<WorkoutPlanEntity>>


    @Query("""
        SELECT *
        FROM workout_plans
        WHERE isDeleted = 0
        ORDER BY name
    """)
    fun getAllWorkouts(): Flow<List<WorkoutPlanEntity>>



    @Query(
        "SELECT * FROM workout_plans WHERE id = :workoutId"
    )
    fun getWorkoutById(
        workoutId: Long
    ): Flow<WorkoutPlanEntity?>

}