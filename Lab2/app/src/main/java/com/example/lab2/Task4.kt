
package com.example.lab2

fun describeTeam(teamName: String?): String {
    return teamName?.let {
        "Team: $it (${it.length} characters)"
    } ?: "Team not registered yet"
}

fun task4() {
    val nickname: String? = null
    val fullName: String = "Abdullah Al-Qahtani"

    println("Full name length: ${fullName.length}")

    println("Nickname length: ${nickname?.length}")

    println("Nickname: ${nickname ?: "no nickname set"}")

    println(describeTeam("Team Falcon"))

    println(describeTeam(null))

    // Uncomment this line to test the exception:
    // println(nickname!!.length)
}
