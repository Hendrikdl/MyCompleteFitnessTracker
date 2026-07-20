package za.hendrikdelange.mycompletefitnesstracker.data.remote

import javax.inject.Inject
import za.hendrikdelange.mycompletefitnesstracker.data.local.remote.api.ExerciseApi
import za.hendrikdelange.mycompletefitnesstracker.data.local.remote.dto.ExerciseDto

class ExerciseRemoteDataSource @Inject constructor(
    private val api: ExerciseApi
) {

    suspend fun downloadExercises(

        limit: Int,

        offset: Int

    ): List<ExerciseDto> {

        return api
            .getExercises(
                limit,
                offset
            )
            .results

    }

}