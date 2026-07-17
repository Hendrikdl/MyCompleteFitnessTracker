package za.hendrikdelange.mycompletefitnesstracker.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.ExerciseEntity

@Dao
interface ExerciseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(
        exercises: List<ExerciseEntity>
    )

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(
        exercise: ExerciseEntity
    )

    @Query("SELECT * FROM exercise_library ORDER BY name")
    fun getAllExercises(): Flow<List<ExerciseEntity>>

    @Query("""
        SELECT *
        FROM exercise_library
        WHERE name LIKE '%' || :search || '%'
        ORDER BY name
    """)
    fun searchExercises(
        search: String
    ): Flow<List<ExerciseEntity>>

    @Query("DELETE FROM exercise_library")
    suspend fun deleteAll()

    @Query("SELECT COUNT(*) FROM exercise_library")
    suspend fun getCount(): Int

    @Query("SELECT COUNT(*) FROM exercise_library")
    fun observeExerciseCount(): Flow<Int>

    @Query("SELECT COUNT(*) FROM exercise_library")
    suspend fun getExerciseCount(): Int



}