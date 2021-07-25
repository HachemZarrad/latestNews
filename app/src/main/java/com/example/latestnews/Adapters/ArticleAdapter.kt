package com.example.latestnews.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.latestnews.Models.Article
import com.example.latestnews.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_article_item.view.*


class ArticleAdapter(private val context: Context, private val articlesList: MutableList<Article>): RecyclerView.Adapter<ArticleAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.layout_article_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return articlesList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Picasso.get().load(articlesList[position].thumbnail).into(holder.image)
        holder.date.text = articlesList[position].publish_date
        holder.title.text = articlesList[position].title
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image : ImageView
        var date : TextView
        var title : TextView

        init {
            image = itemView.image
            date = itemView.date
            title = itemView.title
        }
    }

}