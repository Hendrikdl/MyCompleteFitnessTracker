package za.hendrikdelange.mycompletefitnesstracker.data.remote.mapper

import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.ExerciseEntity
import za.hendrikdelange.mycompletefitnesstracker.data.remote.dto.ExerciseDto

fun ExerciseDto.toEntity(): ExerciseEntity {

    val translation =
        translations.firstOrNull {
            it.language == 2
        } ?: translations.first()

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

        imageUrl = images.firstOrNull()?.image,

        gifUrl = images.firstOrNull()?.image,

        isCustom = false

    )
}