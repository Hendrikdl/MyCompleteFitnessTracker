package za.hendrikdelange.mycompletefitnesstracker.core.sync

import android.util.Log
import kotlinx.coroutines.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SyncCoordinator @Inject constructor(

    private val syncManager: SyncManager

) {

    private val scope = CoroutineScope(
        SupervisorJob() + Dispatchers.IO
    )

    private var pendingJob: Job? = null

    fun requestSync() {

        Log.d("SYNCC", "Sync requested")

        pendingJob?.cancel()

        pendingJob = scope.launch {

            delay(3000)

            Log.d("SYNCC", "Running synchronization")

            syncManager.synchronize()

        }

    }

}