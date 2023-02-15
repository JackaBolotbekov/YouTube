package com.example.youtube.data.model

import com.google.gson.annotations.SerializedName

data class VideoResponse <T>(
    @SerializedName("prevPageToken")
    val prevPageToken: String = "",
    @SerializedName("kind")
    val kind: String = "",
    @SerializedName("nextPageToken")
    val nextPageToken: String = "",
    @SerializedName("pageInfo")
    val pageInfo: PageInfo,
    @SerializedName("etag")
    val etag: String = "",
    @SerializedName("items")
    val items: List<T>
)