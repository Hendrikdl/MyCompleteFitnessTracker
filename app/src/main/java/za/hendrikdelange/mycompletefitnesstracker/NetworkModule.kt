package za.hendrikdelange.mycompletefitnesstracker.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import za.hendrikdelange.mycompletefitnesstracker.data.local.remote.api.ExerciseApi
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    private const val BASE_URL =
        "https://wger.de/api/v2/"


    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {

        return OkHttpClient.Builder()
            .build()

    }


    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient
    ): Retrofit {


        return Retrofit.Builder()

            .baseUrl(BASE_URL)

            .client(client)

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