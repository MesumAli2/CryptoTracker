package com.mesum.cryptotracker.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mesum.cryptotracker.common.Resource
import com.mesum.cryptotracker.domain.use_case.get_coins.GetCoinsUseCase

import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class CoinListViewModel  constructor(
    private val  getCoinUserCase : GetCoinsUseCase

) : ViewModel(){

    private val _state = mutableStateOf<CoinListState>(CoinListState())
    val state : State<CoinListState> = _state

    init {
        getCoins()
    }
    private fun getCoins(){
        getCoinUserCase().onEach { result ->
            when(result){
                is  Resource.Success -> {
                    _state. value = CoinListState(coins = result.data ?: emptyList() )
                }
                is Resource.Error ->{
                _state.value = CoinListState(error = result.message ?:
                "An unexpected error occurred")
                }
                is Resource.Loading ->{
                    _state.value = CoinListState(isLoading = false)
                }
            }
        }.launchIn(viewModelScope )
    }


}