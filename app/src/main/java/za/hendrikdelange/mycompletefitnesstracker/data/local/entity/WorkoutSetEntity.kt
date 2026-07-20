package za.hendrikdelange.mycompletefitnesstracker.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import za.hendrikdelange.mycompletefitnesstracker.core.sync.SyncIds

@Entity(
    tableName = "workout_sets",

    foreignKeys = [

        ForeignKey(
            entity = WorkoutExerciseEntity::class,
            parentColumns = ["id"],
            childColumns = ["workoutExerciseId"],
            onDelete = ForeignKey.CASCADE
        )

    ],

    indices = [
        Index("workoutExerciseId")
    ]
)
data class WorkoutSetEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val syncId: String = SyncIds.newId(),

    val workoutExerciseId: Long,

    val setNumber: Int,

    val repsMin: Int,

    val repsMax: Int,

    val targetWeight: Double = 0.0,

    val restSeconds: Int = 90,

    val lastModified: Long = System.currentTimeMillis(),

    val needsSync: Boolean = true
)