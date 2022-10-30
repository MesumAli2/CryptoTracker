package com.mesum.cryptotracker.domain.use_case.get_coin

import com.mesum.cryptotracker.common.Resource
import com.mesum.cryptotracker.data.remote.dto.toCoin
import com.mesum.cryptotracker.data.remote.dto.toCoinDetail
import com.mesum.cryptotracker.domain.model.Coin
import com.mesum.cryptotracker.domain.model.CoinDetail
import com.mesum.cryptotracker.domain.repository.CoinRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import java.util.concurrent.Flow
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository : CoinRepository
    ){

    operator fun invoke(coinID : String): kotlinx.coroutines.flow.Flow<Resource<CoinDetail>> = flow {
        try{
            emit(Resource.Loading())
            val coins = repository.getCoinsById(coinId = coinID).toCoinDetail()
            emit(Resource.Success(coins))
        }catch (e : HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))

        } catch (e : IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}