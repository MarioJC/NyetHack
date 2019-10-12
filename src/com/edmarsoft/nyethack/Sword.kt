package com.edmarsoft.nyethack

fun main() {

//    // Exercise 1
//    val sword = Sword("Excalibur")
//    println(sword.name)
//
//    // Exercise 2
//    sword.name = "Gleipnir"
//    println(sword.name)

    // Exercise 3
    val sword = Sword("Excalibur")
    println(sword.name)

}

class Sword(_name: String) {
    var name = _name
        get() = "The legendary $field"
        set(value) {
            println("set")
            field = value.toLowerCase().reversed().capitalize()
        }

    init {
        println("init")
        name = _name
    }
}