package za.hendrikdelange.mycompletefitnesstracker.data.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.ExerciseEntity
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutExerciseEntity
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutExerciseWithExercise
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutPlanEntity

@Dao
interface WorkoutExerciseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(
        exercise: WorkoutExerciseEntity
    )

    @Update
    suspend fun update(
        exercise: WorkoutExerciseEntity
    )

    @Transaction
    @Query("""
SELECT *
FROM workout_exercises
WHERE planId = :workoutId
ORDER BY orderIndex
""")
    fun getExercisesForWorkout(
        workoutId: Long
    ): Flow<List<WorkoutExerciseWithExercise>>

    @Delete
    suspend fun delete(
        exercise: WorkoutExerciseEntity
    )

    @Query("""
SELECT *
FROM workout_exercises
WHERE syncId = :syncId
LIMIT 1
""")
    suspend fun getBySyncId(
        syncId: String
    ): WorkoutExerciseEntity?

    @Query("""
SELECT *
FROM workout_exercises
WHERE needsSync = 1
""")
    suspend fun getExercisesNeedingSync(): List<WorkoutExerciseEntity>

    @Query("""
UPDATE workout_exercises
SET needsSync = 0
WHERE id = :id
""")
    suspend fun markExercisesSynced(id: Long)


}

