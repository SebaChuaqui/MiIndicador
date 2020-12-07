package com.example.miindicador.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface IndicadoresDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOneIndicadores(mIndicadores: IndicadoresEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAllIndicadores(mList: List<IndicadoresEntity>)

    @Update
    fun updateOneIndicadores(mIndicadores: IndicadoresEntity)

    @Update
    fun updateAllIndicadores(mList: IndicadoresEntity)

    @Query("SELECT * FROM indicadores_table")
    fun showAllIndicadores(): LiveData<List<IndicadoresEntity>>

    @Query("SELECT * FROM indicadores_table WHERE id=:mId" )
    fun showOneIndicadoresById(mId: String): LiveData<IndicadoresEntity>

    @Delete
    fun deleteOneIndicadores(mIndicadores:IndicadoresEntity)

    @Query("DELETE  FROM indicadores_table")
    fun  deleteAllIndicadores()

    @Delete
    fun delleteAllIndicadores(mList: List<IndicadoresEntity>)
}