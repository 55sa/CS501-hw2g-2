package com.example.hw2g_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hw2g_2.ui.theme.Hw2g2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Calculator()
        }
    }
}

@Composable
fun Calculator(){
    Column{
        val number1 = remember { mutableStateOf(0f) }
        val number2 = remember { mutableStateOf(0f) }
        val operation = remember { mutableStateOf("")}
        val result = remember { mutableStateOf(0f) }

        // val operation = remember { mutableStateOf("") }

        TextField(
            value = number1.value.toString(),
            onValueChange = { number1.value = it.toFloat() },
            label = { Text("Enter Number 1") }
        )
        TextField(
            value = number2.value.toString(),
            onValueChange = { number2.value = it.toFloat() },
            label = { Text("Enter Number 2") }
        )

        TextField(
            value = operation.value.toString(),
            onValueChange = { operation.value = it },
            label = { Text("Enter + - * / %") }
        )

        Text(text = "Operation: $operation")

        Text(text = "Result: ${result.value}")

        Row {
            Button(onClick = {
                // operation.value = "+"
                if operation.value == "-" {
                    result.value = Subtract(number1.value, number2.value)
                }
                else if (operation.value == "*") {
                    result.value = Multiply(number1.value, number2.value)
                }
                else if (operation.value == "/") {
                    if number2.value == 0{
                        result.value = "Cannot divide by zero"
                    }
                    result.value = Deviation(number1.value, number2.value)
                }
                else if (operation.value == "%") {
                    result.value = Modulo(number1.value, number2.value)
                }
                else if (operation.value == "+") {
                    result.value = Add(number1.value, number2.value)
                }
                else {
                    result.value = "Invalid Operation"
                }
                result.value = Add(number1.value, number2.value)
            }) {
                Text("Calculate")
            }
        }
    }
}

fun Multiply(x: Float, y: Float){
    return (x * y).toFloat()
}

fun Add(x: Float, y: Float){
    return (x + y).toFloat()
}

fun Subtract(x: Float, y: Float){
    return (x - y).toFloat()
}

fun Modulo(x: Float, y: Float): Float{
    return (x % y).toFloat()
}

fun Deviation(x: Float, y: Float): Float{
    return (x / y).toFloat()
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Hw2g2Theme {
        Greeting("Android")
    }
}