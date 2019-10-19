package com.edmarsoft.nyethack

import kotlin.system.exitProcess

fun main() {
    Game.play()
}

object Game {
    private val player = Player("Madrigal")
    private var currentRoom: Room = TownSquare()

    private var worldMap = listOf(
        listOf(currentRoom, Room("Tavern"), Room("Back Room")),
        listOf(Room("Long Corridor"), Room("Generic Room"))
    )

    init {
        println("Welcome, adventurer.")
        player.castFireBall()
        showMap()
    }

    fun play() {
        while (true) { // Nyethack game loop

            println(currentRoom.description())
            println(currentRoom.load())

            printPlayerStatus(player)

            print("> Enter your command: ")
            println(GameInput(readLine()).processCommand())
        }
    }

    private fun printPlayerStatus(player: Player) {
        println("(Aura: ${player.auraColor()}) (Blessed: ${if (player.isBlessed) "YES" else "NO"})")
        println("${player.name} ${player.formatHealthStatus()} (HP: ${player.healthPoints})")
    }

    private class GameInput(arg: String?) {
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1) { "" }

        // converted the single expression function from the book to a standard function
        // because of some weird warnings by the compiler
        fun processCommand() = when(command.toLowerCase()) {
            // TODO: avoid Kotlin.Unit being printed to the console
            // I'm assuming it has something to do with the implicit cast to Any below...
                "move" -> {
                    move(argument)
                    showMap()
                }
                "map" -> showMap()
                "ring" -> ringBell()
                "quit", "exit" -> quit()
                else -> "I'm not quite sure what you're trying to do!"
            }

    }

    private fun move(directionInput: String) =
        try {
            val direction = Direction.valueOf(directionInput.toUpperCase())
            val newPosition = direction.updateCoordinate(player.currentPosition)

            // if-statement from book in true Kotlin style 8)
            check(newPosition.isInBounds) { "$direction is out of bounds." }

            val newRoom = worldMap[newPosition.y][newPosition.x]
            player.currentPosition = newPosition
            currentRoom = newRoom
            "OK, you move $direction to the ${newRoom.name}.\n${newRoom.load()}"
        } catch (e: Exception) {
            "Invalid direction: $directionInput."
        }

    private fun showMap() : String {
        var map = ""
        worldMap.forEach { row ->
            row.forEach { room ->
                map += if (room == currentRoom) "X " else "O "
            }
            map += "\n"
        }
        return map
    }

    private fun ringBell() {
        if (currentRoom is TownSquare) {
            // making use of "also" instead of "currentRoom.ringBell()" because of possible race condition (p184/p185)
            currentRoom.also {
                println((it as TownSquare).ringBell())
            }
        } else {
            println("Can only ring the bell when on Town Square!")
        }
    }

    private fun quit() {
        println("kthxbye!")
        exitProcess(0)
    }
}