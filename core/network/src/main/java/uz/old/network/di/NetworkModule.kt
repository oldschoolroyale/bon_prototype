package uz.old.network.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.old.network.api.GuestApi
import uz.old.network.utils.InterceptorHelper
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { provideGson() }
    single<Retrofit> { provideApi(get(), get()) }
    factory { provideGuestApi(get()) }
}

fun provideGson(): Gson {
    return GsonBuilder()
        .setLenient()
        .create()
}

fun provideApi(
    context: Context,
    gson: Gson
): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://bon.bitrix.88dev.net/api/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(
            OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .apply {
                    InterceptorHelper.getInterceptorsList(context).forEach {
                        addInterceptor(it)
                    }
                }
                .build()
        )
        .build()
}

fun provideGuestApi(retrofit: Retrofit): GuestApi = retrofit.create(GuestApi::class.java)