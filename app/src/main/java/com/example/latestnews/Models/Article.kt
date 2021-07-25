package com.example.latestnews.Models

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class Article {
    var id: String? = null
    var title: String? = null
    var external_link: String? = null
    var thumbnail: String? = null
    var created_at: String? = null
    var updated_at: String? = null
    var state_id: String? = null
    var place_id: String? = null
    var category_id: String? = null
    var expire: String? = null
    var html: String? = null
    var publish_date: String? = null
    var place: String? = null

    fun parseDate(time: String?): String? {
        val inputPattern = "yyyy-MM-dd HH:mm:ss"
        val outputPattern = "yyyy MMM dd"
        val inputFormat = SimpleDateFormat(inputPattern)
        val outputFormat = SimpleDateFormat(outputPattern)
        var date: Date? = null
        var str: String? = null
        try {
            date = inputFormat.parse(time)
            str = outputFormat.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return str
    }
}
