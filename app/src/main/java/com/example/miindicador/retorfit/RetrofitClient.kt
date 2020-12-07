package com.example.miindicador.retorfit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        private const val URL_BASE = "https://mindicador.cl/"

        fun getRetrofitClient(): ApiIndicadores {
            val mRetrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return mRetrofit.create(ApiIndicadores::class.java)
        }
    }
}