package cz.utb.fai.opennews

import android.content.Context

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso

import cz.utb.fai.opennews.databinding.NewsDetailBinding


class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val binding = NewsDetailBinding.inflate(layoutInflater)

        Picasso.get().load(intent.getStringExtra("NEWS_IMAGE").toString()).into(binding.newsImage)
        binding.newsDescription.text = intent.getStringExtra("NEWS_DESCRIPTION")

        setContentView(binding.root)
    }


}