package com.dynamicdevz.rxjavadynamic.network

import com.dynamicdevz.rxjavadynamic.model.data.RickyResponse
import com.dynamicdevz.rxjavadynamic.util.Constants.Companion.BASE_URL
import com.dynamicdevz.rxjavadynamic.util.Constants.Companion.END_POINT
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RickyRetrofit @Inject constructor() {

    private val rickyService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(RickyService::class.java)

    fun getCharactersRemote() = rickyService.getAllCharacters()

    interface RickyService {
        @GET(END_POINT)
        fun getAllCharacters(): Single<RickyResponse>
    }
}