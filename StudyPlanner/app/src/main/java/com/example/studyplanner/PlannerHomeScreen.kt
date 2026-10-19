
package com.example.studyplanner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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

private val Navy = Color(0xFF192C51)
private val Blue = Color(0xFF405A92)
private val LightBackground = Color(0xFFF4F6FB)
private val GrayText = Color(0xFF64748B)

// UI State
data class PlannerUiState(
    val greeting: String = "Welcome back!",
    val totalTasks: Int = 7,
    val completedTasks: Int = 3
)

// Stateless Screen
@Composable
fun PlannerHomeScreen(
    uiState: PlannerUiState,
    onCompleteTask: () -> Unit,
    modifier: Modifier = Modifier
) {
    val progress = if (uiState.totalTasks > 0) {
        (uiState.completedTasks.toFloat() / uiState.totalTasks)
            .coerceIn(0f, 1f)
    } else {
        0f
    }

    val allCompleted =
        uiState.completedTasks >= uiState.totalTasks

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(LightBackground)
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {

        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Study Planner",
                    fontSize = 27.sp,
                    fontWeight = FontWeight.Bold,
                    color = Navy
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = uiState.greeting,
                    fontSize = 15.sp,
                    color = GrayText
                )
            }

            Text(
                text = "📚",
                fontSize = 32.sp
            )
        }

        // Progress Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Blue
            )
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Your Study Progress",
                    color = Color.White,
                    fontSize = 16.sp
                )

                Text(
                    text = "${uiState.completedTasks} / ${uiState.totalTasks}",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )

                LinearProgressIndicator(
                    progress = { progress },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp),
                    color = Color.White,
                    trackColor = Color(0xFF8496BA)
                )

                Text(
                    text = "${(progress * 100).toInt()}% completed",
                    color = Color.White,
                    fontSize = 13.sp
                )
            }
        }

        // Statistics Cards
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            StatisticCard(
                title = "Total Tasks",
                count = uiState.totalTasks,
                symbol = "📋",
                modifier = Modifier.weight(1f)
            )

            StatisticCard(
                title = "Completed",
                count = uiState.completedTasks,
                symbol = "✓",
                modifier = Modifier.weight(1f)
            )
        }

        // Today's Goal Card
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
                    text = "Today's Goal",
                    color = Navy,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = if (allCompleted) {
                        "Amazing! You completed all your study tasks."
                    } else {
                        "Complete your next study task and get closer to your goal."
                    },
                    color = GrayText,
                    fontSize = 14.sp
                )

                Button(
                    onClick = onCompleteTask,
                    enabled = !allCompleted,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Blue,
                        disabledContainerColor = Color(0xFFB8C2D3)
                    )
                ) {
                    Text(
                        text = "✓",
                        color = Color.White,
                        fontSize = 18.sp
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = if (allCompleted) {
                            "All Tasks Completed"
                        } else {
                            "Complete a Task"
                        },
                        fontSize = 15.sp
                    )
                }
            }
        }

        // Motivation Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFE4EBF8)
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "✨ Stay Motivated",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Navy
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = if (allCompleted) {
                        "Excellent work! You reached your goal."
                    } else {
                        "Small progress every day leads to big results!"
                    },
                    fontSize = 13.sp,
                    color = GrayText
                )
            }
        }
    }
}

// Reusable Statistics Card
@Composable
private fun StatisticCard(
    title: String,
    count: Int,
    symbol: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = symbol,
                fontSize = 20.sp,
                color = Blue
            )

            Text(
                text = count.toString(),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Navy
            )

            Text(
                text = title,
                fontSize = 13.sp,
                color = GrayText
            )
        }
    }
}

// Stateful Route
@Composable
fun PlannerHomeRoute() {
    var uiState by remember {
        mutableStateOf(PlannerUiState())
    }

    PlannerHomeScreen(
        uiState = uiState,
        onCompleteTask = {
            if (uiState.completedTasks < uiState.totalTasks) {
                uiState = uiState.copy(
                    completedTasks = uiState.completedTasks + 1
                )
            }
        }
    )
}

// Preview 1: 3 of 7
@Preview(
    showBackground = true,
    name = "Tasks In Progress"
)
@Composable
private fun PlannerHomePreview() {
    MaterialTheme {
        PlannerHomeScreen(
            uiState = PlannerUiState(
                greeting = "Welcome back!",
                totalTasks = 7,
                completedTasks = 3
            ),
            onCompleteTask = {}
        )
    }
}

// Preview 2: 7 of 7
@Preview(
    showBackground = true,
    name = "All Tasks Completed"
)
@Composable
private fun PlannerHomeCompletedPreview() {
    MaterialTheme {
        PlannerHomeScreen(
            uiState = PlannerUiState(
                greeting = "Great job!",
                totalTasks = 7,
                completedTasks = 7
            ),
            onCompleteTask = {}
        )
    }
}
