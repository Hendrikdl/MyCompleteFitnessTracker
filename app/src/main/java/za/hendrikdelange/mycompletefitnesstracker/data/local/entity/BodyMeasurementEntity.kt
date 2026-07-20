package za.hendrikdelange.mycompletefitnesstracker.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import za.hendrikdelange.mycompletefitnesstracker.core.sync.SyncIds


@Entity(
    tableName = "body_measurements"
)
data class BodyMeasurementEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val syncId: String = SyncIds.newId(),

    val firebaseUid: String,

    val date: Long = System.currentTimeMillis(),

    val weightKg: Double,

    val heightCm: Double,

    val bodyFatPercentage: Double? = null,

    val neckCm: Double? = null,

    val shoulderCm: Double? = null,

    val chestCm: Double? = null,

    val waistCm: Double? = null,

    val hipCm: Double? = null,

    val thighCm: Double? = null,

    val calfCm: Double? = null,

    val bicepLeftCm: Double? = null,

    val bicepRightCm: Double? = null,

    val lastModified: Long = System.currentTimeMillis(),

    val needsSync: Boolean = true

)