package com.example.miindicador.repo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.miindicador.local.IndicadoresDBClient
import com.example.miindicador.local.IndicadoresEntity

class IndicadoresViewModel(application: Application): AndroidViewModel(application) {
    private val mRepository: IndicadoresRepository
    val liveDataFromLocal : LiveData<List<IndicadoresEntity>>

    init {
        val mIndicadoresDao = IndicadoresDBClient.getDatabase(application).indicadoresDao()
        mRepository = IndicadoresRepository(mIndicadoresDao)
        mRepository.getDataFromServerWithOutCoroutines()
        liveDataFromLocal = mRepository.allIndicadoresLiveData
    }
    fun getIndicadoresByid(id: String): LiveData<IndicadoresEntity> {
        return mRepository.getIndicadoresByid(id)
    }
    fun deleteAll(){
        mRepository.deleteAllIndicadores()
    }
    fun insertOneIndicadores(mIndicadoresEntity: IndicadoresEntity) {
        mRepository.insertOneIndicadores(mIndicadoresEntity)
    }
}