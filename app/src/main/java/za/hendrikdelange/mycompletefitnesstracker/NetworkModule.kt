package za.hendrikdelange.mycompletefitnesstracker.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import za.hendrikdelange.mycompletefitnesstracker.data.remote.api.ExerciseApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL =
        "https://wger.de/api/v2/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideExerciseApi(
        retrofit: Retrofit
    ): ExerciseApi {

        return retrofit.create(
            ExerciseApi::class.java
        )

    }

}