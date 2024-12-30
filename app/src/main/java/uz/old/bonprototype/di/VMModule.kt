package uz.old.bonprototype.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import uz.old.bonprototype.screen.auth.onboarding.OnboardingViewModel

val vmModule = module {
    viewModel { OnboardingViewModel() }
}