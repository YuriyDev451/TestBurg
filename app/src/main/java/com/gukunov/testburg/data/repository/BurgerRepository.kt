package com.gukunov.testburg.data.repository

import com.gukunov.testburg.data.network.BurgerService
import com.gukunov.testburg.domain.entity.BurgerItem
import javax.inject.Inject

interface BurgerRepositoryInterface{
    suspend fun getBurgerList(): List<BurgerItem>
}

class BurgerRepository @Inject constructor(private val burgerService: BurgerService): BurgerRepositoryInterface {
    override suspend fun getBurgerList(): List<BurgerItem> {
        return burgerService.getBurgerList()
    }
}