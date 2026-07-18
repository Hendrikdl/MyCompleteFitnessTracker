package za.hendrikdelange.mycompletefitnesstracker.core.startup

import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StartupManager @Inject constructor(

    private val auth: FirebaseAuth

) {

    suspend fun initialize(): StartupResult {

        val user = auth.currentUser

        return if (user == null) {

            StartupResult.GoToLogin

        } else {

            StartupResult.GoToHome

        }

    }

}