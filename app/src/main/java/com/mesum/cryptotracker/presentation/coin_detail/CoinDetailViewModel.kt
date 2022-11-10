package com.mesum.cryptotracker.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mesum.cryptotracker.common.Constants
import com.mesum.cryptotracker.common.Resource
import com.mesum.cryptotracker.domain.use_case.get_coin.GetCoinUseCase

import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class CoinDetailViewModel constructor(
    private val  getCoinUseCase : GetCoinUseCase,
    savedStateHandle: SavedStateHandle

) : ViewModel(){

    private val _state = mutableStateOf<CoinDetailState>(CoinDetailState())
    val state : State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getCoins(coinId)

        }
    }
    private fun getCoins(coinId : String){
        getCoinUseCase(coinId).onEach { result ->
            when(result){
                is  Resource.Success -> {
                    _state. value = CoinDetailState(coins = result.data  )
                }
                is Resource.Error ->{
                _state.value = CoinDetailState(error = result.message ?:
                "An unexpected error occurred")
                }
                is Resource.Loading ->{
                    _state.value = CoinDetailState(isLoading = false)
                }
            }
        }.launchIn(viewModelScope )
    }


}