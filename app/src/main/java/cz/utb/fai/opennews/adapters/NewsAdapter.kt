package com.adastra_one.ageofempires.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import cz.utb.fai.opennews.MainActivity
import cz.utb.fai.opennews.R
import cz.utb.fai.opennews.databinding.NewsItemBinding

import cz.utb.fai.opennews.model.NewsData



class NewsAdapter(
    var itemsList:List<NewsData>,
    context: MainActivity
): RecyclerView.Adapter<NewsAdapter.MyViewHolder>()
{
    var cont = context
    //var onClickListener = onClickListener
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = NewsItemBinding.bind(view)

        var newsHeading = binding.newsHeading
        var newsImage = binding.newsImage
        var itemMainView = binding.itemMainView

        /*
        var cardView = binding.cardView
        var name = binding.name
        var expansion = binding.expansion
        var armyType = binding.armyType
        var teamBonus = binding.teamBonus
        var button1 = binding.button1
        var button2 = binding.button2
        */


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemsList[position]

        holder.newsHeading.text = item.content//item.data.get(position).content

        Picasso.get().load(item.imageUrl).into(holder.newsImage)

        holder.itemMainView.setOnClickListener {
            cont.itemClick(item.imageUrl, item.content)
        }

        /*
        holder.cardView.setOnClickListener { cont.itemClick(item.name, item.expansion, item.army_type, item.team_bonus, item.civilization_bonus)   /*onClickListener.onClick(holder.topView)*/ }
        holder.name.text = item.name
        holder.expansion.text = item.expansion
        holder.armyType.text = item.army_type
        holder.teamBonus.text = item.team_bonus

        holder.button1.setOnClickListener { cont.buttonOneClick() }
        holder.button2.setOnClickListener { cont.buttonTwoClick() }

         */

    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}