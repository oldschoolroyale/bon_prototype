package uz.old.network.utils

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

object InterceptorHelper {
    fun getInterceptorsList(context: Context): List<Interceptor> {
        val interceptors = mutableListOf<Interceptor>()

        interceptors.add(
            ChuckerInterceptor.Builder(context)
                .collector(ChuckerCollector(context, showNotification = true))
                .maxContentLength(250000L)
                .redactHeaders(emptySet())
                .alwaysReadResponseBody(false)
                .build()
        )

        interceptors.add(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))

        return interceptors
    }
}