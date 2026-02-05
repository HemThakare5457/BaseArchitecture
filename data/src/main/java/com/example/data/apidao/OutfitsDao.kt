package com.example.data.apidao

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface OutfitsDao {

    @GET("FETCH_TASKS")
    @Headers("HTTP_HEADER_CONTENT_TYPE", "HTTP_HEADER_ACCEPT")
    fun getOutfits(
        @Query("ORGANIZATION_FILTER_ID") organizationFilterId: Int
    ): Call<List<String>>
}