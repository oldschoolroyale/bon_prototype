package uz.old.bonprototype

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import uz.old.bonprototype.di.vmModule
import uz.old.cache.di.cacheModule
import uz.old.data.di.repositoryModule
import uz.old.network.di.networkModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                vmModule,
                networkModule,
                cacheModule,
                repositoryModule,
            )
        }
    }
}