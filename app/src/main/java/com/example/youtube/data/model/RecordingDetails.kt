package com.example.youtube.data.model

import com.google.gson.annotations.SerializedName

data class RecordingDetails(
    @SerializedName("recordingDate")
    val recordingDate: String = ""
)