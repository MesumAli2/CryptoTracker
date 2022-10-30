package com.mesum.cryptotracker.presentation.coin_detail.component

import com.mesum.cryptotracker.presentation.coin_detail.CoinDetailViewModel
import com.mesum.cryptotracker.presentation.coin_list.CoinListViewModel

package com.mesum.cryptotracker.presentation.coin_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mesum.cryptotracker.presentation.Screen
import com.mesum.cryptotracker.presentation.coin_list.component.CoinListItem

@Composable
fun Screen.CoinDetailScreen(
    viewModel: CoinDetailViewModel
) {

    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()){
        state.coins.let { coin ->

        }

        if (state.error.isNotBlank()){
            Text(text =state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}