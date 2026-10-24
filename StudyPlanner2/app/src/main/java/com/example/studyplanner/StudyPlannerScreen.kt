
package com.example.studyplanner

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

// CSC 402 · Lecture 6 application — Study Planner
// Step 2: The Route connects the ViewModel
// Step 3: The Screen draws the state

// The Route owns the state
@Composable
fun StudyPlannerRoute(
    viewModel: StudyPlannerViewModel = viewModel()
) {

    // TODO 2 — Draft survives rotation
    var draft by rememberSaveable {
        mutableStateOf("")
    }

    StudyPlannerScreen(
        uiState = viewModel.uiState,
        draft = draft,

        onDraftChange = {
            // TODO 3 — Store the new text
            draft = it
        },

        onAddTask = {
            // TODO 4 — Add task and clear field
            viewModel.addTask(draft)
            draft = ""
        }
    )
}

// The Screen is stateless
@Composable
fun StudyPlannerScreen(
    uiState: StudyPlannerUiState,
    draft: String,
    onDraftChange: (String) -> Unit,
    onAddTask: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp)
    ) {

        TaskCount(count = uiState.tasks.size)

        // TODO 5 — Show the input row
        AddTaskRow(
            text = draft,
            onTextChange = onDraftChange,
            onAdd = onAddTask
        )

        // TODO 6 — Show the task list
        uiState.tasks.forEach { task ->
            Text("• $task")
        }
    }
}

// Preview
@Preview(showBackground = true)
@Composable
fun StudyPlannerScreenPreview() {
    StudyPlannerScreen(
        uiState = StudyPlannerUiState(
            tasks = listOf("Read Ch. 2", "Finish Lab 6")
        ),
        draft = "",
        onDraftChange = {},
        onAddTask = {}
    )
}
