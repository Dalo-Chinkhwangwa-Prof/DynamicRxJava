package com.dynamicdevz.rxjavadynamic

import android.app.Application
import com.dynamicdevz.rxjavadynamic.model.db.RickyDatabase

class RickyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        RickyDatabase.initializeDatabase(this)
    }
}