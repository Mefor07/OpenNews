package cz.utb.fai.opennews

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.adastra_one.ageofempires.adapters.NewsAdapter
import com.adastra_one.ageofempires.viewmodel.NewsViewModel
import cz.utb.fai.opennews.databinding.ActivityMainBinding
import cz.utb.fai.opennews.interfaces.ItemClickListener
import cz.utb.fai.opennews.model.AppDb
import cz.utb.fai.opennews.model.NewsData
import cz.utb.fai.opennews.model.NewsEntity



class MainActivity : AppCompatActivity(), ItemClickListener {
    lateinit var newsViewModel: NewsViewModel
    lateinit var db: AppDb
    lateinit var sharedPreference: SharedPreferences
    lateinit var editor: Editor
    lateinit var cvRecyclerView: RecyclerView
    lateinit var newsAdapter: NewsAdapter
    var itemsList =  ArrayList<NewsData>()

    override fun onCreate(savedInstanceState: Bundle?) {



        db = Room.databaseBuilder(applicationContext, AppDb::class.java,"NewsDB").build()
        super.onCreate(savedInstanceState)
        sharedPreference =  getSharedPreferences("SYNC_STATUS", Context.MODE_PRIVATE)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        cvRecyclerView = binding.cvRecyclerView
        newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)

        //check for sync status
        if(sharedPreference.getBoolean("hasSynced", false)){
            //true means synced, pull data from local db
            getdataLocalData()
        }else{
            //make a network call
            syncNewsFromNetwork()

        }

        setContentView(binding.root)
    }



    fun syncNewsFromNetwork(){

        newsViewModel.getCivilizations()!!.observe(this) { news ->

            Log.d("RESP", news.toString())

            //itemsList.clear()


            for (item in news.data) {

                /*
                itemsList.add(item)

                val layoutManager = LinearLayoutManager(MainActivity@ this)
                cvRecyclerView.layoutManager = layoutManager
                newsAdapter = NewsAdapter(itemsList, this)
                cvRecyclerView.adapter = newsAdapter
                newsAdapter.notifyDataSetChanged()



                 */

                val thread = Thread {

                    var newsEntity = NewsEntity()

                    //newsEntity.newsId = (1..1000).random()
                    newsEntity.id = item.id
                    newsEntity.author = item.author
                    newsEntity.content = item.content
                    newsEntity.date = item.date
                    newsEntity.imageUrl = item.imageUrl
                    newsEntity.readMoreUrl = item.readMoreUrl
                    newsEntity.time = item.time
                    newsEntity.title = item.title
                    newsEntity.url = item.url

                    db.newsDao().saveNews(newsEntity)

                }
                thread.start()

            }

            //set sync status
            sharedPreference =  getSharedPreferences("SYNC_STATUS", Context.MODE_PRIVATE)
            editor = sharedPreference.edit()
            editor.putBoolean("hasSynced", true)
            editor.commit()

            //fetch data locally
            getdataLocalData()

            //syncing finished
            Log.d("NETWORK SYNC","Network sync finished")

            //Log.d("ITEMLIST",itemsList.toString())

        }
    }

    fun getdataLocalData(){

        //fetch data locally
        val thread = Thread { // CoroutineScope
            // coroutine body
            db.newsDao().getAllNews().forEach() {
                /*
                val layoutManager = LinearLayoutManager(MainActivity@ this)
                cvRecyclerView.layoutManager = layoutManager
                newsAdapter = NewsAdapter(itemsList, this)
                cvRecyclerView.adapter = newsAdapter
                newsAdapter.notifyDataSetChanged()

                 */

                itemsList.add(
                    NewsData(
                        it.author.toString(), it.content.toString(), it.date.toString(), it.id,
                        it.imageUrl.toString(), it.readMoreUrl.toString(), it.time.toString(),
                        it.title.toString(), it.url.toString()
                    )
                )



                this@MainActivity.runOnUiThread(java.lang.Runnable {
                    val layoutManager = LinearLayoutManager(MainActivity@this)
                    cvRecyclerView.layoutManager = layoutManager
                    newsAdapter = NewsAdapter(itemsList, MainActivity@this)
                    cvRecyclerView.adapter = newsAdapter
                    newsAdapter.notifyDataSetChanged()
                })

            }




        }

        thread.start()

    }

    override fun itemClick(newsImage: String, newsDescription: String) {
        intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("NEWS_IMAGE", newsImage)
        intent.putExtra("NEWS_DESCRIPTION", newsDescription)
        startActivity(intent)
    }
}