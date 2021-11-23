package com.example.listas_jorge_carlos_parra
//creamos un objeto que se encarge de guardas las rutas
sealed class Destinations (
    val route: String
    ){
    object Vista1: Destinations("Vista1")
    object Vista2: Destinations("Vista2/{img}/{title}/{info}"){
        //necesitamos esta funcion para poder pasar los parametros del objeto que usemos
        fun PassAnime(
            img: String,
            title: String,
            info: String
        ): String { return "Vista2/$img/$title/$info"
        }
    }
}