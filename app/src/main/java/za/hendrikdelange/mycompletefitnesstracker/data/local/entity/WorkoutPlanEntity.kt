package za.hendrikdelange.mycompletefitnesstracker.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import za.hendrikdelange.mycompletefitnesstracker.core.sync.SyncIds

@Entity(tableName = "workout_plans")
data class WorkoutPlanEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val syncId: String = SyncIds.newId(),

    val name: String = "",

    val category: String = "",

    val dayOfWeek: Int = 0,

    val created: Long = System.currentTimeMillis(),

    val updated: Long = System.currentTimeMillis(),

    val lastModified: Long = System.currentTimeMillis(),

    val needsSync: Boolean = true,

    val firebaseUid: String = "",

    val createdDate: Long = System.currentTimeMillis()
)