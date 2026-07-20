package za.hendrikdelange.mycompletefitnesstracker.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.ExerciseEntity
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutPlanEntity
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutExerciseEntity

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

    @Query(
        """
        SELECT *
        FROM exercise_library
        WHERE name LIKE '%' || :search || '%'
        ORDER BY name
    """
    )
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


    @Query("""
UPDATE exercise_library
SET localImagePath = :path
WHERE id = :id
""")
    suspend fun updateLocalImagePath(
        id: Int,
        path: String
    )


    @Query("""
SELECT *
FROM exercise_library
WHERE id = :id
LIMIT 1
""")
    fun getExerciseById(
        id: Int
    ): Flow<ExerciseEntity?>

}