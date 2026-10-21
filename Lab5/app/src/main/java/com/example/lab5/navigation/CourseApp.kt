
package com.example.lab5.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.lab5.HomeRoute
import com.example.lab5.CourseListRoute
import com.example.lab5.CourseDetailRoute

@Composable
fun CourseApp() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Home
    ) {
        composable<Home> {
            HomeRoute(
                onCoursesClick = {
                    navController.navigate(CourseList)
                }
            )
        }

        composable<CourseList> {
            CourseListRoute(
                onCourseClick = { code ->
                    navController.navigate(
                        CourseDetail(code)
                    )
                }
            )
        }

        composable<CourseDetail> { backStackEntry ->
            val detail: CourseDetail =
                backStackEntry.toRoute()

            CourseDetailRoute(
                code = detail.code,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
