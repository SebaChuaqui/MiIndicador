package com.example.miindicador.local

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "indicadores_table")
data class IndicadoresEntity(
    @PrimaryKey @NonNull val id: Int,
    val bitcoincodigo: String,
    val bitcoinnombre: String,
    val bitcoinvalor: String,
    val dolarcodigo: String,
    val dolarnombre: String,
    val dolarvalor: String,
    val dolarIntercambiocodigo: String,
    val dolarIntercambionombre: String,
    val dolarIntercambiovalor: String,
    val eurocodigo: String,
    val euronombre: String,
    val eurovalor: String,
    val imaceccodigo: String,
    val imacecnombre: String,
    val imacecvalor: String,
    val ipccodigo: String,
    val ipcnombre: String,
    val ipcvalor: String,
    val ivpcodigo: String,
    val ivpnombre: String,
    val ivpvalor: String,
    val libracobrecodigo: String,
    val libracobrenombre: String,
    val libracobrevalor: String,
    val tasadesempleocodigo: String,
    val tasadesempleonombre: String,
    val tasadesempleovalor: String,
    val tpmcodigo: String,
    val tpmnombre: String,
    val tpmvalor: String,
    val ufcodigo: String,
    val ufnombre: String,
    val ufvalor: String,
    val utmcodigo: String,
    val utmnombre: String,
    val utmvalor: String
    )