fun main() {
    val gradesByStudent = mapOf("Josh" to 4.0, "Alex" to 2.0, "Jane" to 3.0)
    println(flipValues(gradesByStudent))
}

fun <T1,T2> flipValues(m: Map<T1, T2>) : Map<T2, T1> {

//    // first the imperative way
//    val result: MutableMap<T2, T1> = mutableMapOf()
//    for((key, value) in m) {
//        result[value] = key
//    }
//    return result

    // now the functional way!
    return m.map { (key, value) -> value to key }.toMap()
}