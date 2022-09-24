package com.example.examenl

data class Articulos (
    val nombre: String,
    val marca:Marca,
    val Precio: Int
    ){
        fun verificarProducto (creditos:Int):Boolean
        {
            var mensaje:Boolean
            if (creditos>=10 && creditos>=25)
                mensaje = true
            else
                if (creditos>=30 && creditos>=50)
                    mensaje=true
                else
                    mensaje=false

            return mensaje
        }
        fun MostrarProductos(){
            println("""
            Nombre:$nombre --> Marca: $marca --> Precio: $Precio
        """.trimIndent())
        }
}