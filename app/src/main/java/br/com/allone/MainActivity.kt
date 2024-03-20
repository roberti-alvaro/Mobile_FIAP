package br.com.allone

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.allone.ui.theme.AllOneTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContent {
                AllOneTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                        GreetingPreview()
                    }
                }
            }
    }
}

object FirebaseService {

    suspend fun getFirestoreFields(context: Context): Result<Map<String, Any>?> = withContext(Dispatchers.IO) {

        val sharedPref = context.getSharedPreferences("personalData", Context.MODE_PRIVATE)
        val userId = sharedPref.getString("uid", null)

        val document = userId?.let { Firebase.firestore.collection("fields").document(it).get().await() }
        return@withContext if (document!!.exists()) {
            Result.success(document.data)
        } else {
            Result.failure(Exception("No such document"))
        }
    }

    suspend fun signInWithEmail(context: Context, email: String, password: String): Result<String> = withContext(Dispatchers.IO) {
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

fun copyToClipboard(context: Context, text: String) {
    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText("Copied Text", text)
    clipboard.setPrimaryClip(clip)

    Toast.makeText(context, "Copied to clipboard", Toast.LENGTH_SHORT).show()
}

@Composable
fun GenericFields(data: Map<String, Any>) {

    Column {
        data.forEach { (key, value) ->
            val fieldValue = remember { mutableStateOf(value.toString()) }
            GenericField(fieldValue, key)
        }
    }
}

@Composable
fun GenericField(fieldValue: MutableState<String>, fieldName: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = modifier
            .clickable(interactionSource = interactionSource, indication = rememberRipple()) {
                copyToClipboard(context, fieldValue.value)
            }
            .shadow(4.dp, shape = MaterialTheme.shapes.medium),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "$fieldName: ${fieldValue.value}",
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val context = LocalContext.current
    val remoteFieldsResult = remember { mutableStateOf<Result<Map<String, Any>?>>(Result.success(null)) }

    LaunchedEffect(key1 = Unit) {
        remoteFieldsResult.value = FirebaseService.getFirestoreFields(context)
    }

    AllOneTheme {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column {
                when {
                    remoteFieldsResult.value.isSuccess -> {
                        remoteFieldsResult.value.getOrNull()?.let {
                            GenericFields(it)
                        }
                    }

                    remoteFieldsResult.value.isFailure -> {
                        Toast.makeText(context, "No data for this User!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}