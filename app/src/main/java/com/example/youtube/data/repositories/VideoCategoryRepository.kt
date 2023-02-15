package com.example.youtube.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.youtube.base.BaseRepository
import com.example.youtube.data.remote.apiservices.VideoCategoryApiService
import com.example.youtube.data.remote.pagingsource.PopularVideoPagingSource
import javax.inject.Inject

class VideoCategoryRepository @Inject constructor(private val service: VideoCategoryApiService) :
    BaseRepository() {

    fun fetchVideosPopular(regionCode: String, chart: String, part: String) =
        Pager(PagingConfig(pageSize = 10, enablePlaceholders = false)) {
            PopularVideoPagingSource(service, regionCode, chart, part)
        }.liveData
}