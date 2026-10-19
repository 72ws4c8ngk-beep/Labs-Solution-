
package com.example.lab3

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab3.ui.theme.Lab3Theme

val students = listOf(
    Student("Sara Ahmed", "Computer Science", 4.75, "sara@example.com", "Dammam"),
    Student("Nora Ali", "Information Systems", 4.60, "nora@example.com", "Jubail"),
    Student("Reem Khalid", "Computer Science", 4.90, "reem@example.com", "Khobar"),
    Student("Maha Omar", "Software Engineering", 4.50, "maha@example.com", "Riyadh"),
    Student("Huda Saad", "Computer Science", 4.80, "huda@example.com", "Dammam")
)

@Composable
fun StudentList() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            start = 8.dp,
            end = 8.dp,
            bottom = 88.dp
        )
    ) {
        items(students) { student ->
            StudentCard(student)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Profile") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {}
            ) {
                Text("Edit")
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            StudentList()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    Lab3Theme {
        ProfileScreen()
    }
}
