package com.example.miindicador.repo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.miindicador.R
import com.example.miindicador.local.IndicadoresEntity
import kotlinx.android.synthetic.main.indicadores.view.*

class IndicadoresAdapter(val mPassTheData: PassTheData): RecyclerView.Adapter<IndicadoresAdapter.IndicadoresViewHolder>() {

    private var indicadoresList = emptyList<IndicadoresEntity>()

    fun updateAdapter(mList: List<IndicadoresEntity>){
        indicadoresList= mList
        notifyDataSetChanged()
    }

    inner class IndicadoresViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val name = itemView.idNombre

        val clickListener = itemView.setOnClickListener{
            mPassTheData.passTheIndicadores((indicadoresList[adapterPosition]))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IndicadoresViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.indicadores,parent,false)
        return IndicadoresViewHolder(view)
    }

    override fun onBindViewHolder(holder: IndicadoresViewHolder, position: Int) {
        val indicadores= indicadoresList[position]
        holder.name.text = indicadores.id.toString()
        holder.name.text = indicadores.bitcoincodigo
        holder.name.text = indicadores.bitcoinnombre
        holder.name.text = indicadores.bitcoinvalor
        holder.name.text = indicadores.dolarcodigo
        holder.name.text = indicadores.dolarnombre
        holder.name.text = indicadores.dolarvalor
        holder.name.text = indicadores.dolarIntercambiocodigo
        holder.name.text = indicadores.dolarIntercambiocodigo
        holder.name.text = indicadores.dolarIntercambiovalor
        holder.name.text = indicadores.eurocodigo
        holder.name.text = indicadores.euronombre
        holder.name.text = indicadores.eurovalor
        holder.name.text = indicadores.imaceccodigo
        holder.name.text = indicadores.imacecnombre
        holder.name.text = indicadores.imacecvalor
        holder.name.text = indicadores.ipccodigo
        holder.name.text = indicadores.ipcnombre
        holder.name.text = indicadores.ipcvalor
        holder.name.text = indicadores.ivpcodigo
        holder.name.text = indicadores.ivpnombre
        holder.name.text = indicadores.ivpvalor
        holder.name.text = indicadores.libracobrecodigo
        holder.name.text = indicadores.libracobrenombre
        holder.name.text = indicadores.libracobrevalor
        holder.name.text = indicadores.tasadesempleocodigo
        holder.name.text = indicadores.tasadesempleonombre
        holder.name.text = indicadores.tasadesempleovalor
        holder.name.text = indicadores.tpmcodigo
        holder.name.text = indicadores.tpmnombre
        holder.name.text = indicadores.tpmvalor
        holder.name.text = indicadores.ufcodigo
        holder.name.text = indicadores.ufnombre
        holder.name.text = indicadores.ufvalor
        holder.name.text = indicadores.utmcodigo
        holder.name.text = indicadores.utmnombre
        holder.name.text = indicadores.utmvalor

    }

    override fun getItemCount()=indicadoresList.size
}
interface PassTheData {
    fun passTheIndicadores(indicadores: IndicadoresEntity)
}