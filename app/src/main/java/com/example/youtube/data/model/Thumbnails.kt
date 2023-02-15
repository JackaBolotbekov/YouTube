package com.example.youtube.data.model

import com.google.gson.annotations.SerializedName

data class Thumbnails(
    @SerializedName("standard")
    val standard: Standard
)