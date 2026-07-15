package za.hendrikdelange.mycompletefitnesstracker.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.ProfileEntity


@Dao
interface ProfileDao {


    @Insert
    suspend fun insertProfile(
        profile: ProfileEntity
    )


    @Query(
        "SELECT * FROM profiles WHERE firebaseUid = :uid LIMIT 1"
    )
    fun getProfile(
        uid: String
    ): Flow<ProfileEntity?>


}