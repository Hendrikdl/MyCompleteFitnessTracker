package za.hendrikdelange.mycompletefitnesstracker.core.startup

import com.google.firebase.auth.FirebaseAuth
import za.hendrikdelange.mycompletefitnesstracker.core.sync.SyncManager
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import za.hendrikdelange.mycompletefitnesstracker.data.repository.ExerciseRepository

@Singleton
class StartupManager @Inject constructor(

    private val auth: FirebaseAuth,
    private val syncManager: SyncManager,
    private val exerciseRepository: ExerciseRepository

) {

    private val _progress =
        MutableStateFlow<StartupProgress>(
            StartupProgress.Idle
        )

    val progress =
        _progress.asStateFlow()
    suspend fun initialize(): StartupResult {

        _progress.value =
            StartupProgress.CheckingAccount

        val user = auth.currentUser

        if (user == null) {
            return StartupResult.GoToLogin
        }

        _progress.value =
            StartupProgress.DownloadingProfile

        syncManager.synchronize()


        exerciseRepository.initializeExerciseLibrary { progress ->

            _progress.value =
                StartupProgress.DownloadingExercises(progress)

        }

        _progress.value =
            StartupProgress.Finished

        return StartupResult.GoToProfileCheck
    }
}