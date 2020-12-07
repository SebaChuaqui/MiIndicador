package com.example.miindicador.local

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.miindicador.pojos.Indicadores
import com.example.miindicador.retorfit.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class IndicadoresRepository(private val indicadoresDao: IndicadoresDao) {

    private val retroService = RetrofitClient.getRetrofitClient()

    // Este muestra toda la tabla de super heroes entity
    val allIndicadoresLiveData = indicadoresDao.showAllIndicadores()

    fun getIndicadoresByid(id: String): LiveData<IndicadoresEntity> {
        return indicadoresDao.showOneIndicadoresById(id)
    }

    fun deleteAllIndicadores() {
        indicadoresDao.deleteAllIndicadores()
    }

    fun insertOneIndicadores(mIndicadores: IndicadoresEntity) {
        indicadoresDao.insertOneIndicadores(mIndicadores)
    }

    fun getDataFromServerWithOutCoroutines() {
        val call = retroService.fetchAllIndicadores()
        call.enqueue(object : Callback<Indicadores> {
            override fun onResponse(
                call: Call<Indicadores>,
                response: Response<Indicadores>
            ) {
                when (response.code()) {
                    in 200..299 -> CoroutineScope(Dispatchers.IO).launch {
                        response.body()?.let {
                            indicadoresDao.insertAllIndicadores(converters(listOf(it)))
                        }
                    }
                    in 300..399 -> Log.d("acierto", response.body().toString())
                    in 400..499 -> Log.d("acierto", response.body().toString())
                    in 500..599 -> Log.d("acierto", response.body().toString())
                    else -> Log.d("acierto", response.body().toString())
                }
            }

            override fun onFailure(call: Call<Indicadores>, t: Throwable) {
                Log.e("error", t.message.toString())
            }
        })
    }

    fun converters(listFromNetwork: List<Indicadores>): List<IndicadoresEntity> {
        val listMutable = mutableListOf<IndicadoresEntity>()

        listFromNetwork.map {
            listMutable.add(
                IndicadoresEntity(
                    id = 0,
                    it.bitcoin.codigo,
                    it.bitcoin.nombre,
                    it.bitcoin.valor.toString(),
                    it.dolar.codigo,
                    it.dolar.nombre,
                    it.dolar.valor.toString(),
                    it.dolarIntercambio.codigo,
                    it.dolarIntercambio.nombre,
                    it.dolarIntercambio.valor.toString(),
                    it.euro.codigo,
                    it.euro.nombre,
                    it.euro.valor.toString(),
                    it.imacec.codigo,
                    it.imacec.nombre,
                    it.imacec.valor.toString(),
                    it.ipc.codigo,
                    it.ipc.nombre,
                    it.ipc.valor.toString(),
                    it.ivp.codigo,
                    it.ivp.nombre,
                    it.ivp.valor.toString(),
                    it.libraCobre.codigo,
                    it.libraCobre.nombre,
                    it.libraCobre.valor.toString(),
                    it.tasaDesempleo.codigo,
                    it.tasaDesempleo.nombre,
                    it.tasaDesempleo.valor.toString(),
                    it.tpm.codigo,
                    it.tpm.nombre,
                    it.tpm.valor.toString(),
                    it.uf.codigo,
                    it.uf.nombre,
                    it.uf.valor.toString(),
                    it.utm.codigo,
                    it.utm.nombre,
                    it.utm.valor.toString()
                )
            )}
        return listMutable
    }
}
