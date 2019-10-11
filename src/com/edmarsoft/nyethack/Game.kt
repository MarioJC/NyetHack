package com.edmarsoft.nyethack

fun main() {
    val player = Player("Madrigal")
    player.castFireBall()

    printPlayerStatus(player)
}

private fun printPlayerStatus(player: Player) {
    println("(Aura: ${player.auraColor()}) (Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()} (HP: ${player.healthPoints})")
}