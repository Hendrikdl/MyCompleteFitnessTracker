package za.hendrikdelange.mycompletefitnesstracker.ui.components.display

import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.FitnessDesign
import androidx.compose.material3.Text

@Composable
fun ExerciseInstructions(

    html: String?

) {

    Column(

        modifier = Modifier.fillMaxWidth(),

        verticalArrangement = Arrangement.spacedBy(
            FitnessDesign.spacing.Small
        )

    ) {

        Text(

            text = "Instructions",

            style = FitnessDesign.typography.Title,

            color = FitnessDesign.colors.Primary

        )

        AndroidView(

            factory = { context ->

                TextView(context).apply {

                    textSize = 16f

                    setTextColor(
                        android.graphics.Color.BLACK
                    )

                    movementMethod =
                        LinkMovementMethod.getInstance()

                }

            },

            update = {

                it.text = HtmlCompat.fromHtml(

                    html ?: "<p>No instructions available.</p>",

                    HtmlCompat.FROM_HTML_MODE_LEGACY

                )

            }

        )

    }

}