package com.br.santanderdevweek.data.local

import com.br.santanderdevweek.data.Cartao
import com.br.santanderdevweek.data.Cliente
import com.br.santanderdevweek.data.Conta

class FakeData {

    fun getLocalData(): Conta{
        val cliente = Cliente("Olá, Filipe Carmo")
        val cartao = Cartao("0056")
        val conta = Conta(
                "252589-9",
                "0085",
                "Saldo + Limite: R$ 4.000,00",
                "R$ 2.500,00",
                cliente,
                cartao
        )

        return conta;
    }
}