package za.hendrikdelange.mycompletefitnesstracker.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.ProfileDao
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.ProfileEntity

@Database(
    entities = [
        ProfileEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class MyCompleteFitnessTrackerDatabase : RoomDatabase() {

    abstract fun profileDao(): ProfileDao
}