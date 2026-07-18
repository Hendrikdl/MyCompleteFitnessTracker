package za.hendrikdelange.mycompletefitnesstracker.data.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.ExerciseEntity
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutExerciseEntity

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

    @Delete
    suspend fun delete(
        exercise: WorkoutExerciseEntity
    )

}