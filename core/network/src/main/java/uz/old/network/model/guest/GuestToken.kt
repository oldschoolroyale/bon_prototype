package uz.old.network.model.guest

import com.google.gson.annotations.SerializedName

data class GuestToken(
    @SerializedName("guest_token")
    val guestToken: String
)
