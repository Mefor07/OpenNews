package cz.utb.fai.opennews.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class NewsEntity {

    @PrimaryKey(autoGenerate = true)
    var newsId: Int =0

    //@ColumnInfo(name ="BookName")
    //var bookName:  String =""

    var author: String? = ""
    var content: String? = ""
    var date: String? = ""
    var id: String = ""
    var imageUrl: String? = ""
    var readMoreUrl: String? = ""
    var time: String? = ""
    var title: String? = ""
    var url: String? = ""
}