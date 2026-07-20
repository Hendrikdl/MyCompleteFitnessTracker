package za.hendrikdelange.mycompletefitnesstracker.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "exercise_library"
)
data class ExerciseEntity(

    @PrimaryKey(autoGenerate = false)
    val id: Int,

    val name: String,

    val description: String?,

    val instructions: String?,

    val muscleGroup: String?,

    val equipment: String?,

    val category: String?,

    val imageUrl: String?,

    val gifUrl: String?,

    val localImagePath: String? = null,

    val isCustom: Boolean = false,

    val isFavorite: Boolean = false,

    val lastUpdated: Long = System.currentTimeMillis()

)