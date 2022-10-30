package com.mesum.cryptotracker.data.repository

import com.mesum.cryptotracker.data.remote.CoinPaprikaApi
import com.mesum.cryptotracker.data.remote.dto.CoinDetailDto
import com.mesum.cryptotracker.data.remote.dto.CoinDto
import com.mesum.cryptotracker.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor( private val api : CoinPaprikaApi
) : CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinsById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }

}