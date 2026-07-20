package za.hendrikdelange.mycompletefitnesstracker.data.local.remote.dto

data class ExerciseDto(

    val id: Int,

    val category: CategoryDto,

    val muscles: List<MuscleDto>,

    val muscles_secondary: List<MuscleDto>,

    val equipment: List<EquipmentDto>,

    val images: List<ImageDto>,

    val translations: List<TranslationDto>

)