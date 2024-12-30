package uz.old.data.di

import org.koin.dsl.module
import uz.old.data.impl.GuestRepositoryImpl
import uz.old.data.repository.GuestRepository

val repositoryModule = module {
    single<GuestRepository> { GuestRepositoryImpl() }
}