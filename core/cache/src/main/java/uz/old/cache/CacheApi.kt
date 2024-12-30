package uz.old.cache

interface CacheApi {
    fun saveGuestToken(token: String)
    fun getGuestToken(): String
}