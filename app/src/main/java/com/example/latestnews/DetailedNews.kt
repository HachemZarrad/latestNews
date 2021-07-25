package com.example.latestnews

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import androidx.annotation.RequiresApi
import com.example.latestnews.Models.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detailed_news.*

class DetailedNews : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
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

        val article = Article()
        date.text = article.parseDate(publishDate)

        theTitle.text = articleTitle

        description.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(articleDescription, Html.FROM_HTML_MODE_COMPACT)
        } else {
            Html.fromHtml(articleDescription,5)
        }

    }
}