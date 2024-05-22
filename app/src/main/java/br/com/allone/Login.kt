package br.com.allone

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.allone.ui.theme.AllOneTheme
import br.com.allone.ui.theme.Coda
import br.com.allone.ui.theme.Roboto
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AllOneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

fun navigateToStartPage(context: Context) {
    val intent = Intent(context, StartPage::class.java)
    context.startActivity(intent)
}
fun navigateToMain(context: Context) {
    val intent = Intent(context, Main::class.java)
    context.startActivity(intent)
}

object FirebaseService {

    suspend fun signInWithEmail(context: Context, email: String, password: String): Result<String> = withContext(
        Dispatchers.IO) {
        val auth = FirebaseAuth.getInstance()
        return@withContext try {

            val sharedPref = context.getSharedPreferences("personalData", Context.MODE_PRIVATE)
            val result = auth.signInWithEmailAndPassword(email, password).await()
            val user = result.user

            with(sharedPref.edit()) {
                putString("uid", user?.uid!!)
                apply()
            }

            Result.success(user?.uid!!)

        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

@Composable
fun LoginScreen() {
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        IconButton(
            onClick = { navigateToStartPage(context) },
            modifier = Modifier.align(Alignment.Start)
        ) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowLeft,
                contentDescription = "Back",
                tint = Color(0xFF282D7F),
                modifier = Modifier.size(50.dp)

            )
        }
        Row {
            Text(
                text = "Login",
                fontSize = 70.sp,
                fontFamily = Coda,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF282D7F)
            )
        }
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth(0.90f)

        )

        OutlinedTextField (
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .fillMaxWidth(0.90f)
        )
        Spacer(modifier = Modifier.height(9.dp))
        Button(
            onClick = {
                // Handle login here
                // For example, you can call FirebaseService.signInWithEmail(email, password)

                coroutineScope.launch {
                    val result = FirebaseService.signInWithEmail(context, email, password)

                    if (result.isSuccess) {
                        navigateToMain(context)
                    } else {
                        result.exceptionOrNull()?.let { exception ->
                            Toast.makeText(context, exception.message, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            },
            shape = RectangleShape,
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 100.dp
            ),
            colors = ButtonDefaults.outlinedButtonColors(Color(0xFF282D7F)),
            modifier = Modifier
                .fillMaxWidth(0.90f)
                .height(50.dp)
                .clip(RoundedCornerShape(7.dp))
        ) {
            Text(
                "LOGIN",
                color = Color(0xFFFDFDFD),
                fontSize = 20.sp,
                fontFamily = Roboto
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    AllOneTheme {
        LoginScreen()
    }
}
