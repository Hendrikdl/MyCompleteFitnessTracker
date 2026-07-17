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

    @Query("""
        SELECT *
        FROM workout_plans
        WHERE id = :id
    """)
    suspend fun getWorkoutById(
        id: Long
    ): WorkoutPlanEntity?

}