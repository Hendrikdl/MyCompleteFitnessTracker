package za.hendrikdelange.mycompletefitnesstracker.data.model

import androidx.room.Embedded
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutPlanEntity

data class WorkoutWithExerciseCount(

    @Embedded
    val workout: WorkoutPlanEntity,

    val exerciseCount: Int

)