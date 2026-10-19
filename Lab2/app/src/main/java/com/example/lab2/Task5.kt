package com.example.lab2



data class Course(
    val code: String,
    val title: String,
    val credits: Int,
    val days: String
)

fun findCourse(list: List<Course>, code: String): String {
    return list.firstOrNull { it.code == code }?.title
        ?: "Course not found"
}

fun task5() {

    val courses = listOf(
        Course("CSC 402", "Mobile Application Programming", 3, "Mon / Wed"),
        Course("CSC 311", "Database Systems", 4, "Sun / Tue"),
        Course("CSC 340", "Operating Systems", 3, "Mon / Wed"),
        Course("MATH 202", "Discrete Mathematics", 3, "Sun / Thu"),
        Course("ENG 214", "Technical Writing", 2, "Tue")
    )

    println("===== All Courses =====")
    courses.forEach { println(it) }

    println("\n===== Courses with 3 or more credits =====")
    courses.filter { it.credits >= 3 }
        .forEach { println(it) }

    println("\n===== Course Codes =====")
    println(courses.map { it.code })

    println("\n===== Total Credits =====")
    println(courses.sumOf { it.credits })

    println("\n===== Find Course =====")
    println(findCourse(courses, "CSC 402"))
    println(findCourse(courses, "CSC 999"))

    println("\n===== Copy Course =====")
    val originalCourse = courses.first { it.code == "CSC 402" }
    val updatedCourse = originalCourse.copy(credits = 4)

    println("Updated: $updatedCourse")
    println("Original: $originalCourse")
}
