package com.dynamicdevz.rxjavadynamic.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dynamicdevz.rxjavadynamic.model.data.RickyCache
import com.dynamicdevz.rxjavadynamic.util.Constants.Companion.DATABASE_NAME

@Database(version = 1, entities = [RickyCache::class])
abstract class RickyDatabase: RoomDatabase() {

    abstract fun getDAO(): RickyDAO

    companion object{
        private lateinit var rickyDatabase: RickyDatabase

        fun initializeDatabase(context: Context){
            rickyDatabase = Room.databaseBuilder(
                context,
                RickyDatabase::class.java,
                DATABASE_NAME
            ).build()
        }
        fun getDao() = rickyDatabase.getDAO()
    }


}