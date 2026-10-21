package com.example.studyplanner




import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun TaskDetailRoute(
    title: String,
    onBackClick: () -> Unit
) {
    val context = LocalContext.current

    TaskDetailScreen(
        uiState = createTaskDetail(title),
        onShareClick = {
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(
                    Intent.EXTRA_TEXT,
                    "Today I'm studying: $title"
                )
            }

            context.startActivity(
                Intent.createChooser(
                    shareIntent,
                    "Share Study Task"
                )
            )
        },
        onBackClick = onBackClick
    )
}
