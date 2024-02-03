package com.divyanshu.movie_app_2.repository

import com.divyanshu.movie_app_2.api.ApiService
import com.divyanshu.movie_app_2.model.TVShowItem
import retrofit2.Response
import javax.inject.Inject

class TvShowRepository @Inject constructor(private val service: ApiService) {

    suspend fun getTvShow(): Response<List<TVShowItem>> = service.getTvShow()
}