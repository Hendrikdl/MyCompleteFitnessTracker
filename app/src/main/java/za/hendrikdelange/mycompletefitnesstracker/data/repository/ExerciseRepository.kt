package za.hendrikdelange.mycompletefitnesstracker.data.repository

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.ExerciseDao
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.ExerciseEntity
import za.hendrikdelange.mycompletefitnesstracker.data.remote.ExerciseRemoteDataSource
import za.hendrikdelange.mycompletefitnesstracker.data.remote.mapper.toEntity
import android.util.Log

class ExerciseRepository @Inject constructor(

    private val remote: ExerciseRemoteDataSource,

    private val dao: ExerciseDao,


) {
    private  val MIN_EXERCISES = 1000


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

    }
}