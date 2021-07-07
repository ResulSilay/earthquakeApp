package com.example.quake.data.api.service

import com.example.quake.data.api.response.QuakeResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface QuakeService {

    @GET("earthquake/is")
    fun getAllQuake(): Observable<QuakeResponse>
}