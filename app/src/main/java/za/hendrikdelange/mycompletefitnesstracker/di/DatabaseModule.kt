package za.hendrikdelange.mycompletefitnesstracker.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
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
            "my_complete_fitness_tracker.db"
        ).build()
    }

    @Provides
    fun provideProfileDao(
        database: MyCompleteFitnessTrackerDatabase
    ) = database.profileDao()
}