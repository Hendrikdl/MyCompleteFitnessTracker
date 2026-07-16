package za.hendrikdelange.mycompletefitnesstracker.ui.components.input

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun FitnessDropdown(

    value: String,

    label: String,

    options: List<String>,

    onValueChange: (String) -> Unit

) {


    var expanded by remember {

        mutableStateOf(false)

    }

    Box(

        modifier = Modifier.fillMaxWidth()

    ) {

        FitnessPickerField(

            value = value,

            label = label,



            icon = Icons.Default.ArrowDropDown,


            onClick = {

                expanded = true

            }

        )

        DropdownMenu(

            expanded = expanded,

            onDismissRequest = {

                expanded = false

            }

        ) {

            options.forEach { option ->

                DropdownMenuItem(

                    text = {

                        androidx.compose.material3.Text(option)

                    },



                    onClick = {

                        onValueChange(option)

                        expanded = false

                    }

                )

            }

        }

    }

}