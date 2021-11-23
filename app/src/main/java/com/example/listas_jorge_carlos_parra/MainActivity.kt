package com.example.listas_jorge_carlos_parra

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.listas_jorge_carlos_parra.ui.theme.Listas_Jorge_Carlos_ParraTheme
import com.example.listas_jorge_carlos_parra.vistas.NavigationHost

class MainActivity : ComponentActivity() {
    lateinit var navControler: NavHostController

    //aqui simplemente tenemos el navController que pone la vista1 en pantalla
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Listas_Jorge_Carlos_ParraTheme {
                navControler = rememberNavController()
                NavigationHost()
            }
        }
    }

}

