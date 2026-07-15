package za.hendrikdelange.mycompletefitnesstracker.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.ProfileDao
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.ProfileEntity
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.BodyMeasurementEntity
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.MeasurementDao


@Database(
    entities = [
        ProfileEntity::class,
        BodyMeasurementEntity::class
    ],
    version = 2,
    exportSchema = true
)
abstract class MyCompleteFitnessTrackerDatabase : RoomDatabase() {


    abstract fun profileDao(): ProfileDao


    abstract fun measurementDao(): MeasurementDao

}