package za.hendrikdelange.mycompletefitnesstracker.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.BodyMeasurementEntity


@Dao
interface MeasurementDao {


    @Insert
    suspend fun insertMeasurement(
        measurement: BodyMeasurementEntity
    )


    @Query(
        """
        SELECT * FROM body_measurements
        WHERE firebaseUid = :uid
        ORDER BY date DESC
        """
    )
    fun getMeasurements(
        uid: String
    ): Flow<List<BodyMeasurementEntity>>

}