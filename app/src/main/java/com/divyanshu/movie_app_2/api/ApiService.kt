package com.divyanshu.movie_app_2.api

import com.divyanshu.movie_app_2.helper.Constants
import com.divyanshu.movie_app_2.model.TVShowItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getTvShow(): Response<List<TVShowItem>>
}