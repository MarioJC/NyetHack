const val TAVERN_NAME = "Taernyl's Folly"
const val DRAGON_TO_GOLD_CONVERSION_RATE = 1.43

var playerDragonCoin = 5.0

var gallonsDragonsBreathInCask = 5.0 // a full cask of Dragon's Breath holds 5 gallons

fun main() {
    placeOrder("shandy,Dragon's Breath,5.91")
    println("---")
    placeOrder("shandy,Dragon's Breath,5.91")
    println("---")
}

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(',')
    val message = "Madrigal buys a $name ($type) for $price."
    println(message)

    var phrase: String
    if (canPerformPurchase(playerDragonCoin, price.toDouble())) {
        performPurchase(price.toDouble())

        phrase = if (name == "Dragon's Breath") {
            "Madrigal exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
        } else {
            "Madrigal says: Thanks for the $name."
        }
    } else {
        phrase = "Sorry Madrigal, you're short on money!"
    }

    println(phrase)
}

fun canPerformPurchase(numDragonCoins: Double = 0.0, price: Double) =
    numDragonCoins * DRAGON_TO_GOLD_CONVERSION_RATE >= price


fun performPurchase(price: Double) {
    displayBalance()
    val totalPurse = playerDragonCoin * DRAGON_TO_GOLD_CONVERSION_RATE
    println("Total purse (converted to gold): ${"%.2f".format(totalPurse)}")
    println("Purchasing item for $price")

    val remainingBalance = totalPurse - price
    playerDragonCoin = remainingBalance / DRAGON_TO_GOLD_CONVERSION_RATE

    displayBalance()

    gallonsDragonsBreathInCask -= 0.125
    println("Gallons of Dragon's Breath left: $gallonsDragonsBreathInCask")
}

private fun displayBalance() {
    println("Player's purse balance: DragonCoin: ${"%.4f".format(playerDragonCoin)}")
}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
//                "u" -> "|_|"
            else -> it.value
        }
    }