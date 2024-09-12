package com.example.components

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.components.ui.theme.ComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComponentsTheme {
                /* var myText by rememberSaveable { mutableStateOf("") }
                 MyOutlinedTextFieldHoisted(myText) { myText = it.uppercase() }

                 */
                MyImage()
            }
        }
    }
}

@Preview
@Composable
fun MyProgressBar3() {
    var progreso by rememberSaveable { mutableStateOf(0.5f) }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(color = Color.Red, progress = { progreso })
        Row(Modifier.fillMaxWidth()) {
            Button(onClick = { progreso += 0.1f}) {
                Text(text = "Más")
            }

            Button(onClick = { progreso -= 0.1f }) {
                Text(text = "Menos")
            }
        }

    }
}

@Composable
fun MyProgressBar2() {
    var showLoading by rememberSaveable { mutableStateOf(false) }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(color = Color.Red, strokeWidth = 10.dp)
            LinearProgressIndicator(modifier = Modifier.padding(top = 32.dp), color = Color.Blue)
        }
        Button(onClick = { showLoading = !showLoading }) {
            Text(text = "Hola")
        }

    }
}

@Composable
fun MyProgressBar() {

    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(color = Color.Red, strokeWidth = 10.dp)
        LinearProgressIndicator(modifier = Modifier.padding(top = 32.dp), color = Color.Blue)
    }
}

@Composable
fun MyIcon() {

    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        //https://fonts.google.com/icons
        Icon(imageVector = Icons.Rounded.Edit, contentDescription = "desc", tint = Color.Blue)
    }
}
@Preview
@Composable
fun MyImage() {

    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "descripcion",
            alpha = 0.5f
        )

        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "descripcion",
            modifier = Modifier.clip(RoundedCornerShape(25f))
        )

        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "descripcion",
            modifier = Modifier
                .clip(CircleShape)
                .border(5.dp, Color.Red, CircleShape)
        )
        //necesita libreria coil
        //no funciona
        AsyncImage(
            model = "https://coil-kt.github.io/coil/logo.svg",
            contentDescription = "Imagen desde URL",
            modifier = Modifier.size(200.dp)
        )

    }
}

@Composable
fun MyButton2() {
    var enabled by rememberSaveable { mutableStateOf(true) }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = { enabled = false },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.Red
            ),
            border = BorderStroke(5.dp, Color.Red)
        ) { Text(text = "boton") }
    }
}

@Composable
fun MyButton() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = { Log.i("Etiqueta", "texto de prueba") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.Red
            ),
            border = BorderStroke(5.dp, Color.Red)
        ) { Text(text = "boton") }
    }
}

@Composable
fun MyTextField2() {
    var myText by rememberSaveable { mutableStateOf("") }
    Column(Modifier.fillMaxSize()) {
        TextField(
            value = myText,
            onValueChange = { myText = it.uppercase() },
            label = { Text(text = "Introduce tu nombre") })
    }
}

@Composable
fun MyTextField3() {
    var myText by rememberSaveable { mutableStateOf("") }
    Column(Modifier.fillMaxSize()) {
        TextField(value = myText,
            onValueChange = {
                myText =
                    if (it.contains("a")) {
                        it.replace("a", "")
                    } else {
                        it
                    }
            },
            label = { Text(text = "Introduce tu nombre") })
    }
}

@Composable
fun MyOutlinedTextField() {
    var myText by rememberSaveable { mutableStateOf("") }
    Column(Modifier.fillMaxSize()) {
        OutlinedTextField(
            value = myText,
            onValueChange = {
                myText = it
            },
            label = { Text(text = "Introduce tu nombre") },
            modifier = Modifier.padding(24.dp)
        )
    }
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyOutlinedTextFieldHoisted(text: String, onValueChanged: (String) -> Unit) {
    Column(Modifier.fillMaxSize()) {
        OutlinedTextField(
            value = text,
            onValueChange = { onValueChanged(it) }
        )
    }
}

@Composable
fun MyTextField() {
    var myText by rememberSaveable { mutableStateOf("Texto ") }

    Column(Modifier.fillMaxSize()) {
        TextField(value = myText, onValueChange = { myText = it })
    }
}

@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Esto es un texto")
        Text(text = "Esto es un texto", color = Color.Blue)
        Text(text = "Esto es un texto", fontWeight = FontWeight.Bold)
        Text(text = "Esto es un texto", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(
            text = "Esto es un texto",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
        Text(
            text = "Esto es un texto",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        Text(
            text = "Esto es un texto",
            style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(
                        TextDecoration.Underline,
                        TextDecoration.LineThrough
                    )
                )
            )
        )
        Text(text = "Esto es un texto", fontSize = 30.sp)

    }

}