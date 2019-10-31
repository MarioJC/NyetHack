// my very first extension function for the List collection :)
fun List<Int>.multiply(): Int {
    var result = 1
    this.forEach {
        result *= it
    }

    return result
}

fun main() {
    val valuesToAdd = listOf(1,18,73,3,44,6,1,33,2,22,5,7)
    println(valuesToAdd.filter { it >= 5 }.chunked(2) { it.multiply() }.sum())
}