package com.example.youtube.data.remote.apiservices

import com.example.youtube.data.model.PopularVideo
import com.example.youtube.data.model.VideoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoCategoryApiService {

    @GET("videos")
    suspend fun fetchVideo(
        @Query("regionCode") regionCode: String,
        @Query("chart") chart: String,
        @Query("part") part: String,
        @Query("pageToken") nextPageToken: String
    ): VideoResponse<PopularVideo>
}