package za.hendrikdelange.mycompletefitnesstracker.data.repository

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) {

    val currentUser
        get() = firebaseAuth.currentUser


    suspend fun login(
        email: String,
        password: String
    ): Result<Unit> {

        return try {

            firebaseAuth
                .signInWithEmailAndPassword(
                    email,
                    password
                )
                .await()

            Result.success(Unit)

        } catch (e: Exception) {

            Result.failure(e)

        }
    }


    suspend fun register(
        email: String,
        password: String
    ): Result<Unit> {

        return try {

            firebaseAuth
                .createUserWithEmailAndPassword(
                    email,
                    password
                )
                .await()

            Result.success(Unit)

        } catch (e: Exception) {

            Result.failure(e)

        }
    }


    fun logout() {

        firebaseAuth.signOut()

    }

}