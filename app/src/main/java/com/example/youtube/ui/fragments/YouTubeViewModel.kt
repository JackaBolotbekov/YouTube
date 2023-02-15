package com.example.youtube.ui.fragments

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.youtube.base.BaseViewModel
import com.example.youtube.data.repositories.VideoCategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class YouTubeViewModel @Inject constructor(private val repository: VideoCategoryRepository) :
    BaseViewModel() {

    fun fetchVideosPopular(regionCode: String, chart: String, part: String) =
        repository.fetchVideosPopular(regionCode, chart, part).cachedIn(viewModelScope)
}