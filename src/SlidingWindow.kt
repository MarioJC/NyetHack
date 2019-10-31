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

    // also possible without the need for a separate multiply function
    // below we reference the list-in-list items directly with it[0] and it[1]

    // valuesToAdd.filter { it >= 5 }.chunked(2) { it[0] * it[1] }.sum())

    // PS: this will, however, fail when the list contains an odd number of items!
}