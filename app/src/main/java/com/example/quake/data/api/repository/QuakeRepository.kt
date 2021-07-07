package com.example.quake.data.api.repository

import android.content.Context
import com.example.quake.data.api.NetworkManager
import com.example.quake.data.api.response.QuakeResponse
import com.example.quake.data.api.service.QuakeService
import io.reactivex.rxjava3.core.Observable
import retrofit2.Retrofit

class QuakeRepository(private val context:Context) {

    private var client: Retrofit = NetworkManager.getInstance(context).client()

    fun all(): Observable<QuakeResponse> {
        return client.create(QuakeService::class.java).getAllQuake()
    }
}