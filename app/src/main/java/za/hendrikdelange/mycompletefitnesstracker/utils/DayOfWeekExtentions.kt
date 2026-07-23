package za.hendrikdelange.mycompletefitnesstracker.utils

import androidx.compose.ui.graphics.Color
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.FitnessDesign

fun Int.toDayName(): String {

    return when (this) {

        1 -> "Monday"

        2 -> "Tuesday"

        3 -> "Wednesday"

        4 -> "Thursday"

        5 -> "Friday"

        6 -> "Saturday"

        7 -> "Sunday"

        else -> "Unknown"

    }

}

fun Int.toDayColor(): Color =
    when (this) {
        1 -> Color(0xFF4CAF50) // Monday - Green
        2 -> Color(0xFF2196F3) // Tuesday - Blue
        3 -> Color(0xFFFF9800) // Wednesday - Orange
        4 -> Color(0xFF9C27B0) // Thursday - Purple
        5 -> Color(0xFFF44336) // Friday - Red
        6 -> Color(0xFF00BCD4) // Saturday - Cyan
        7 -> Color(0xFF607D8B) // Sunday - Blue Grey
        else -> Color.Gray
    }

fun String.toCategoryColor() = when (uppercase()) {

    "PUSH" -> Color(0xFFE53935)

    "PULL" -> Color(0xFF1E88E5)

    "LEGS" -> Color(0xFF43A047)

    "CARDIO" -> Color(0xFFFB8C00)

    "FULL_BODY" -> Color(0xFF8E24AA)

    "UPPER" -> Color(0xFF00ACC1)

    "LOWER" -> Color(0xFF6D4C41)

    else -> FitnessDesign.colors.Primary
}