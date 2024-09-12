package com.example.hw2g_2


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hw2g_2.ui.theme.Hw2g2Theme
import androidx.compose.foundation.background
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import kotlin.math.max


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Hw2g2Theme {
               MainScreen()
                }
            }
        }
    }

@Composable
fun MainScreen() {
    var boxVisible by remember {
        mutableStateOf(true)
    }

    val onClick = { newState: Boolean ->
        boxVisible = newState
    }

    var celcius by remember { mutableStateOf(0f) }
    var fahrenheit by remember { mutableStateOf(32f) }
    var message by remember { mutableStateOf("I wish it was warmer.") }

    fun messageUpdate(celciusVal: Float) {
        message = if (celciusVal <= 20) {
            "I wish it was warmer"
        } else {
            "I wish it was colder"
        }
    }

    fun fahrenheitUpdate(celciusVal: Float) {
        celcius = celciusVal
        fahrenheit = celciusVal * 9 / 5 + 32
        messageUpdate(celciusVal)
    }

    fun celciusUpdate(fahrenheitVal: Float) {
        fahrenheit = max(fahrenheitVal, 32f)
        celcius = (fahrenheit - 32) * 5 / 9
        messageUpdate(celcius)
    }

    Column(
        Modifier.padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CustomButton(text = "ShowBox", targetState = true, onClick = onClick)
            CustomButton(text = "HideBox", targetState = false, onClick = onClick)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text("Welcome to my Temperature Converter!")

        if (boxVisible) {
            Box(modifier = Modifier.size(height = 400.dp, width = 400.dp).background(Color.Yellow)
            ){
                Column(
                    Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(text = "Celcius: ${celcius.toInt()} C")
                    Slider(
                        value = celcius,
                        onValueChange = { fahrenheitUpdate(it) },
                        valueRange = 0f..100f,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = "Fahrenheit: ${fahrenheit.toInt()} F")
                    Slider(
                        value = fahrenheit,
                        onValueChange = { celciusUpdate(it) },
                        valueRange = 32f..212f,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = message)
                }
            }
        }
    }
}

@Composable
fun CustomButton(text: String, targetState: Boolean, onClick: (Boolean) -> Unit, bgColor: Color  = Color.Blue) {
    Button(
        onClick = { onClick(targetState) },
        colors = ButtonDefaults.buttonColors(
            containerColor = bgColor,
            contentColor = Color.White
        )
    ) {
        Text(text)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
   @Composable
   fun MainScreen(){

   }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Hw2g2Theme {
        MainScreen()
    }
}