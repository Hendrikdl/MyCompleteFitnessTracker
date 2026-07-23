package za.hendrikdelange.mycompletefitnesstracker.ui.components.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutPlanEntity
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.FitnessDesign
import za.hendrikdelange.mycompletefitnesstracker.ui.components.dialogs.FitnessConfirmDeleteDialog

@Composable
fun WorkoutCard(

    workout: WorkoutPlanEntity,

    exerciseCount: Int,

    modifier: Modifier = Modifier,

    onClick: () -> Unit = {},

    onDelete: () -> Unit

) {

    var showMenu by remember {

        mutableStateOf(false)

    }

    var showDeleteDialog by remember {

        mutableStateOf(false)

    }

    FitnessCard(

        modifier = modifier.clickable {

            onClick()

        }

    ) {

        Row(

            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement = Arrangement.SpaceBetween,

            verticalAlignment = Alignment.Top

        ) {

            WorkoutHeader(

                modifier = Modifier.weight(1f),

                workout = workout,

                exerciseCount = exerciseCount

            )

            IconButton(

                onClick = {

                    showMenu = true

                }

            ) {

                Icon(

                    imageVector = Icons.Default.MoreVert,

                    contentDescription = "More",

                    tint = FitnessDesign.colors.TextPrimary

                )

            }

            DropdownMenu(

                expanded = showMenu,

                onDismissRequest = {

                    showMenu = false

                }

            ) {

                DropdownMenuItem(

                    text = {

                        Text("Delete")

                    },

                    leadingIcon = {

                        Icon(

                            Icons.Default.Delete,

                            contentDescription = null

                        )

                    },

                    onClick = {

                        showMenu = false

                        showDeleteDialog = true

                    }

                )

            }

        }

    }

    if (showDeleteDialog) {

        FitnessConfirmDeleteDialog(

            workoutName = workout.name,

            onDismiss = {

                showDeleteDialog = false

            },

            onDelete = {

                showDeleteDialog = false

                onDelete()

            }

        )

    }

}