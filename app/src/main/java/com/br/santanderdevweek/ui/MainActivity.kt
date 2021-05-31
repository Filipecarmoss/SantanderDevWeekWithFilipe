package com.br.santanderdevweek.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.br.santanderdevweek.R
import com.br.santanderdevweek.data.Conta
import java.lang.RuntimeException

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar)) // exibir a toolbar que criei em menu
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        buscarContaCliente()

        //throw RuntimeException("Test Crash") //Força a Crash

    }

    private fun buscarContaCliente(){
        mainViewModel.buscarContaCliente().observe(this, Observer { result ->
            bindOnView(result)

        })

    }

    private fun bindOnView(conta:Conta){

        findViewById<TextView>(R.id.tv_agencia).text = conta.agencia
        findViewById<TextView>(R.id.tv_conta).text = conta.numero
        findViewById<TextView>(R.id.tv_saldo).text = conta.saldo
        findViewById<TextView>(R.id.tv_saldo_limite).text = conta.limite
        findViewById<TextView>(R.id.cartao_final_value).text = conta.cartao.numeroCartao
        findViewById<TextView>(R.id.tv_usuario).text = conta.cliente.nome

    }


    //Menu que foi criado

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.main_manu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.item3 ->{
                Toast.makeText(this,"Clicou no Sino", Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}