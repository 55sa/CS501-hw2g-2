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
fun MainScreen(){
    var boxVisible by remember {
        mutableStateOf(true)
    }

    val onClick = {newState: Boolean ->
        boxVisible = newState
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

        if(boxVisible){
            Box(modifier = Modifier.size(height = 400.dp, width = 400.dp).background(Color.Gray))
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