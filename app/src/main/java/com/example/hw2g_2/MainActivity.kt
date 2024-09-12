package com.example.hw2g_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    Column(modifier=Modifier.fillMaxSize().padding(12.dp)){
        var input1 by remember { mutableStateOf("") }
        var input2 by remember { mutableStateOf("") }
        var number1 by remember { mutableStateOf(0f) }
        var number2 by remember { mutableStateOf(0f) }
        var operation by remember { mutableStateOf("")}
        var result by remember { mutableStateOf("0.0") }
        var msg by remember { mutableStateOf("") }

        // val operation = remember { mutableStateOf("") }

        TextField(
            value = input1,
            onValueChange = { input1 = it },
            label = { Text("Enter Number 1") }
        )
        TextField(
            value = input2,
            onValueChange = { input2 = it },
            label = { Text("Enter Number 2") }
        )
        //To Radio
        TextField(
            value = operation,
            onValueChange = { operation = it },
            label = { Text("Enter + - * / %") }
        )



        Row {
            Button(onClick = {
                if(input1==""){
                    input1=0f.toString()
                }

                if(input2==""){
                    input2=0f.toString()
                }
                // operation.value = "+"
                if (operation == "-" ){
                    result = Subtract(input1.toFloat(), input2.toFloat()).toString()
                }
                else if (operation == "*") {
                    result = Multiply(input1.toFloat(), input2.toFloat()).toString()
                }
                else if (operation == "/") {
                    if (input2.toFloat()==0f){
                       result= "Cannot divide by zero"

                    }
                    else{
                    result = Deviation(input1.toFloat(), input2.toFloat()).toString()}
                }
                else if (operation == "%") {
                    result = Modulo(input1.toFloat(), input2.toFloat()).toString()
                }
                else if (operation == "+") {
                    result = Add(input1.toFloat(), input2.toFloat()).toString()
                }
                else {
                    result = "Invalid Operation"

                }

            }) {
                Text("Calculate")
            }
        }
        Text(text = "Operation: $operation")

        Text(text = "Result: ${result}")
    }
}

fun Multiply(x: Float, y: Float): Float {
    return (x * y).toFloat()
}

fun Add(x: Float, y: Float): Float {
    return (x + y).toFloat()
}

fun Subtract(x: Float, y: Float): Float{
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
       Calculator()
    }
}