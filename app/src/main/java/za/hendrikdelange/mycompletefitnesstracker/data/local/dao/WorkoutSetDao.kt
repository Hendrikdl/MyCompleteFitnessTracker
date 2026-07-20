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

    @Query("""
SELECT *
FROM workout_sets
WHERE needsSync = 1
""")
    suspend fun getSetsNeedingSync(): List<WorkoutSetEntity>

    @Query("""
UPDATE workout_sets
SET needsSync = 0
WHERE id = :id
""")
    suspend fun markSetsSynced(id: Long)

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