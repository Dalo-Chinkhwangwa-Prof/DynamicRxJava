package com.dynamicdevz.rxjavadynamic.util

import com.dynamicdevz.rxjavadynamic.di.component.RickyComponent
import com.dynamicdevz.rxjavadynamic.network.RickyRetrofit

class RickySingleton {
    companion object{
        lateinit var rickyComponent: RickyComponent
    }
}