package com.edmarsoft.nyethack

fun main() {
    val adversary = Jhava()
    println(adversary.utterGreeting())

    val friendshipLevel = adversary.determineFriendshipLevel()
    println(friendshipLevel?.toLowerCase() ?: "It's complicated.")

    // implicitly calling getter by referencing (private) field
    val adversaryHitPoints = adversary.hitPoints
    println(adversaryHitPoints.dec())
    println(adversaryHitPoints.javaClass)

    // implicitly calling setter by assigning to (private) field
    adversary.greeting = "Hello, Hero"
    println(adversary.utterGreeting())
}