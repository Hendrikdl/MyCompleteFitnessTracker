package za.hendrikdelange.mycompletefitnesstracker.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "profiles"
)
data class ProfileEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val firebaseUid: String,

    val firstName: String,

    val surname: String,

    val dateOfBirth: String,

    val gender: String,

    val fitnessGoal: String,

    val experienceLevel: String,

    val workoutLocation: String,

    val createdDate: Long = System.currentTimeMillis()

)