package za.hendrikdelange.mycompletefitnesstracker.data.remote.dto

import za.hendrikdelange.mycompletefitnesstracker.data.local.remote.dto.CategoryDto
import za.hendrikdelange.mycompletefitnesstracker.data.local.remote.dto.EquipmentDto
import za.hendrikdelange.mycompletefitnesstracker.data.local.remote.dto.ImageDto
import za.hendrikdelange.mycompletefitnesstracker.data.local.remote.dto.MuscleDto
import za.hendrikdelange.mycompletefitnesstracker.data.local.remote.dto.TranslationDto

data class ExerciseDto(

    val id: Int,

    val category: CategoryDto,

    val muscles: List<MuscleDto>,

    val muscles_secondary: List<MuscleDto>,

    val equipment: List<EquipmentDto>,

    val images: List<ImageDto>,

    val translations: List<TranslationDto>

)