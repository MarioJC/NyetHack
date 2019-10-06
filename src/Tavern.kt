import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"

var playerGold = 50
var playerSilver = 50
var gallonsDragonsBreathInCask = 5.0 // a full cask of Dragon's Breath holds 5 gallons

fun main() {
    for (i in 1..12) {
        println("Purchase #$i:")
        placeOrder("shandy,Dragon's Breath,5.91")

        println("---")
    }
}

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(',')
    val message = "Madrigal buys a $name ($type) for $price."
    println(message)

    var phrase: String
    if (canPerformPurchase(playerGold, playerSilver, price.toDouble())) {
        performPurchase(price.toDouble())

        phrase = if (name == "Dragon's Breath") {
            "Madrigal exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
        } else {
            "Madrigal says: Thanks for the $name."
        }
    } else {
        phrase = "Sorry Madrigal, you're short on gold "
    }

    println(phrase)
}

fun canPerformPurchase(numGoldPieces: Int, numSilverPieces: Int, price: Double): Boolean {
    var total: Double = numGoldPieces + numSilverPieces / 100.0
    return total >= price
}

fun performPurchase(price: Double) {
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Total purse: ${"%.2f".format(totalPurse)}")
    println("Purchasing item for $price")

    val remainingBalance = totalPurse - price
    println("Remaining balance: ${"%.2f".format(remainingBalance)}")

    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSilver

    displayBalance()

    gallonsDragonsBreathInCask -= 0.125
    println("Gallons of Dragon's Breath left: $gallonsDragonsBreathInCask")
}

private fun displayBalance() {
    println("Player's purse balance: Gold: $playerGold, Silver: $playerSilver")
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