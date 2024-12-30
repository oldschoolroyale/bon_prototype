package uz.old.data.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import uz.old.cache.CacheApi
import uz.old.data.repository.GuestRepository
import uz.old.network.api.GuestApi

class GuestRepositoryImpl : GuestRepository, KoinComponent {
    private val guestApi: GuestApi by inject()
    private val cacheApi: CacheApi by inject()

    override suspend fun getGuestToken() {
        withContext(Dispatchers.IO) {
            val token = guestApi.getGuestToken()
            cacheApi.saveGuestToken(token.guestToken)
        }
    }
}