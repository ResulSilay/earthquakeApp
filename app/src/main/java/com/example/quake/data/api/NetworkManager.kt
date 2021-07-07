package com.example.quake.data.api

import android.annotation.SuppressLint
import android.content.Context
import com.example.quake.data.api.ApiConst.BASE_URL
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkManager(private val context: Context) {

    companion object {
        private var retrofit: Retrofit? = null
        @SuppressLint("StaticFieldLeak")
        private var instance: NetworkManager? = null

        fun getInstance(context: Context): NetworkManager {
            if (instance == null) {
                return NetworkManager(context)
            }

            return instance as NetworkManager
        }
    }

    fun client(): Retrofit {
        try {
            val client = OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS).build()

            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(client)
                .build()

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return retrofit!!
    }
}