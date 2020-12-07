package com.example.miindicador

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.miindicador.local.IndicadoresEntity
import com.example.miindicador.repo.IndicadoresAdapter
import com.example.miindicador.repo.IndicadoresViewModel
import com.example.miindicador.repo.PassTheData
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment(), PassTheData {

    private val model: IndicadoresViewModel by activityViewModels()
    lateinit var mAdapter: IndicadoresAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAdapter = IndicadoresAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mRecyclerView = RecyclerViewIndicadores
        RecyclerViewIndicadores.adapter = mAdapter
        RecyclerViewIndicadores.layoutManager = LinearLayoutManager(context)
        model.liveDataFromLocal.observe(viewLifecycleOwner, Observer {
            it?.let {
                mAdapter.updateAdapter(it)
            }

        })

    }

    override fun passTheIndicadores(indicadores: IndicadoresEntity) {

        val mBundle = Bundle()
        mBundle.putString("id", indicadores.id.toString())
        mBundle.putString("bitcoin", indicadores.bitcoinnombre)
        mBundle.putString("bitcoin", indicadores.dolarnombre)
        mBundle.putString("bitcoin", indicadores.dolarIntercambionombre)
        mBundle.putString("bitcoin", indicadores.euronombre)
        mBundle.putString("bitcoin", indicadores.imacecnombre)
        mBundle.putString("bitcoin", indicadores.ipcnombre)
        mBundle.putString("bitcoin", indicadores.ivpnombre)
        mBundle.putString("bitcoin", indicadores.libracobrenombre)
        mBundle.putString("bitcoin", indicadores.tasadesempleonombre)
        mBundle.putString("bitcoin", indicadores.tpmnombre)
        mBundle.putString("bitcoin", indicadores.ufnombre)
        mBundle.putString("bitcoin", indicadores.utmnombre)


        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, mBundle)


    }
}