package za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object AppTypography {

    val Heading = TextStyle(
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold
    )

    val Title = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold
    )

    val Body = TextStyle(
        fontSize = 16.sp
    )

    val Caption = TextStyle(
        fontSize = 12.sp
    )
}