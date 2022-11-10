package com.mesum.cryptotracker.domain.use_case.get_coins

import com.mesum.cryptotracker.common.Resource
import com.mesum.cryptotracker.data.remote.dto.toCoin
import com.mesum.cryptotracker.domain.model.Coin
import com.mesum.cryptotracker.domain.repository.CoinRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetCoinsUseCase constructor(
    private val repository : CoinRepository
    ){

    operator fun invoke(): kotlinx.coroutines.flow.Flow<Resource<List<Coin>>> = flow {
        try{
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        }catch (e : HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))

        } catch (e : IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}