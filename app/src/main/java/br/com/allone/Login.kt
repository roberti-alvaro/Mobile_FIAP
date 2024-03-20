package br.com.allone

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import br.com.allone.ui.theme.AllOneTheme
import kotlinx.coroutines.launch

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

fun navigateToHomeScreen(context: Context) {
    val intent = Intent(context, MainActivity::class.java)
    context.startActivity(intent)
}

@Composable
fun LoginScreen() {
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column {
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") }
        )

        Button(onClick = {
            // Handle login here
            // For example, you can call FirebaseService.signInWithEmail(email, password)

            coroutineScope.launch {
                val result = FirebaseService.signInWithEmail(context, email, password)

                if (result.isSuccess) {
                    navigateToHomeScreen(context)
                } else {
                    result.exceptionOrNull()?.let { exception ->
                        Toast.makeText(context, exception.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }) {
            Text("Login")
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