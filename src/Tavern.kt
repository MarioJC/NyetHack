fun main() {
    var beverage = readLine()

    if (beverage != null) {
        // beverage wordt gesmartcast van String? naar String
        // omdat in deze branch beverage gegarandeerd niet null is
        beverage = beverage.capitalize()
    } else {
        println("I can't do that without crashing - beverage was null!")
    }

    println(beverage)
}