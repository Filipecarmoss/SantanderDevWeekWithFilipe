package com.br.santanderdevweek.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.santanderdevweek.data.Conta
import com.br.santanderdevweek.data.local.FakeData

class MainViewModel : ViewModel() {

    private val mutableLiveData: MutableLiveData<Conta> = MutableLiveData()

    fun buscarContaCliente(): LiveData<Conta>{

        mutableLiveData.value = FakeData(). getLocalData()

        return mutableLiveData
    }
}