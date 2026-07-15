package za.hendrikdelange.mycompletefitnesstracker.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.MeasurementDao
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.ProfileDao
import za.hendrikdelange.mycompletefitnesstracker.data.local.database.MyCompleteFitnessTrackerDatabase


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): MyCompleteFitnessTrackerDatabase {

        return Room.databaseBuilder(
            context,
            MyCompleteFitnessTrackerDatabase::class.java,
            "fitness_database"
        )
            .fallbackToDestructiveMigration()
            .build()

    }


    @Provides
    fun provideProfileDao(
        database: MyCompleteFitnessTrackerDatabase
    ): ProfileDao {

        return database.profileDao()

    }


    @Provides
    fun provideMeasurementDao(
        database: MyCompleteFitnessTrackerDatabase
    ): MeasurementDao {

        return database.measurementDao()

    }

}