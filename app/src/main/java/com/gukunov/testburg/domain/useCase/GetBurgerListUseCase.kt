package com.gukunov.testburg.domain.useCase

import com.gukunov.testburg.common.Resource
import com.gukunov.testburg.data.repository.BurgerRepositoryInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetBurgerListUseCase @Inject constructor(private val burgerRepositoryInterface: BurgerRepositoryInterface){
     fun execute() = flow {
        emit(Resource.Loading())
        burgerRepositoryInterface.getBurgerList()?.let {
            emit(Resource.Success(it))
        }?:emit(Resource.Error("Error"))
    }.catch {
        emit(Resource.Error(it.localizedMessage))
    }

}