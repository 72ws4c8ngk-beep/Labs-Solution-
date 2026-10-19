
package com.example.lab2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Navy = Color(0xFF0B2545)
private val AndroidGreen = Color(0xFF3DDC84)
private val Background = Color(0xFFF4F7FA)

@Composable
fun AttendanceCounter() {
    var count by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Navy)
                .padding(20.dp)
        ) {
            Text(
                text = "Attendance Counter",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Task 8 - State",
                color = Color.LightGray
            )
        }

        Spacer(modifier = Modifier.height(35.dp))

        Text(
            text = "STUDENTS PRESENT",
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(12.dp))

        Card(
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "$count",
                modifier = Modifier.padding(
                    horizontal = 65.dp,
                    vertical = 24.dp
                ),
                fontSize = 52.sp,
                fontWeight = FontWeight.Bold,
                color = Navy
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = {
                    if (count > 0) count--
                },
                enabled = count > 0
            ) {
                Text("−")
            }

            Button(
                onClick = { count++ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = AndroidGreen
                )
            ) {
                Text("+", color = Navy)
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        OutlinedButton(
            onClick = { count = 0 },
            enabled = count > 0
        ) {
            Text("Reset")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = if (count == 0) {
                "Tap + to check a student in."
            } else {
                "$count of 30 students checked in."
            },
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AttendanceCounterPreview() {
    MaterialTheme {
        AttendanceCounter()
    }
}
