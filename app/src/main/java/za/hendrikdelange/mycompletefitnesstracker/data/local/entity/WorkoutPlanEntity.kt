package za.hendrikdelange.mycompletefitnesstracker.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "workout_plans")
data class WorkoutPlanEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val name: String,

    val category: String,

    val dayOfWeek: Int,

    val created: Long = System.currentTimeMillis(),

    val updated: Long = System.currentTimeMillis(),

    val lastModified: Long = System.currentTimeMillis(),

    val needsSync: Boolean = true
)