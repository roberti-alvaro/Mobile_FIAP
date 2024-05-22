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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.allone.ui.theme.AllOneTheme
import br.com.allone.ui.theme.Roboto

class Search : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AllOneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SearchScreen()
                }
            }
        }
    }
}

fun navigateToMainPage(context: Context) {
    val intent = Intent(context, Main::class.java)
    context.startActivity(intent)
}

@Composable
fun SearchScreen() {
    val context = LocalContext.current

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
                        onClick = { navigateToMainPage(context) },
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
                        text = "Pesquisa Avançada",
                        color = Color(0xFFFFFFFF),
                        fontSize = 17.sp
                    )
                    TextButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.padding(end = 15.dp)
                    ) {
                        Text(
                            text = " LIMPAR\nSELEÇÃO",

                            color = Color(0xFFFFFFFF)
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
                    .fillMaxHeight(1f)
                    .fillMaxWidth(0.95f)
                    .background(color = Color(0xFF1D2156))
                    .offset(y = -10.dp),
                shape = RoundedCornerShape(25.dp),
                elevation = CardDefaults.cardElevation(10.dp)

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 20.dp, horizontal = 30.dp)
                ) {
                    Text(
                        "Data",
                        fontWeight = FontWeight.Bold
                    )
                    TextField(value = data, onValueChange = { data = it },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(20.dp),
                        placeholder = {
                            Text(
                                text = "DD / MM / AA"
                            )
                        },
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Filled.DateRange,
                                contentDescription = "Date Icon",
                                modifier = Modifier.padding(end = 25.dp)
                            )
                        }
                    )
                    Text(
                        "Disponibilidade de Horário",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 25.dp)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Checkbox(
                                checked = manha,
                                onCheckedChange = { manha = it},
                                colors = CheckboxDefaults.colors(
                                    checkedColor = Color(0xFF1D2156),
                                    uncheckedColor = Color(0xFF1D2156)
                                )
                            )
                            Text(
                                text = "Manhã",
                                color = Color.Black
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Checkbox(
                                checked = tarde,
                                onCheckedChange = { tarde = it},
                                colors = CheckboxDefaults.colors(
                                    checkedColor = Color(0xFF1D2156),
                                    uncheckedColor = Color(0xFF1D2156)
                                )
                            )
                            Text(
                                text = "Tarde",
                                color = Color.Black
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Checkbox(
                                checked = noite,
                                onCheckedChange = { noite = it},
                                colors = CheckboxDefaults.colors(
                                    checkedColor = Color(0xFF1D2156),
                                    uncheckedColor = Color(0xFF1D2156)
                                )
                            )
                            Text(
                                text = "Noite",
                                color = Color.Black
                            )
                        }
                    }

                    Text(
                        "Área de Interesse",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 25.dp)
                    )
                    TextField(
                        value = area, onValueChange = { area = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = {
                            Text(
                                text = "ex: Matemática"
                            )
                        }
                    )
                    Text(
                        "Nível de Proficiência",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 25.dp)
                    )
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Checkbox(
                                checked = basico,
                                onCheckedChange = { basico = it},
                                colors = CheckboxDefaults.colors(
                                    checkedColor = Color(0xFF1D2156),
                                    uncheckedColor = Color(0xFF1D2156)
                                )
                            )
                            Text(
                                text = "Básico",
                                color = Color.Black
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Checkbox(
                                checked = medio,
                                onCheckedChange = { medio = it},
                                colors = CheckboxDefaults.colors(
                                    checkedColor = Color(0xFF1D2156),
                                    uncheckedColor = Color(0xFF1D2156)
                                )
                            )
                            Text(
                                text = "Médio",
                                color = Color.Black
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Checkbox(
                                checked = avancado,
                                onCheckedChange = { avancado = it},
                                colors = CheckboxDefaults.colors(
                                    checkedColor = Color(0xFF1D2156),
                                    uncheckedColor = Color(0xFF1D2156)
                                )
                            )
                            Text(
                                text = "Avançado",
                                color = Color.Black
                            )
                        }
                    }
                    Text(
                        "Faixa de Preço",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 25.dp)
                    )
                    RangeSliderExample()
                    Text(
                        "Localização",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 25.dp)
                    )
                    TextField(
                        value = habilidade, onValueChange = { habilidade = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = {
                            Text(
                                text = "ex: Florianópolis"
                            )
                        },

                    )
                    Spacer(modifier = Modifier.height(50.dp))
                    Button(
                        onClick = {

                        },
                        shape = RectangleShape,
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 100.dp
                        ),
                        colors = ButtonDefaults.outlinedButtonColors(Color(0xFF282D7F)),
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .height(50.dp)
                            .clip(RoundedCornerShape(7.dp))
                    ) {
                        Text(
                            "PESQUISAR",
                            color = Color(0xFFFDFDFD),
                            fontSize = 20.sp,
                            fontFamily = Roboto
                        )
                    }

                }

            }
        }

    }

}
@Composable
fun RangeSliderExample() {
    var sliderPosition by remember { mutableStateOf(0f..100f) }
    Column {
        RangeSlider(
            value = sliderPosition,
            onValueChange = { range -> sliderPosition = range },
            valueRange = 0f..100f,
            onValueChangeFinished = {

            },
        )
        Text(text = "R$ ${sliderPosition.start.toInt()}/h - R$ ${sliderPosition.endInclusive.toInt()}/h")
    }
}
@Preview
@Composable
fun SearchScreenPreview() {
    SearchScreen()
}