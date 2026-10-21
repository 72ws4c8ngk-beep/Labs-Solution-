package com.example.studyplanner



import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.studyplanner.navigation.PlannerHome
import com.example.studyplanner.navigation.TaskDetail

@Composable
fun StudyPlannerApp() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = PlannerHome
    ) {
        composable<PlannerHome> {
            PlannerHomeRoute(
                onTaskClick = { title ->
                    navController.navigate(
                        TaskDetail(title = title)
                    )
                }
            )
        }

        composable<TaskDetail> { backStackEntry ->
            val taskDetail = backStackEntry.toRoute<TaskDetail>()

            TaskDetailRoute(
                title = taskDetail.title,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
