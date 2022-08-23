package com.submission.yugioh.utils

import android.content.Context
import androidx.swiperefreshlayout.widget.CircularProgressDrawable

object Constants {

    const val BASE_URL = "https://db.ygoprodeck.com/"

    fun Context.progressIndicator(): CircularProgressDrawable {
        return CircularProgressDrawable(this).apply {
            strokeWidth = 5f
            centerRadius = 30f
            start()
        }
    }
}