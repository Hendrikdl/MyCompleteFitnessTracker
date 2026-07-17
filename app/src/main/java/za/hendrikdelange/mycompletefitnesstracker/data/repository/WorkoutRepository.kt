package za.hendrikdelange.mycompletefitnesstracker.data.repository

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.WorkoutExerciseDao
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.WorkoutPlanDao
import za.hendrikdelange.mycompletefitnesstracker.data.local.dao.WorkoutSetDao
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutExerciseEntity
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutPlanEntity
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutSetEntity

class WorkoutRepository @Inject constructor(

    private val workoutDao: WorkoutPlanDao,

    private val exerciseDao: WorkoutExerciseDao,

    private val setDao: WorkoutSetDao

) {

    fun getWorkouts(): Flow<List<WorkoutPlanEntity>> =
        workoutDao.getAllWorkouts()

    suspend fun createWorkout(
        workout: WorkoutPlanEntity
    ): Long {

        return workoutDao.insert(workout)

    }

    suspend fun updateWorkout(
        workout: WorkoutPlanEntity
    ) {

        workoutDao.update(workout)

    }

    suspend fun deleteWorkout(
        workout: WorkoutPlanEntity
    ) {

        workoutDao.delete(workout)

    }

    suspend fun addExercise(
        exercise: WorkoutExerciseEntity
    ) {

        exerciseDao.insert(exercise)

    }

    fun getExercisesForWorkout(
        workoutId: Long
    ) = exerciseDao.getExercisesForWorkout(workoutId)

    suspend fun addSet(
        set: WorkoutSetEntity
    ) {

        setDao.insert(set)

    }

    fun getSets(
        workoutExerciseId: Long
    ) = setDao.getSets(workoutExerciseId)

}