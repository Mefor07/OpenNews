package cz.utb.fai.opennews.interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cz.utb.fai.opennews.model.NewsEntity

@Dao
interface NewsDao {

    @Insert
    //@Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveNews(news: NewsEntity)

    @Query(value = "Select * from NewsEntity")
    fun getAllNews() : List<NewsEntity>
}