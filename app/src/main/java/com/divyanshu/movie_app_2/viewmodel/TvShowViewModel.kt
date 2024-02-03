package com.divyanshu.movie_app_2.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.divyanshu.movie_app_2.model.TVShowItem
import com.divyanshu.movie_app_2.repository.TvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel @Inject constructor(private val repository: TvShowRepository) : ViewModel() {

    private val TAG = TvShowViewModel::class.java.canonicalName
    private val tvShowResponse = MutableLiveData<List<TVShowItem>>()
    val tvShow: LiveData<List<TVShowItem>>
        get() = tvShowResponse

    init {
        getTvShow()
    }

    fun getTvShow() = viewModelScope.launch {
        repository.getTvShow().let {
            if (it.isSuccessful) {
                tvShowResponse.postValue(it.body())
            } else {
                Log.d(TAG, "${it.code()}")
            }
        }
    }

}