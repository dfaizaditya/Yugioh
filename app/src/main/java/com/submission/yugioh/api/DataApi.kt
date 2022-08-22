package com.submission.yugioh.api

import com.submission.yugioh.model.Card
import com.submission.yugioh.model.DataResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DataApi {

    @GET("api/v7/cardinfo.php")
    suspend fun getData(
        @Query("num") num: Int,
        @Query("offset") offset: Int,
        @Query("sort") new: String
    ): DataResponse

}