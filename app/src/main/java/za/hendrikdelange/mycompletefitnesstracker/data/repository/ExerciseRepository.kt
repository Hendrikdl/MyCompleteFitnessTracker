package za.hendrikdelange.mycompletefitnesstracker.data.repository

import android.util.Log
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.ExerciseDao
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.ExerciseEntity
import za.hendrikdelange.mycompletefitnesstracker.data.remote.ExerciseRemoteDataSource
import za.hendrikdelange.mycompletefitnesstracker.data.local.remote.mapper.toEntity
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.WorkoutExerciseDao

class ExerciseRepository @Inject constructor(

    private val remote: ExerciseRemoteDataSource,

    private val dao: ExerciseDao,

    private val exerciseDao: WorkoutExerciseDao,


    ) {
    private  val MIN_EXERCISES = 1000

    suspend fun getExercisesNeedingSync() =
        exerciseDao.getExercisesNeedingSync()

    suspend fun markExercisesSynced(id: Long) =
        exerciseDao.markExercisesSynced(id)


    fun getExercises(): Flow<List<ExerciseEntity>> {

        return dao.getAllExercises()
    }

    fun observeExerciseCount(): Flow<Int> {

        return dao.observeExerciseCount()
    }

    suspend fun getExerciseCount(): Int {

        return dao.getExerciseCount()

    }

    fun searchExercises(
        query: String
    ) = dao.searchExercises(query)

    suspend fun initializeExerciseLibrary(
        onProgress: (Int) -> Unit
    ) {

        if (dao.getCount() < MIN_EXERCISES) {

            syncExercises(onProgress)

        }

    }

    suspend fun syncExercises(
        onProgress: (Int) -> Unit
    ) {

        val allExercises = mutableListOf<ExerciseEntity>()

        var offset = 0
        val limit = 100


        while (true) {

            val page = remote.downloadExercises(
                limit = limit,
                offset = offset
            )


            if (page.isEmpty()) break


            val entities = page.map {
                it.toEntity()
            }


            allExercises += entities


            onProgress(
                allExercises.size
            )


            offset += limit
        }


        dao.insertAll(allExercises)

        Log.d(
            "EXERCISE_SYNC",
            "Inserted ${allExercises.size} exercises into Room"
        )

        Log.d(
            "EXERCISE_SYNC",
            "Database now contains ${dao.getCount()} exercises"
        )

    }

    suspend fun updateLocalImagePath(
        id: Int,
        path: String
    ) {

        dao.updateLocalImagePath(
            id,
            path
        )

    }

    fun getExerciseById(
        id: Int
    ) =
        dao.getExerciseById(id)

    fun getExercise(
        exerciseId: Int
    ): Flow<ExerciseEntity?> =
        dao.getExerciseById(exerciseId)
}