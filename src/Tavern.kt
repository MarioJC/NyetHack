const val TAVERN_NAME = "Taernyl's Folly"

fun main() {
    placeOrder("shandy,Dragon's Breath,5.91")
    println("---")
    placeOrder("elixir,Shirley's Temple,4.12")
    println("---")
    println(toDragonSpeak("EVEN CAPITAL LETTERS ARE CONVERTED TO DRAGONSPEAK!"))
}

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(',')
    val message = "Madrigal buys a $name ($type) for $price."
    println(message)

    val phrase = if (name == "Dragon's Breath") {
        "Madrigal exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
        "Madrigal says: Thanks for the $name."
    }
    println(phrase)
}

private fun toDragonSpeak(phrase: String) =
        phrase.replace(Regex("[aAeEiIoOuU]")) {
            when (it.value) {
                "a", "A" -> "4"
                "e", "E" -> "3"
                "i", "I" -> "1"
                "o", "O" -> "0"
//                "u", "U" -> "|_|"
                else -> it.value
            }
        }