package uz.old.cache.di

import android.content.Context
import android.content.SharedPreferences
import org.koin.dsl.module
import uz.old.cache.CacheApi
import uz.old.cache.CacheApiImpl

val cacheModule = module {
    single { provideSharedPrefs(get()) }
    single<CacheApi> { CacheApiImpl() }
}

private fun provideSharedPrefs(
    context: Context
): SharedPreferences {
    return context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
}