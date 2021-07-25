package com.example.latestnews

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latestnews.Adapters.ArticleAdapter
import com.example.latestnews.Common.Common
import com.example.latestnews.Interfaces.RetrofitService
import com.example.latestnews.Models.Article
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var mService : RetrofitService
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter : ArticleAdapter
    lateinit var dialog: AlertDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retrofitService

        recyclerArticlesList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerArticlesList.layoutManager = layoutManager

        dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()

        getArticlesList()
    }

    private fun getArticlesList() {
        dialog.show()

        mService.getArticlesList().enqueue(object : Callback<MutableList<Article>> {
            override fun onFailure(call: Call<MutableList<Article>>, t: Throwable) {
                TODO("not implemented")
            }

            override fun onResponse(call: Call<MutableList<Article>>, response: Response<MutableList<Article>>) {
                var list = response.body() as MutableList<Article>
                adapter = ArticleAdapter(baseContext, list)
                adapter.notifyDataSetChanged()
                recyclerArticlesList.adapter = adapter

                dialog.dismiss()
                adapter.setOnItemClickListener(object : ArticleAdapter.onItemClickListener{
                    override fun onItemClick(position: Int) {
                            Toast.makeText(this@MainActivity, "You clicked on item $position", Toast.LENGTH_SHORT).show()
                    }
                })
            }

        })
    }


}