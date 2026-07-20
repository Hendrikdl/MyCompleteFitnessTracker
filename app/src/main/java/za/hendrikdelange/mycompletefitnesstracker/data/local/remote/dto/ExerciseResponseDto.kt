package za.hendrikdelange.mycompletefitnesstracker.data.remote.dto

import za.hendrikdelange.mycompletefitnesstracker.data.local.remote.dto.ExerciseDto

data class ExerciseResponseDto(

    val count: Int,

    val next: String?,

    val previous: String?,

    val results: List<ExerciseDto>

)