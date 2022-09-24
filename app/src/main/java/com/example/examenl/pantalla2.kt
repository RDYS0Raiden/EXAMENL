package com.example.examenl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examenl.databinding.ActivityMainBinding
import com.example.examenl.databinding.ActivityPantalla2Binding
import java.text.SimpleDateFormat
import java.util.*

class pantalla2 : AppCompatActivity() {

    private lateinit var binding: ActivityPantalla2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPantalla2Binding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        var fechaHoy : String
        var creditos : Int
        fechaHoy=FechaActual()
        var tiempoHoy=fechaHoy
        creditos =calcularCreditos()
        //.
        val resultado="""
            Nombre Completo: Luis Alberto Ticona Alcocer
            Jugo en fecha:$tiempoHoy
            Gano Puntos: ${intent.getIntExtra("valor",0)}
            Sus Creditos Son:$creditos
            
        """.trimIndent()

        binding.textView2.text=resultado

    }
    private fun FechaActual():String{
        var calendar: Calendar = Calendar.getInstance()
        var simpleDateFormat: SimpleDateFormat = SimpleDateFormat("dd-MM-yyyy")
        var dateTime:String = simpleDateFormat.format(calendar.time).toString()
        return dateTime
    }
    private fun calcularCreditos ():Int{
        var puntos=intent.getIntExtra("valor",0)
        var porcentaje=(puntos *0.15)
        var creditos = porcentaje+puntos+9

        return creditos.toInt()
    }
    private fun productos(){
        var productos = mutableListOf<String>("Tele LG..30 creditos","DVD Philips","Logitech G-915",)
        var precios = mutableListOf<Int>(30,50,25,10,5,3)
    }

    private fun llenarClase(){
        Articulos("S21",Marca.Samsung,20)
        Articulos("Iphone 14",Marca.Apple,50)
        Articulos("televisor curvo",Marca.LG,25)
        Articulos("Google Home",Marca.Gogle,10)
        Articulos("Mi12",Marca.xiaomi,30)
    }
    private fun filtrarProductos(){
        var p:List<Articulos> = (listOf<Articulos>())
        val productosDisponibles:List<Articulos> = p.filter {it.verificarProducto(1000)}
    }
}