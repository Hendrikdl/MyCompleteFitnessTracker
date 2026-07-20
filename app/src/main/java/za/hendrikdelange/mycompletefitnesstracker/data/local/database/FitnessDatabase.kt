package za.hendrikdelange.mycompletefitnesstracker.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.ProfileDao
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.ProfileEntity
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.BodyMeasurementEntity
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.MeasurementDao
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.ExerciseEntity
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.ExerciseDao
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.WorkoutExerciseDao
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.WorkoutPlanDao
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.WorkoutSetDao
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutPlanEntity
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutExerciseEntity
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutSetEntity


@Database(
    entities = [
        ProfileEntity::class,
        BodyMeasurementEntity::class,
        ExerciseEntity::class,

        WorkoutPlanEntity::class,
        WorkoutExerciseEntity::class,
        WorkoutSetEntity::class
    ],
    version = 6,
    exportSchema = true
)
abstract class FitnessDatabase : RoomDatabase() {

    abstract fun exerciseDao(): ExerciseDao
    abstract fun profileDao(): ProfileDao


    abstract fun measurementDao(): MeasurementDao

    abstract fun workoutPlanDao(): WorkoutPlanDao

    abstract fun workoutExerciseDao(): WorkoutExerciseDao

    abstract fun workoutSetDao(): WorkoutSetDao

}