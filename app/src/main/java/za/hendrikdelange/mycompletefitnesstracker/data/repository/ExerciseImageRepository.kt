package za.hendrikdelange.mycompletefitnesstracker.data.repository

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import javax.inject.Inject

class ExerciseImageRepository @Inject constructor(

    @ApplicationContext
    private val context: Context,

    private val client: OkHttpClient

) {


    suspend fun downloadImage(
        exerciseId: Int,
        url: String
    ): String? = withContext(Dispatchers.IO) {


        try {

            val extension =
                if (url.endsWith(".gif"))
                    "gif"
                else
                    "webp"


            val directory =
                File(
                    context.filesDir,
                    "exercise_images"
                )


            if (!directory.exists()) {
                directory.mkdirs()
            }


            val file =
                File(
                    directory,
                    "$exerciseId.$extension"
                )


            // Already downloaded
            if (file.exists()) {

                return@withContext file.absolutePath

            }


            val request =
                Request.Builder()
                    .url(url)
                    .build()


            client.newCall(request)
                .execute()
                .use { response ->


                    if (!response.isSuccessful) {

                        return@withContext null

                    }


                    response.body?.byteStream()
                        ?.use { input ->


                            file.outputStream()
                                .use { output ->

                                    input.copyTo(output)

                                }

                        }


                }


            file.absolutePath


        } catch (e: Exception) {

            null

        }

    }

}