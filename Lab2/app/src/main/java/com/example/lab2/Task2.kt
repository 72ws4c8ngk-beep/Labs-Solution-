package com.example.lab2



fun greetStudent(
    name: String,
    course: String = "CSC 402"
): String {
    return "Welcome to $course, $name!"
}

fun finalMark(
    quizzes: Double,
    project: Double,
    finalExam: Double
): Double {
    return quizzes * 0.10 + project * 0.70 + finalExam * 0.20
}

fun printBanner(title: String, width: Int = 40) {
    println("-".repeat(width))
    println(title)
    println("-".repeat(width))
}

fun task2() {
    printBanner("CSC 402 Lab 2")

    println(greetStudent("Sara"))
    println(greetStudent("Mona", "CSC 311"))

    val mark1 = finalMark(90.0, 85.0, 95.0)

    val mark2 = finalMark(
        finalExam = 95.0,
        quizzes = 90.0,
        project = 85.0
    )

    println("Final mark 1: $mark1")
    println("Final mark 2: $mark2")
}
