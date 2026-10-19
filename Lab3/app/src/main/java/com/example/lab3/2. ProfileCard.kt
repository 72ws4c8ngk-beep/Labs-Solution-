package com.example.lab3




import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab3.ui.theme.Lab3Theme

data class Student(
    val name: String,
    val program: String,
    val gpa: Double,
    val email: String,
    val city: String
)

val sampleStudent = Student(
    name = "Sara Ahmed",
    program = "Computer Science",
    gpa = 4.75,
    email = "sara@example.com",
    city = "Dammam"
)

@Composable
fun StudentCard(student: Student) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = student.name,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text("Program: ${student.program}")
            Text("GPA: ${student.gpa}")
            Text("Email: ${student.email}")
            Text("City: ${student.city}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StudentCardPreview() {
    Lab3Theme {
        StudentCard(sampleStudent)
    }
}
