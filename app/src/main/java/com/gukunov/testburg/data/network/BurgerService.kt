package com.gukunov.testburg.data.network

import com.gukunov.testburg.domain.entity.BurgerItem
import retrofit2.http.GET

interface BurgerService {

    @GET("burgers")
    suspend fun getBurgerList(): List<BurgerItem>

}
