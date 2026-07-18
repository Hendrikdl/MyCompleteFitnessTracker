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
            childColumns = ["planId"],      // <-- changed
            onDelete = ForeignKey.CASCADE
        ),

        ForeignKey(
            entity = ExerciseEntity::class,
            parentColumns = ["id"],
            childColumns = ["exerciseId"]
        )

    ],

    indices = [
        Index("planId"),                    // <-- changed
        Index("exerciseId")
    ]
)
data class WorkoutExerciseEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val planId: Long,

    val exerciseId: Int,

    val orderIndex: Int = 0,

    val sets: Int = 0,

    val repsFrom: Int = 0,

    val repsTo: Int = 0,

    val weight: Double = 0.0,

    val restSeconds: Int = 60,

    val isConfigured: Boolean = false

)