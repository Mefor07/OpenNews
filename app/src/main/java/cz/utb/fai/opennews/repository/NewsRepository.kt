package cz.utb.fai.opennews.repository

import androidx.lifecycle.MutableLiveData
import app.medrx.MedrxApp.retrofit.RetrofitClient
import cz.utb.fai.opennews.model.News


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object NewsRepository {
    val news = MutableLiveData<News>()


    fun getNewsDataApiCall(): MutableLiveData<News>{
        val call = RetrofitClient.apiInterface.news()
        call.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val data = response.body()
                val newsDataCategory = data!!.category
                news.value = News(newsDataCategory, data.data, data.success)
            }

            override fun onFailure(call: Call<News>, t: Throwable) {

            }

        })
        return  news
    }

}