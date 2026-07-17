package za.hendrikdelange.mycompletefitnesstracker.data.remote.dto

data class ExerciseResponseDto(

    val count: Int,

    val next: String?,

    val previous: String?,

    val results: List<ExerciseDto>

)