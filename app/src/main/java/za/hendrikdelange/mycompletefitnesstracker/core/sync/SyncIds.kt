package za.hendrikdelange.mycompletefitnesstracker.core.sync

import java.util.UUID

object SyncIds {

    fun newId(): String =
        UUID.randomUUID().toString()

}