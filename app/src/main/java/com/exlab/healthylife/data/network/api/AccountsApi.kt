package com.exlab.healthylife.data.network.api

import com.exlab.healthylife.data.network.models.AccountDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AccountsApi {

    @POST("user/login")
    suspend fun signIn(@Body body: AccountDto)

    @POST("user/register")
    suspend fun signUp(@Body body: AccountDto)

}