package com.dynamicdevz.rxjavadynamic.model

import com.dynamicdevz.rxjavadynamic.model.data.RickyCache
import com.dynamicdevz.rxjavadynamic.model.data.RickyResponse
import com.dynamicdevz.rxjavadynamic.model.db.RickyDatabase
import com.dynamicdevz.rxjavadynamic.model.db.RickyDatabase.Companion.getDao
import com.dynamicdevz.rxjavadynamic.network.RickyRetrofit
import com.dynamicdevz.rxjavadynamic.util.Constants.Companion.CACHE_KEY
import com.google.gson.Gson
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RickyRepository @Inject constructor(private val rickyRetrofit: RickyRetrofit) {
    //Reading from online repo
    fun readFromRemoteSource(): Single<RickyResponse> = rickyRetrofit.getCharactersRemote()

    //Reading from cache
    fun readFromCache(): RickyResponse {
        val cache = getDao().readFromCache()
        val data = Gson().fromJson(cache.data, RickyResponse::class.java)
        return data
    }

    fun saveToCache(response: RickyResponse){
        val gson = Gson()
        val json = gson.toJson(response)
        getDao().cacheData(RickyCache(CACHE_KEY, json))
    }

}