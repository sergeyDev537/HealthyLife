package com.exlab.healthylife.data.network.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AccountDto(
    @Json(name = "email")
    val email: String,
    @Json(name = "password")
    val password: String
)