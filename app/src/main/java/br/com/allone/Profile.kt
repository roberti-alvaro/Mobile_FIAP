package br.com.allone

import android.content.Context
import android.content.Intent
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.allone.ui.theme.AllOneTheme

class Profile : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AllOneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProfileScreen()
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
fun ProfileScreen() {
    var nome by remember { mutableStateOf("") }
    var sobre by remember { mutableStateOf("") }
    var area by remember { mutableStateOf("") }
    var formacao by remember { mutableStateOf("") }
    var experiencia by remember { mutableStateOf("") }
    var habilidade by remember { mutableStateOf("") }
    var contato by remember { mutableStateOf("") }

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
                    .height(220.dp)
                    .background(Color(0xFF1D2156)),
                verticalArrangement = Arrangement.Bottom,

                ) {
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
                            imageVector = Icons.Filled.KeyboardArrowLeft,
                            contentDescription = "Volta",
                            modifier = Modifier.size(50.dp),
                            tint = Color(0xFFFFFFFF)
                        )
                    }
                    Text(
                        text = "Editar Perfil",
                        color = Color(0xFFFFFFFF),
                        fontSize = 17.sp
                    )
                    TextButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.padding(end = 15.dp)
                    ) {
                        Text(
                            text = "SALVAR",
                            color = Color(0xFFFFFFFF)
                        )
                    }
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.mulher),
                    contentDescription = "foto",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFFFFFFF))
                )
                Column(
                    modifier = Modifier
                        .offset(x = 25.dp, y = -27.dp)
                        .clip(CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.Filled.AddCircle,
                        contentDescription = "Editar",
                        tint = Color(0xFF282D7F),
                        modifier = Modifier
                            .size(35.dp)
                            .background(color = Color(0xFFFFFFFF))
                    )
                }

            }
            Card(
                modifier = Modifier
                    .fillMaxHeight(1f)
                    .fillMaxWidth(0.95f)
                    .background(color = Color(0xFF1D2156))
                    .offset(y = -10.dp),
                shape = RoundedCornerShape(25.dp),
                elevation = CardDefaults.cardElevation(10.dp)

            ) {
                Column(
                    modifier = Modifier.fillMaxSize().padding(vertical = 20.dp, horizontal = 30.dp)
                ) {
                    Text("Nome",
                        fontWeight = FontWeight.Bold)
                    TextField(value = nome, onValueChange = { nome = it },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text("Sobre Mim",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 13.dp))
                    TextField(value = sobre, onValueChange = { sobre = it },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text("Área de Interesse",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 13.dp))
                    TextField(value = area, onValueChange = { area = it },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text("Formação Acadêmica",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 13.dp))
                    TextField(value = formacao, onValueChange = { formacao = it },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text("Experiência",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 13.dp))
                    TextField(value = experiencia, onValueChange = { experiencia = it },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text("Habilidades",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 13.dp))
                    TextField(value = habilidade, onValueChange = { habilidade = it },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text("Contato",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 13.dp))
                    TextField(value = contato, onValueChange = { contato = it },
                        modifier = Modifier.fillMaxWidth()
                    )
                }

            }
        }

    }

}
//    var idade: MutableState<Int> = remember {
//        mutableIntStateOf(0)
//    }
//    var input by remember {
//        mutableStateOf("")
//    }
//
//
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Text(
//            text = "Qual sua idade?",
//            fontSize = 24.sp,
//            color = Color(0xFFAD1F4E),
//            fontWeight = FontWeight.Bold
//        )
//        Text(text = "Aperte os botões para informar a sua idade.")
//        Text(
//            text = "${idade.value}",
//            fontSize = 48.sp,
//            modifier = Modifier.padding(50.dp)
//        )
//        OutlinedTextField(
//            value = input,
//            onValueChange = { input = it },
//            label = { Text("Escreva sua idade:") })
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.Start,
//            modifier = Modifier.padding(15.dp)
//        ) {
//            Button(
//                onClick = { idade.value-- },
//                modifier = Modifier.size(80.dp, 50.dp),
//                shape = RoundedCornerShape(8.dp),
//                colors = ButtonDefaults.buttonColors(Color(0xFFAD1F4E))
//            ) {
//                Text(
//                    text = " - ",
//                    fontSize = 20.sp
//                )
//            }
//            Spacer(modifier = Modifier.width(30.dp))
//            Button(
//                onClick = { idade.value++ },
//                modifier = Modifier.size(80.dp, 50.dp),
//                shape = RoundedCornerShape(8.dp),
//                colors = ButtonDefaults.buttonColors(Color(0xFFAD1F4E))
//            ) {
//                Text(
//                    text = " + ",
//                    fontSize = 20.sp
//                )
//            }
//        }
//    }
//}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}


//
//fun navigateToMainActivity(context: Context) {
//    val intent = Intent(context, MainActivity::class.java)
//    context.startActivity(intent)
//}

//@Composable
//fun ProfileScreen() {
//    val coroutineScope = rememberCoroutineScope()
//    val context = LocalContext.current
//
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//
//    Column(horizontalAlignment = Alignment.CenterHorizontally) {
//
//            IconButton(
//                onClick = { navigateToMainActivity(context) },
//                modifier = Modifier.align(Alignment.Start)
//            ) {
//                Icon(
//                    imageVector = Icons.Filled.KeyboardArrowLeft,
//                    contentDescription = "Back",
//                    tint = Color(0xFF282D7F),
//                    modifier = Modifier.size(50.dp)
//
//                )
//            }
//
//        Row {
//            Surface(shape = MaterialTheme.shapes.large, shadowElevation = 3.dp) {
//                Text(
//                    text = "Profile",
//                    fontSize = 70.sp,
//                    fontFamily = Coda,
//                    fontWeight = FontWeight.Bold,
//                    color = Color(0xFF282D7F),
//                    modifier = Modifier.padding(horizontal = 50.dp)
//                    )
//            }
//        }
//        OutlinedTextField(
//            value = email,
//            onValueChange = { email = it },
//            label = { Text("Email") },
//            modifier = Modifier
//                .fillMaxWidth(0.90f)
//
//        )
//
//        OutlinedTextField (
//            value = password,
//            onValueChange = { password = it },
//            label = { Text("Password") },
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
//            modifier = Modifier
//                .fillMaxWidth(0.90f)
//        )
//        Spacer(modifier = Modifier.height(9.dp))
//        Button(
//            onClick = {
//                // Handle login here
//                // For example, you can call FirebaseService.signInWithEmail(email, password)
//
//                coroutineScope.launch {
//                    val result = FirebaseService.signInWithEmail(context, email, password)
//
//                    if (result.isSuccess) {
//                        navigateToMainActivity(context)
//                    } else {
//                        result.exceptionOrNull()?.let { exception ->
//                            Toast.makeText(context, exception.message, Toast.LENGTH_SHORT).show()
//                        }
//                    }
//                }
//            },
//            shape = RectangleShape,
//            elevation = ButtonDefaults.buttonElevation(
//                defaultElevation = 100.dp
//            ),
//            colors = ButtonDefaults.outlinedButtonColors(Color(0xFF282D7F)),
//            modifier = Modifier
//                .fillMaxWidth(0.90f)
//                .height(50.dp)
//                .clip(RoundedCornerShape(7.dp))
//        ) {
//            Text(
//                "LOGIN",
//                color = Color(0xFFFDFDFD),
//                fontSize = 20.sp,
//                fontFamily = Roboto
//            )
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun ProfileScreenPreview() {
//    AllOneTheme {
//        ProfileScreen()
//    }
//}
