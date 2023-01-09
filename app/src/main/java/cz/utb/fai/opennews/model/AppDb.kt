package cz.utb.fai.opennews.model

import androidx.room.Database
import androidx.room.RoomDatabase
import cz.utb.fai.opennews.interfaces.NewsDao

@Database(entities = [(NewsEntity::class)],version = 1)
abstract class AppDb : RoomDatabase() {

    abstract fun newsDao(): NewsDao
}