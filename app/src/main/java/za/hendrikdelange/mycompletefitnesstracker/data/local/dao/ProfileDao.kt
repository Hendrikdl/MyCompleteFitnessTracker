package za.hendrikdelange.mycompletefitnesstracker.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.ProfileEntity


@Dao
interface ProfileDao {


    @Insert(
        onConflict = OnConflictStrategy.REPLACE
    )
    suspend fun insert(
        profile: ProfileEntity
    )


    @Query(
        "SELECT * FROM profiles WHERE firebaseUid = :uid LIMIT 1"
    )
    fun getProfile(
        uid: String
    ): Flow<ProfileEntity?>

}