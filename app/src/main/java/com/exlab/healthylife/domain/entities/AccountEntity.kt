package com.exlab.healthylife.domain.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class AccountEntity(
    val email: String,
    val password: String
)

