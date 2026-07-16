package za.hendrikdelange.mycompletefitnesstracker.ui.components.input

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.*
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FitnessDatePicker(

    value: String,

    label: String,

    onValueChange: (String) -> Unit

) {

    var showDatePicker by remember {
        mutableStateOf(false)
    }

    FitnessPickerField(

        value = value,

        label = label,

        icon = Icons.Default.CalendarMonth,

        onClick = {

            showDatePicker = true

        }

    )

    if (showDatePicker) {

        val state = rememberDatePickerState()

        DatePickerDialog(

            onDismissRequest = {

                showDatePicker = false

            },

            confirmButton = {

                TextButton(

                    onClick = {

                        state.selectedDateMillis?.let {

                            val formatter =
                                SimpleDateFormat(
                                    "yyyy-MM-dd",
                                    Locale.getDefault()
                                )

                            onValueChange(
                                formatter.format(
                                    Date(it)
                                )
                            )

                        }

                        showDatePicker = false

                    }

                ) {

                    Text("OK")

                }

            },

            dismissButton = {

                TextButton(

                    onClick = {

                        showDatePicker = false

                    }

                ) {

                    Text("Cancel")

                }

            }

        ) {

            DatePicker(
                state = state
            )

        }

    }

}