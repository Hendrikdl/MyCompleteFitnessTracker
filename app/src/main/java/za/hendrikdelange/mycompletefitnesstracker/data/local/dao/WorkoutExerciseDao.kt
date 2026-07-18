package za.hendrikdelange.mycompletefitnesstracker.data.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.ExerciseEntity
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutExerciseEntity
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutExerciseWithExercise

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

}