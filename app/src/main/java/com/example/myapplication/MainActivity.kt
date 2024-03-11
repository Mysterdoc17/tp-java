package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.motion.utils.Oscillator.TAG
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    private val TAG = MainActivity::class.java.simpleName
    val MyViewMode by viewModels<MyViewModel>()
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var nb = remember {
                mutableStateOf(0)
            }
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    androidx.compose.foundation.layout.Column {
                        androidx.compose.material3.Button(onClick = { /*TODO*/ }) {
                            androidx.compose.material3.Text(text = "submit")
                        }
                    }
                }
                MaterialTheme {
                    Scaffold(
                        topBar = {
                                 TopAppBar(
                                     title = { Text(text = "My Application")},
                                     modifier = Modifier.shadow(elevation = 10.dp)
                                     )
                        },
                        content = {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(it)
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.SpaceEvenly,
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier.fillMaxSize()
                                ) {
                                    Text(text = nb.value.toString(), fontSize = 50.sp)
                                    Button(onClick = {
                                        nb.value += 1
                                    }) {
                                        Text(text = "+")
                                    }
                                }
                            }
                        },
                        bottomBar = {/**/}
                    )
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume")
    }
    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
    }

}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}