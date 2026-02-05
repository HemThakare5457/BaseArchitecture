package com.example.data.network


import com.google.gson.annotations.SerializedName

data class ApiErrorDetails(
    @SerializedName("activityId")
    val activityId: String?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("statusCode")
    val statusCode: Int?
)