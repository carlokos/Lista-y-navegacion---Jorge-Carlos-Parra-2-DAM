package com.example.listas_jorge_carlos_parra.vistas


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import com.example.listas_jorge_carlos_parra.Destinations
import com.example.listas_jorge_carlos_parra.Vista1
import com.example.listas_jorge_carlos_parra.Vista2

//funcion que se encarga de gestionar la navegacion entre pantallas
@ExperimentalFoundationApi
@Composable
fun NavigationHost() {
    val navController = androidx.navigation.compose.rememberNavController()

    NavHost(navController = navController, startDestination = Destinations.Vista1.route) {
        //objeto que se encarga de coger la ruta y usarla con el navController
        composable(Destinations.Vista1.route) {
            Vista1(navController = navController)
        }

        composable(
            Destinations.Vista2.route,
            //creamos una array con los argumentos que le vamos a pasar
            arguments = listOf(navArgument("img"){
                type = NavType.StringType
            }, navArgument("title"){
                    type = NavType.StringType },
            navArgument("info"){
                type = NavType.StringType
            }   )
        ) { navBackStackEntry ->
            Vista2(img = navBackStackEntry.arguments?.getString("img")!!,
                title = navBackStackEntry . arguments ?. getString ("title")!!,
                info = navBackStackEntry . arguments ?. getString ("info")!!)
        }
    }
}


