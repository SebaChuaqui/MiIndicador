package com.example.miindicador.retorfit

import com.example.miindicador.pojos.Indicadores
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiIndicadores {

    //vieja confiable
    @GET("api/")
    fun fetchAllIndicadores(): Call<Indicadores>


    //Corroutines
    @GET("api/")
    suspend fun ferchAllIndicadoresWithCorroutines(): Response<Indicadores>
}