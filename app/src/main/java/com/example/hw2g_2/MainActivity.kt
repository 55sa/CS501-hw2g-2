package com.example.hw2g_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hw2g_2.ui.theme.Hw2g2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TemperatureSlider()
        }
    }
}
@Composable
fun TemperatureSlider(){
    var sliderValue1 by remember { mutableStateOf(0f) }
    val rangeC: ClosedFloatingPointRange<Float> = 0.0f..100.0f

    var sliderValue2 by remember { mutableStateOf(0f) }
    val rangeF: ClosedFloatingPointRange<Float> = 30.0f..230.0f
    Column(
        modifier = Modifier.fillMaxWidth()
            .wrapContentWidth()
            .fillMaxWidth(0.5f)
//            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Slider(
            value = sliderValue1,
            valueRange = rangeC,
            onValueChange = {
                sliderValue1 = it
                sliderValue2 = CtoF(sliderValue1)
            },
            modifier = Modifier.fillMaxWidth()
        )
        Text("Celsius: ${sliderValue1}")

        Spacer(modifier = Modifier.height(16.dp))

        Slider(
            value = sliderValue2,
            onValueChange = {
                sliderValue2 = it
                sliderValue1 = FtoC(sliderValue2)
                },
            modifier = Modifier.fillMaxWidth()
        )
        Text("Fahrenheit: ${sliderValue2}")
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
fun CtoF(c: Float): Float = c * 2 + 30
fun FtoC(f: Float): Float = (f-30)/2

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Hw2g2Theme {
        Greeting("Android")
    }
}