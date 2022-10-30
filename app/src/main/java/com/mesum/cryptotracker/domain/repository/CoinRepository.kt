package com.mesum.cryptotracker.domain.repository

import com.mesum.cryptotracker.data.remote.dto.CoinDetailDto
import com.mesum.cryptotracker.data.remote.dto.CoinDto
import com.mesum.cryptotracker.domain.model.CoinDetail
import java.sql.RowId

interface CoinRepository {

    suspend fun getCoins() : List<CoinDto>

    suspend fun getCoinsById(coinId: String) : CoinDetailDto
}