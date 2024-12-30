package uz.old.cache

import android.content.SharedPreferences
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CacheApiImpl: CacheApi, KoinComponent {
    private val sharedPreferences: SharedPreferences by inject()

    override fun saveGuestToken(token: String) {
        sharedPreferences.edit()?.putString("guest_token", token)?.apply()
    }

    override fun getGuestToken(): String {
        return sharedPreferences.getString("guest_token", "") ?: ""
    }
}