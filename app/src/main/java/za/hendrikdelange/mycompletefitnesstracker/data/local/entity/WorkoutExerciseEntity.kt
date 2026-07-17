package za.hendrikdelange.mycompletefitnesstracker.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "workout_exercises",

    foreignKeys = [

        ForeignKey(
            entity = WorkoutPlanEntity::class,
            parentColumns = ["id"],
            childColumns = ["planId"],
            onDelete = ForeignKey.CASCADE
        ),

        ForeignKey(
            entity = ExerciseEntity::class,
            parentColumns = ["id"],
            childColumns = ["exerciseId"]
        )

    ],

    indices = [
        Index("planId"),
        Index("exerciseId")
    ]
)
data class WorkoutExerciseEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val planId: Long,

    val exerciseId: Int,

    val orderIndex: Int
)