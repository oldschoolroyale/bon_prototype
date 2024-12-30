package uz.old.network.api

import retrofit2.http.POST
import uz.old.network.model.guest.GuestToken

interface GuestApi {
    @POST("get-guest-token")
    suspend fun getGuestToken(): GuestToken
}