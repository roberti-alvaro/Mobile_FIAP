package br.com.allone

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
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
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.allone.ui.theme.AllOneTheme
import br.com.allone.ui.theme.Poppins
import br.com.allone.ui.theme.PoppinsBold
import br.com.allone.ui.theme.Roboto
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging

class Main : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AllOneTheme {
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

fun navigateToSearch(context: Context) {
    val intent = Intent(context, Search::class.java)
    context.startActivity(intent)
}

@kotlinx.parcelize.Parcelize
data class Professor(
    var nome: String,
    var sobre: String,
    var area: String,
    var formacao: String,
    var experiencia: String,
    var habilidade: String,
    var contato: String
) : Parcelable

object ProfessorData {
    var professors: MutableState<MutableList<Professor>> = mutableStateOf(mutableListOf(
        Professor(
            nome = "John Doe",
            sobre = "Professor de Música",
            area = "",
            formacao = "",
            experiencia = "",
            habilidade = "Violão básico, médio, avançado",
            contato = "Disponível seg à sexta"
        )
    ))
}
@Composable
fun MainScreen() {
    val professors = rememberSaveable { ProfessorData.professors }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFF1D2156)),
            verticalArrangement = Arrangement.SpaceBetween, // This will push the BottomAppBarExample to the bottom
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
                Space()
                ShowToolbar()
            }

            if (professors.value.isNotEmpty()) {
                Card(
                    modifier = Modifier
                        .fillMaxHeight(0.9f)
                        .fillMaxWidth(0.95f)
                        .background(color = Color(0xFF1D2156))
                        .offset(y = -10.dp),
                    shape = RoundedCornerShape(25.dp),
                    elevation = CardDefaults.cardElevation(10.dp)

                ) {
                    ShowProfessorCard(professors.value[0], professors.value, Modifier.height(680.dp))
                }
            } else {
                ShowEmptyScreen()
            }
            BottomAppBarExample() // This will always be at the bottom
        }
    }
}

@Composable
fun Space() {
    Spacer(modifier = Modifier.height(20.dp))
}
@Composable
fun ShowToolbar() {
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
}
@Composable
fun ShowEmptyScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Não temos mais professores disponíveis",
            color = Color.White,
            fontSize = 20.sp
        )
    }
}

@Composable
fun ShowProfessorCard(professor: Professor, professors: MutableList<Professor>, modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.garoto_tocando_guitarra),
            contentDescription = "musico",
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = professor.nome,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 28.sp,
                        fontFamily = Poppins
                    )
                    Text(
                        text = professor.sobre,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        fontFamily = PoppinsBold
                    )
                    Text(
                        text = professor.habilidade,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        fontFamily = Poppins
                    )
                    Text(
                        text = professor.contato,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        fontFamily = Poppins
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.fillMaxWidth(0.8f)
                ) {
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
                        Text(
                            text = "4.6",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp,
                            fontFamily = Roboto,
                            modifier = Modifier.padding(start = 7.dp)
                        )
                    }
                }
            }
            Space()
            ProfessorActions()
        }
    }
}

@Composable
fun ProfessorActions() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = {
            if (ProfessorData.professors.value.isNotEmpty()) {
                val updatedProfessors = ProfessorData.professors.value.toMutableList()
                updatedProfessors.removeAt(0)
                ProfessorData.professors.value = updatedProfessors
            }
        }, colors = ButtonDefaults.outlinedButtonColors(Color(0xFFB81C1C))) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "Close",
                tint = Color.White
            )
        }
        Button(onClick = {
            if (ProfessorData.professors.value.isNotEmpty()) {
                val updatedProfessors = ProfessorData.professors.value.toMutableList()
                updatedProfessors.removeAt(0)
                ProfessorData.professors.value = updatedProfessors
            }
            getFirebaseToken()
        }, colors = ButtonDefaults.outlinedButtonColors(Color(0xFF3FB308))) {
            Icon(
                imageVector = Icons.Filled.Check,
                contentDescription = "Check",
                tint = Color.White
            )
        }
    }
}
@Composable
fun BottomAppBarExample() {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
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
        IconButton(onClick = { navigateToSearch(context = context) }) {
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
private fun getFirebaseToken() {
    FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
        if (!task.isSuccessful) {
            Log.w("FCM", "Fetching FCM registration token failed", task.exception)
            return@OnCompleteListener
        }

        val token = task.result
        val msg = "FCM Token: $token"
        Log.d("FCM", msg)
    })
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}