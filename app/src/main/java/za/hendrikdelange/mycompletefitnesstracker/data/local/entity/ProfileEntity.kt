package za.hendrikdelange.mycompletefitnesstracker.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profiles")
data class ProfileEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val name: String,
    val email: String,
    val height: Double?,
    val weight: Double?,
    val fitnessGoal: String?
)