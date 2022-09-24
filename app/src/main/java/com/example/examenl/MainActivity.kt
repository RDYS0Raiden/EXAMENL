package com.example.examenl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.view.isVisible
import com.example.examenl.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var myHandler:Handler

    var fibonacci= mutableListOf<Int>(10)

    var numero:String=""
    var numeroUsu:Int=0
    var ObtenerNumero:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        myHandler=Handler(mainLooper)
        setContentView(binding.root)
        binding.btnprocesar.setOnClickListener {
            Hilo()
            Fibonacci()
            resultado()
        }
        binding.btnpasar.setOnClickListener {
            pasarPantalla2()
        }

    }
    private fun Hilo(){
        //Thread == hilo no te olvides
        var numero2:String=""
        //un hilo debe tener try , catch y al final debe tener .start()
        Thread{
            try {
                for (i in 1..10){
                    Thread.sleep(500)
                    myHandler.post{
                        binding.apply {
                            txtconteo.text = "$i"
                            pltxtnumero.isVisible =true
                            numero2 = binding.pltxtnumero.text.toString()
                            if (numero==numero2){
                                binding.btnpasar.isVisible=true
                            }
                        }
                    }
                }
                myHandler.post{
                    binding.pltxtnumero.isVisible=true
                    if (numero == numero2){
                        binding.btnpasar.isVisible=true
                        binding.txtconteo.text = "Usted Gano"
                    }else{
                        binding.txtconteo.text = "Usted perdio siga intentando"
                    }
                }

            } catch (e: InterruptedException){
                e.printStackTrace()
            }
        }.start()
    }
    private fun Fibonacci(){
        var fib = 0
        var aux = 1
        for(i in 0 .. 10){
            aux += fib
            fib = aux-fib
            fibonacci.add(i,fib)
        }
    }
    private fun resultado(){
        var aleatorio:Int = (0..9).random()
        numero = fibonacci[aleatorio].toString()
        ObtenerNumero=numero.toInt()
        binding.txtmostrar.text = numero

    }
    private fun pasarPantalla2(){
        resultado()
        val valor= ObtenerNumero
        val intent= Intent(this,pantalla2::class.java)
        intent.apply {
            putExtra("valor", valor)
        }
        startActivity(intent)
    }

}