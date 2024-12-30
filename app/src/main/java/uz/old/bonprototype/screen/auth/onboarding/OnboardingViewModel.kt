package uz.old.bonprototype.screen.auth.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import uz.old.data.repository.GuestRepository

class OnboardingViewModel: ViewModel(), KoinComponent {
    private val guestRepository: GuestRepository by inject()

    init {
        getGuestToken()
    }

    private fun getGuestToken() = viewModelScope.launch {
        guestRepository.getGuestToken()
    }
}