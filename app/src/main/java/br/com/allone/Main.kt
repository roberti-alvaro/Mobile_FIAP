package br.com.allone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.allone.ui.theme.AllOneTheme
import br.com.allone.ui.theme.Poppins
import br.com.allone.ui.theme.PoppinsBold
import br.com.allone.ui.theme.Roboto


class Main : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AllOneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

//fun navigateToMainPage(context: Context) {
//    val intent = Intent(context, MainActivity::class.java)
//    context.startActivity(intent)
//}

@Composable
fun MainScreen() {
    var data by remember { mutableStateOf("") }
    var area by remember { mutableStateOf("") }
    var habilidade by remember { mutableStateOf("") }
    var manha by remember { mutableStateOf(false) }
    var tarde by remember { mutableStateOf(false) }
    var noite by remember { mutableStateOf(false) }
    var basico by remember { mutableStateOf(false) }
    var medio by remember { mutableStateOf(false) }
    var avancado by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFF1D2156)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color(0xFF1D2156)),
                verticalArrangement = Arrangement.Top,

                ) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.padding(start = 15.dp, end = 25.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Volta",
                            modifier = Modifier.size(35.dp),
                            tint = Color(0xFFFFFFFF)
                        )
                    }
                    Text(
                        text = "Descobrir",
                        color = Color(0xFFFFFFFF),
                        fontSize = 20.sp
                    )
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.padding(start = 15.dp, end = 20.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Notifications,
                            contentDescription = "Volta",
                            modifier = Modifier.size(25.dp),
                            tint = Color(0xFFFFFFFF)
                        )
                    }


                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                )
            }
            Card(
                modifier = Modifier
                    .fillMaxHeight(0.9f)
                    .fillMaxWidth(0.95f)
                    .background(color = Color(0xFF1D2156))
                    .offset(y = -10.dp),
                shape = RoundedCornerShape(25.dp),
                elevation = CardDefaults.cardElevation(10.dp)

            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Image(
                        painter = painterResource(id = R.drawable.garoto_tocando_guitarra),
                        contentDescription = "mulher",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.matchParentSize()
                    )
                    Column(
                        verticalArrangement = Arrangement.Bottom,
                        modifier = Modifier.fillMaxWidth().fillMaxHeight(0.95f)
                    ) {
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp),
                            horizontalArrangement = Arrangement.Start) {
                            Column(verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = "John Doe",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 28.sp,
                                    fontFamily = Poppins
                                )
                                Text(
                                    text = "Professor de Música",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp,
                                    fontFamily = PoppinsBold
                                )
                                Text(
                                    text = "Violão básico, médio, avançado",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    fontFamily = Poppins
                                )
                                Text(
                                    text = "Disponível seg à sexta",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    fontFamily = Poppins
                                )

                             }
                            Column(verticalArrangement = Arrangement.Top,
                                horizontalAlignment = Alignment.Start,
                                modifier = Modifier.fillMaxWidth(0.8f)) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = Icons.Rounded.Star,
                                        contentDescription = "star",
                                        tint = Color(0xFFF8A625),
                                        modifier = Modifier
                                            .size(25.dp)
                                            .fillMaxHeight()
                                    )
                                    Spacer(modifier = Modifier.width(5.dp))
                                    Text(text = "4.6",
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 25.sp,
                                        fontFamily = Roboto,
                                        modifier = Modifier.padding(start = 7.dp))
                                }

                            }
                        }

                    }
                }

            }
            BottomAppBarExample()
        }

    }
}

@Composable
fun BottomAppBarExample() {
    Row(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        IconButton(onClick = { /* do something */ }) {
            Icon(
                Icons.Filled.AccountCircle, contentDescription = "Localized description",
                tint = Color(0xFFFFFFFF),
                modifier = Modifier.size(35.dp)
            )

        }
        IconButton(onClick = { /* do something */ }) {
            Icon(
                Icons.Filled.Search,
                contentDescription = "Localized description",
                tint = Color(0xFFFFFFFF),
                modifier = Modifier.size(35.dp)
            )
        }
        IconButton(onClick = { /* do something */ }) {
            Icon(
                Icons.Filled.MailOutline,
                contentDescription = "Localized description",
                tint = Color(0xFFFFFFFF),
                modifier = Modifier.size(35.dp)
            )
        }
        IconButton(onClick = { /* do something */ }) {
            Icon(
                Icons.Filled.DateRange,
                contentDescription = "Localized description",
                tint = Color(0xFFFFFFFF),
                modifier = Modifier.size(35.dp)
            )
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}