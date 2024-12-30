package uz.old.data.repository

interface GuestRepository {
    suspend fun getGuestToken()
}