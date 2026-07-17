package za.hendrikdelange.mycompletefitnesstracker.data.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutSetEntity

@Dao
interface WorkoutSetDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(
        set: WorkoutSetEntity
    )

    @Update
    suspend fun update(
        set: WorkoutSetEntity
    )

    @Delete
    suspend fun delete(
        set: WorkoutSetEntity
    )

    @Query("""
        SELECT *
        FROM workout_sets
        WHERE workoutExerciseId = :exerciseId
        ORDER BY setNumber
    """)
    fun getSets(
        exerciseId: Long
    ): Flow<List<WorkoutSetEntity>>

}