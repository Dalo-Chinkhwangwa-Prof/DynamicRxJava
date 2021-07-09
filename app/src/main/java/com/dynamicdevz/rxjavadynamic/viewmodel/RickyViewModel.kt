package com.dynamicdevz.rxjavadynamic.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dynamicdevz.rxjavadynamic.model.data.Result
import com.dynamicdevz.rxjavadynamic.util.RickySingleton.Companion.rickyComponent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RickyViewModel: ViewModel() {

    val rickData = MutableLiveData<List<Result>>()
    private val compDisposable = CompositeDisposable()

    init {
        compDisposable.add(
            rickyComponent.getRepository().readFromRemoteSource()
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .map {

                    rickyComponent.getRepository().saveToCache(it)
                    Log.d("TAG_X", "saving to cache - on ${Thread.currentThread().name}")
                    it.results

                }
                .subscribe({results ->

                    Log.d("TAG_X", "update LiveData on ${Thread.currentThread().name}")
                    rickData.postValue(results)

                },  {throwable ->
                    Log.d("TAG_X", "Oops: ${throwable.localizedMessage}")
                    rickData.postValue(rickyComponent.getRepository().readFromCache().results)
                })
            //high order function - function that can take
//        other functions as arguments or have a function as a return type
        )
    }

    override fun onCleared() {
        super.onCleared()
        compDisposable.clear()
    }
}