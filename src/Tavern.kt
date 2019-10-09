import java.io.File
import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"

val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("data/tavern-menu-data.txt").readText().split('\n')
val patronGold = mutableMapOf<String, Double>()

fun main() {
    if (patronList.contains("Eli")) {
        println("The tavern master says: Eli is in the back playing cards.")
    } else {
        println("The tavern master says: Eli is not here.")
    }

    if (patronList.containsAll(listOf("Sophie", "Mordoc"))) {
        println("The tavern master says: Yea, they're seated by the stew kettle")
    } else {
        println("The tavern master says: Nay, they departed hours ago.")
    }

    (0..9).forEach {
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons += name
    }

    uniquePatrons.forEach { name ->
        patronGold[name] = 10.0
    }

    var orderCount = 0
    while (orderCount <= 9 && uniquePatrons.isNotEmpty()) {
        placeOrder(uniquePatrons.shuffled().first(), menuList.shuffled().first())
        orderCount++
    }

    displayPatronBalances()
}

private fun displayPatronBalances() {
    patronGold.forEach { patron, balance ->
        println("$patron, balance: ${"%.2f".format(balance)}")
    }
}

private fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName speaks with $tavernMaster about their order.")

    println("$patronName has ${patronGold[patronName]} gold left.")

    val (type, name, price) = menuData.split(',')
    val message = "$patronName buys a $name ($type) for $price."
    println(message)

    if (sufficientFunds(patronName, price)) {
        performPurchase(price.toDouble(), patronName)


        val phrase = if (name == "Dragon's Breath") {
            "$patronName exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
        } else {
            "$patronName says: Thanks for the $name."
        }
        println(phrase)
    } else { // insufficient funds!
        uniquePatrons -= patronName
        patronGold -= patronName
        println("Tavern bouncer says: sorry you're out of luck $patronName, I'm booting you out!")
    }
}

fun sufficientFunds(patronName: String, price: String): Boolean {
    return patronGold.getValue(patronName) >= price.toDouble()
}

fun performPurchase(price: Double, patronName: String) {
    patronGold[patronName] = patronGold.getValue(patronName) - price
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