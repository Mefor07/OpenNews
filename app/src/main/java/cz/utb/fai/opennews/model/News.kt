package cz.utb.fai.opennews.model

data class News(
    val category: String,
    val `data`: List<NewsData>,
    val success: Boolean
)

data class NewsData(
    val author: String,
    val content: String,
    val date: String,
    val id: String,
    val imageUrl: String,
    val readMoreUrl: String,
    val time: String,
    val title: String,
    val url: String
)