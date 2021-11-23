package com.example.listas_jorge_carlos_parra

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.listas_jorge_carlos_parra.Modelos.Anime

@ExperimentalFoundationApi
@SuppressLint("UnrememberedMutableState")
@Composable
fun Vista1 (navController: NavController){
    //creamos aqui nuestros objetos con todos sus datos, en la url hay que reemplazar las barras
    val l1 = Anime(
        "https://www.okuroku.com/wp-content/uploads/2020/06/Nota-Mushoku-Tensei-cast-y-retraso-2021-edit.jpg".replace('/','\\'),
        "Mushoku Tensei",
        "Sigue de cerca como Rudeus se adapta a un nuevo mundo y crece en él despues de reencarnarse"
    )
    val l2 = Anime(
        "https://cdn02.nintendo-europe.com/media/images/10_share_images/games_15/nintendo_switch_4/H2x1_NSwitch_SteinsGateElite_image1600w.jpg".replace('/','\\'),
        "Steins;Gate",
        "Un cientifico loco averigua como viajar en el tiempo y sufre (depresión) las consecuencias por ello"
    )
    val l3 = Anime(
        "https://as.com/meristation/imagenes/2021/07/13/videos/1626146939_521562_1626147037_noticia_normal_recorte1.jpg".replace('/','\\'),
        "Full Metal Alchemist: Brotherhood",
        "Dos hermanos rompe el tabu más importante de la alquimia y pierden partes de sus cuerpos por ello. Ahora buscan la manera de recuperar lo que es suyo"
    )
    val l4 = Anime(
        "https://areajugones.sport.es/wp-content/uploads/2020/03/kaguya-sama-s2-min.jpg".replace('/','\\'),
        "Kaguya-Sama: Love is War",
        "Dos genios muy orgullosos estan enamorados el uno del otro pero se niegan a confesar por miedo a perder su orgullo, así que intentaran por todos los medios que el otro se confiese"
    )
    val l5 = Anime(
        "https://vod.roams.es/core/images/post/es_ES_vod/grand-blue.jpg".replace('/','\\'),
        "Grand Blue",
        "Iori se apunta a un club de buceo cuando empieza su epoca universitaria, pero hacen de todo menos bucear"
    )

    //ya que cada vez que entramos en la Vista1 se carga esta variable, al borrar un objeto
    // y cambiar de vista se restablece
    var lista : MutableList<Anime> = remember {
        mutableStateListOf(
            l1,
            l2,
            l3,
            l4,
            l5)
    }

    @Composable
    fun CargarImagen(url: String) {
        Image(
            painter = rememberImagePainter(url),
            contentDescription = "Imagen",
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .height(150.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.FillWidth
        )
    }

    fun Borrar(anime : Anime){
        lista.remove(anime)
    }

    //al ser Vista1 una funcion ponemos su layout suelto para que lo carge al principio
    LazyColumn(
        modifier = Modifier.background(Color.White)
    ) {
        items(lista) { anime ->
            Surface(shape = RoundedCornerShape(8.dp), elevation = 8.dp, modifier =
            Modifier
                .padding(8.dp)
                .combinedClickable(
                    onClick = {
                        //al darle click abrira la nueva pantalla que muestra los datos completos del objeto
                        navController.navigate(
                            Destinations.Vista2.PassAnime(
                                anime.Imagen,
                                anime.Title,
                                anime.Info
                            )
                        )
                    },
                    //si lo mantienes pulsado se borra el objeto
                    onLongClick = { Borrar(anime) }
                )
            ) {
                CargarImagen(url = anime.Imagen)
            }
        }
    }



    @Preview(showBackground = true)
    @Composable
    fun PreviewGreeting(){
        Vista1(
            navController = rememberNavController()
        )
    }

}