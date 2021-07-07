package com.example.quake.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quake.R
import com.example.quake.data.api.repository.QuakeRepository
import com.example.quake.data.api.response.QuakeResponse
import com.example.quake.data.api.response.QuakeResults
import com.example.quake.ui.main.adapter.QuakeAdapter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class QuakeActivity : AppCompatActivity() {

    lateinit var quakeRV: RecyclerView
    private var quakeAdapter: QuakeAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quake)

        quakeRV = findViewById(R.id.quakeRV)

        quakeRV.layoutManager = LinearLayoutManager(this)

        quakeAdapter = QuakeAdapter()
        quakeRV.adapter = quakeAdapter

        getQuakeAll {
            quakeAdapter?.setAll(it.results as ArrayList<QuakeResults>)
        }
    }

    private fun getQuakeAll(success: (quakeResponse: QuakeResponse) -> Unit) {
        QuakeRepository(this.applicationContext).all().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
            }.doOnComplete {
            }.doFinally {
            }.doOnError {
            }.subscribe(
                { result ->
                    success(result)
                },
                { e ->
                    e.printStackTrace()
                }
            )
    }
}