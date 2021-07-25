package com.example.latestnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detailed_news.*

class DetailedNews : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_news)

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()?.setHomeAsUpIndicator(R.drawable.back_button)

        val bundle: Bundle?= intent.extras
        val imageUrl = bundle!!.getString("image")
        val publishDate = bundle!!.getString("date")
        val articleTitle = bundle!!.getString("title")
        val articleDescription = bundle!!.getString("description")


        Picasso.get().load(imageUrl).into(image)
        date.text = publishDate
        theTitle.text = articleTitle
        description.text = articleDescription

    }
}