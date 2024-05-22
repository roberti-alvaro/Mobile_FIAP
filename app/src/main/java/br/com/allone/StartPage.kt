package br.com.allone

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.allone.ui.theme.AllOneTheme
import br.com.allone.ui.theme.Righteous
import br.com.allone.ui.theme.Roboto

class StartPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AllOneTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Page()
                }
            }
        }
    }
}
fun navigateLogin(context: Context) {
    val intent = Intent(context, Login::class.java)
    context.startActivity(intent)
}

fun navigateProfile(context: Context) {
    val intent = Intent(context, Profile::class.java)
    context.startActivity(intent)
}

fun navigateStartPage(context: Context) {
    val intent = Intent(context, StartPage::class.java)
    context.startActivity(intent)
}

@Composable
fun Page() {
    val context = LocalContext.current
    Box(
        modifier = with (Modifier){
            fillMaxSize()
                .paint(
                    painterResource(id = R.drawable.online_class__1_),
                    contentScale = ContentScale.FillHeight)
        })

    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(200.dp))
                .fillMaxWidth()
        ) {
            Text(
                text = "E-SCHOLA",
                color = Color(0xFF282D7F),
                fontFamily = Righteous,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .background(Color(0xFFEAE7E4))
                    .padding(horizontal = 40.dp, vertical = 15.dp)
                    .fillMaxWidth(),
                fontSize = 70.sp

            )
        }
    }
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Absolute.SpaceEvenly
    ) {
        OutlinedButton(
            onClick = { navigateLogin(context) },
            shape = RectangleShape,
            colors = ButtonDefaults.outlinedButtonColors(Color(0xFF282D7F)),
            modifier = Modifier
                .offset(y = -20.dp)
                .width(150.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(7.dp))
        ) {
            Text(
                text = "LOGIN",
                color = Color(0xFFFDFDFD),
                fontSize = 16.sp,
                fontFamily = Roboto
            )
        }
        ElevatedButton(
            onClick = { navigateProfile(context) },
            shape = RectangleShape,
            colors = ButtonDefaults.elevatedButtonColors(Color(0xFF282D7F)),
            modifier = Modifier
                .offset(y = -20.dp)
                .width(150.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(7.dp))
        ) {
            Text(
                text = "CADASTRO",
                color = Color(0xFFFDFDFD),
                fontSize = 16.sp,
                fontFamily = Roboto
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PagePreview() {
    Page()
}