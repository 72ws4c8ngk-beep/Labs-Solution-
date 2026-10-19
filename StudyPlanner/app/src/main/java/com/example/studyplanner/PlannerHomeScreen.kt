
package com.example.studyplanner

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.studyplanner.ui.theme.StudyPlannerTheme

// P1.3 - UI State
data class PlannerUiState(
    val greeting: String = "Welcome back!",
    val totalTasks: Int = 7,
    val completedTasks: Int = 3
)

// P1.4 - Stateless Home Screen
@Composable
fun PlannerHomeScreen(
    uiState: PlannerUiState,
    onCompleteTask: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = uiState.greeting)

        Text(
            text = "${uiState.completedTasks} of ${uiState.totalTasks} done"
        )

        Button(
            onClick = onCompleteTask,
            enabled = uiState.completedTasks < uiState.totalTasks
        ) {
            Text("Complete a Task")
        }
    }
}

// P1.6 - Route owns state and handles events
@Composable
fun PlannerHomeRoute() {
    var uiState by remember {
        mutableStateOf(PlannerUiState())
    }

    PlannerHomeScreen(
        uiState = uiState,
        onCompleteTask = {
            uiState = uiState.copy(
                completedTasks = uiState.completedTasks + 1
            )
        }
    )
}

// P1.5 - Preview 1
@Preview(showBackground = true, name = "Tasks in progress")
@Composable
private fun PlannerHomePreview() {
    StudyPlannerTheme {
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

// P1.5 - Preview 2
@Preview(showBackground = true, name = "All tasks completed")
@Composable
private fun PlannerHomeCompletedPreview() {
    StudyPlannerTheme {
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
