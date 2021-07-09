package com.dynamicdevz.rxjavadynamic

import android.app.Application
import com.dynamicdevz.rxjavadynamic.di.component.DaggerRickyComponent
import com.dynamicdevz.rxjavadynamic.model.db.RickyDatabase
import com.dynamicdevz.rxjavadynamic.util.RickySingleton

class RickyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        RickyDatabase.initializeDatabase(this)
        RickySingleton.rickyComponent = DaggerRickyComponent.create()
    }
}