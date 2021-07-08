package com.dynamicdevz.rxjavadynamic.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.dynamicdevz.rxjavadynamic.model.data.RickyCache
import com.dynamicdevz.rxjavadynamic.util.Constants.Companion.CACHE_KEY

@Dao
interface RickyDAO {

    @Insert(onConflict = REPLACE)
    fun cacheData(data: RickyCache)

    @Query("SELECT * FROM ricky_cache WHERE cache_id = $CACHE_KEY")
    fun readFromCache(): RickyCache

}