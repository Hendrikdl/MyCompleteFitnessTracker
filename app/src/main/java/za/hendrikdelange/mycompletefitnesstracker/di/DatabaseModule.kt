package za.hendrikdelange.mycompletefitnesstracker.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.ExerciseDao
import javax.inject.Singleton
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.MeasurementDao
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.ProfileDao
import za.hendrikdelange.mycompletefitnesstracker.data.local.database.FitnessDatabase


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): FitnessDatabase {

        return Room.databaseBuilder(
            context,
            FitnessDatabase::class.java,
            "fitness_database"
        )
            .fallbackToDestructiveMigration()
            .build()

    }


    @Provides
    fun provideProfileDao(
        database: FitnessDatabase
    ): ProfileDao {

        return database.profileDao()

    }

    @Provides
    fun provideExerciseDao(
        database: FitnessDatabase
    ): ExerciseDao {
        return database.exerciseDao()
    }


    @Provides
    fun provideMeasurementDao(
        database: FitnessDatabase
    ): MeasurementDao {

        return database.measurementDao()

    }

}