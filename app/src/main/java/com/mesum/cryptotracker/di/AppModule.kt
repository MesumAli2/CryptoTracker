package com.mesum.cryptotracker.di

import com.mesum.cryptotracker.common.Constants
import com.mesum.cryptotracker.data.remote.CoinPaprikaApi
import com.mesum.cryptotracker.data.repository.CoinRepositoryImpl
import com.mesum.cryptotracker.domain.repository.CoinRepository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object AppModule {

    fun providePaprikaApi(): CoinPaprikaApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }


    fun providesCoinRepository(api : CoinPaprikaApi) : CoinRepository{
        return CoinRepositoryImpl(api)
    }

}