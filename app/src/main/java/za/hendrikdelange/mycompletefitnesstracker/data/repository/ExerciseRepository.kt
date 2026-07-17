package za.hendrikdelange.mycompletefitnesstracker.data.repository

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.ExerciseDao
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.ExerciseEntity
import za.hendrikdelange.mycompletefitnesstracker.data.remote.ExerciseRemoteDataSource
import za.hendrikdelange.mycompletefitnesstracker.data.remote.mapper.toEntity

class ExerciseRepository @Inject constructor(

    private val remote: ExerciseRemoteDataSource,

    private val dao: ExerciseDao

) {

    fun getExercises(): Flow<List<ExerciseEntity>> {

        return dao.getAllExercises()

    }

    fun searchExercises(
        query: String
    ) = dao.searchExercises(query)

    suspend fun initializeExerciseLibrary() {

        if (dao.getCount() == 0) {

            syncExercises()

        }

    }

    suspend fun syncExercises() {

        val exercises =

            remote
                .downloadExercises()
                .map {

                    it.toEntity()

                }

        dao.insertAll(exercises)

    }

}