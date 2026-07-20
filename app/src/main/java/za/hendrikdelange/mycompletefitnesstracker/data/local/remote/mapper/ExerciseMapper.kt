package za.hendrikdelange.mycompletefitnesstracker.data.local.remote.mapper

import android.util.Log
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.ExerciseEntity
import za.hendrikdelange.mycompletefitnesstracker.data.local.remote.dto.ExerciseDto

fun ExerciseDto.toEntity(): ExerciseEntity {

    val translation =
        translations.firstOrNull {
            it.language == 2
        } ?: translations.first()


    val mediaUrl =
        images.firstOrNull()?.image


    Log.d(
        "EXERCISE_IMAGE",
        mediaUrl ?: "NO IMAGE"
    )


    return ExerciseEntity(

        id = id,

        name = translation.name,

        description = translation.description,

        instructions = translation.description,

        muscleGroup = muscles.joinToString {
            it.name
        },

        equipment = equipment.joinToString {
            it.name
        },

        category = category.name,

        imageUrl =
            if (mediaUrl?.endsWith(".gif") == false)
                mediaUrl
            else
                null,

        gifUrl =
            if (mediaUrl?.endsWith(".gif") == true)
                mediaUrl
            else
                null,

        isCustom = false

    )
}