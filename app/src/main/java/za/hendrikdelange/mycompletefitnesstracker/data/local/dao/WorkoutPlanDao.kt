package za.hendrikdelange.mycompletefitnesstracker.data.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutPlanEntity

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
    suspend fun delete(
        workout: WorkoutPlanEntity
    )

    @Query("""
        SELECT *
        FROM workout_plans
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