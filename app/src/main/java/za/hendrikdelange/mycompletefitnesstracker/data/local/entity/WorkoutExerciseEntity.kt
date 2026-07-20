package za.hendrikdelange.mycompletefitnesstracker.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import za.hendrikdelange.mycompletefitnesstracker.core.sync.SyncIds

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

    val syncId: String = SyncIds.newId(),

    val planId: Long = 0L,

    val exerciseId: Int = 0,

    val orderIndex: Int = 0,

    val sets: Int = 0,

    val repsFrom: Int = 0,

    val repsTo: Int = 0,

    val weight: Double = 0.0,

    val restSeconds: Int = 60,

    val lastModified: Long = System.currentTimeMillis(),

    val needsSync: Boolean = true,

    val isConfigured: Boolean = false

)