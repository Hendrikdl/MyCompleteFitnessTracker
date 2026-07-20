package za.hendrikdelange.mycompletefitnesstracker.data.local.remote.api

import retrofit2.http.GET
import retrofit2.http.Query
import za.hendrikdelange.mycompletefitnesstracker.data.remote.dto.ExerciseResponseDto

interface ExerciseApi {

    @GET("exerciseinfo/")
    suspend fun getExercises(

        @Query("limit")
        limit: Int = 100,

        @Query("offset")
        offset: Int = 0

    ): ExerciseResponseDto

}