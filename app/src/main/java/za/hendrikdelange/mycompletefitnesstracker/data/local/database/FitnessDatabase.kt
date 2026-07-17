package za.hendrikdelange.mycompletefitnesstracker.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.ProfileDao
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.ProfileEntity
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.BodyMeasurementEntity
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.MeasurementDao
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.ExerciseEntity
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.ExerciseDao


@Database(
    entities = [
        ProfileEntity::class,
        BodyMeasurementEntity::class,
        ExerciseEntity::class,
    ],
    version = 3,
    exportSchema = true
)
abstract class FitnessDatabase : RoomDatabase() {

    abstract fun exerciseDao(): ExerciseDao
    abstract fun profileDao(): ProfileDao


    abstract fun measurementDao(): MeasurementDao

}