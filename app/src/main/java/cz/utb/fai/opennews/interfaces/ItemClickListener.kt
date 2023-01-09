package cz.utb.fai.opennews.interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cz.utb.fai.opennews.model.NewsEntity

@Dao
interface ItemClickListener {



    fun itemClick(newsImage: String, newsDescription: String)


}