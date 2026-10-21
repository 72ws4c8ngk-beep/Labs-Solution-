
package com.example.studyplanner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Navy = Color(0xFF192C51)
private val Blue = Color(0xFF405A92)
private val LightBackground = Color(0xFFF4F6FB)
private val GrayText = Color(0xFF64748B)

data class TaskDetailUiState(
    val title: String,
    val description: String,
    val subject: String,
    val priority: String,
    val estimatedTime: String,
    val status: String
)

@Composable
fun TaskDetailScreen(
    uiState: TaskDetailUiState,
    onShareClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(LightBackground)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = "Task Details",
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold,
            color = Navy
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Text(
                    text = "STUDY TASK",
                    fontSize = 13.sp,
                    color = GrayText
                )

                Text(
                    text = uiState.title,
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold,
                    color = Navy
                )

                Text(
                    text = uiState.description,
                    fontSize = 14.sp,
                    color = GrayText
                )

                HorizontalDivider(
                    color = Color(0xFFE2E8F0)
                )

                DetailRow("Subject", uiState.subject)
                DetailRow("Priority", uiState.priority)
                DetailRow("Estimated Time", uiState.estimatedTime)
                DetailRow("Status", uiState.status)
            }
        }

        Button(
            onClick = onShareClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Blue
            )
        ) {
            Text("Share Task")
        }

        OutlinedButton(
            onClick = onBackClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Back", color = Navy)
        }
    }
}

@Composable
private fun DetailRow(
    label: String,
    value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            fontSize = 14.sp,
            color = GrayText
        )

        Text(
            text = value,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Navy
        )
    }
}

@Preview(showBackground = true, name = "Kotlin Task")
@Composable
private fun KotlinTaskPreview() {
    MaterialTheme {
        TaskDetailScreen(
            uiState = createTaskDetail("Study Kotlin"),
            onShareClick = {},
            onBackClick = {}
        )
    }
}

@Preview(showBackground = true, name = "Lab Report Task")
@Composable
private fun LabReportTaskPreview() {
    MaterialTheme {
        TaskDetailScreen(
            uiState = createTaskDetail("Complete Lab 5 Report"),
            onShareClick = {},
            onBackClick = {}
        )
    }
}

fun createTaskDetail(title: String): TaskDetailUiState {
    return when (title) {
        "Study Kotlin" -> TaskDetailUiState(
            title = title,
            description = "Review Kotlin fundamentals, including variables, functions, and null safety.",
            subject = "Mobile Development",
            priority = "High",
            estimatedTime = "45 minutes",
            status = "In Progress"
        )

        "Complete Lab 5 Report" -> TaskDetailUiState(
            title = title,
            description = "Prepare the lab report, capture screenshots, and document the navigation and sharing features.",
            subject = "Mobile Development",
            priority = "High",
            estimatedTime = "60 minutes",
            status = "Pending"
        )

        "Review Jetpack Compose" -> TaskDetailUiState(
            title = title,
            description = "Practice Compose layouts, reusable components, and state management.",
            subject = "Android Development",
            priority = "Medium",
            estimatedTime = "30 minutes",
            status = "Pending"
        )

        else -> TaskDetailUiState(
            title = title,
            description = "Complete this study task.",
            subject = "General",
            priority = "Medium",
            estimatedTime = "30 minutes",
            status = "Pending"
        )
    }
}
