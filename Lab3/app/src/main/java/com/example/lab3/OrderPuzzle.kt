package com.example.lab3


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ChainA() {
    Column {
        Text("Chain A")
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color.Red)
                .padding(20.dp)
                .background(Color.Yellow)
        )
    }
}

@Composable
fun ChainB() {
    Column {
        Text("Chain B")
        Box(
            modifier = Modifier
                .size(120.dp)
                .padding(20.dp)
                .background(Color.Green)
                .border(4.dp, Color.Black)
        )
    }
}

@Composable
fun ChainC() {
    Column {
        Text("Chain C")
        Box(
            modifier = Modifier
                .size(120.dp)
                .border(4.dp, Color.Blue)
                .padding(20.dp)
                .background(Color.Magenta)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OrderPuzzlePreview() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        ChainA()
        ChainB()
        ChainC()
    }
}
