package za.hendrikdelange.mycompletefitnesstracker.core.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserPreferencesDataStore @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {

    val isLoggedIn: Flow<Boolean> =
        dataStore.data.map { preferences ->
            preferences[PreferencesKeys.IS_LOGGED_IN] ?: false
        }


    val userId: Flow<String?> =
        dataStore.data.map { preferences ->
            preferences[PreferencesKeys.USER_ID]
        }


    val userEmail: Flow<String?> =
        dataStore.data.map { preferences ->
            preferences[PreferencesKeys.USER_EMAIL]
        }


    suspend fun saveLoginState(
        userId: String,
        email: String
    ) {
        dataStore.edit { preferences ->

            preferences[PreferencesKeys.IS_LOGGED_IN] = true

            preferences[PreferencesKeys.USER_ID] = userId

            preferences[PreferencesKeys.USER_EMAIL] = email
        }
    }


    suspend fun clearLoginState() {

        dataStore.edit { preferences ->

            preferences.clear()

        }
    }
}