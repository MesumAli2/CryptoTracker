package com.mesum.cryptotracker.presentation.coin_detail

import com.mesum.cryptotracker.domain.model.Coin
import com.mesum.cryptotracker.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading : Boolean = false,
    val coins : CoinDetail? = null,
    val error : String = ""
)
