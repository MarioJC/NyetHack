import java.lang.IllegalStateException

fun main() {
    var swordsJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3 // 1 in 3 chance to be proficient
    if (isJugglingProficient) {
        swordsJuggling = 2
    }

    try {
        proficiencyCheck(swordsJuggling)
        swordsJuggling = swordsJuggling!! + 1
    } catch (e: Exception) {
        println(e)
    }

    println("You juggle with $swordsJuggling swords!")
}

fun proficiencyCheck(swordsJuggling: Int?) {
    swordsJuggling ?: throw UnskilledSwordJuggler()
//    checkNotNull(swordsJuggling, { "Player cannot juggle swords" })
}

class UnskilledSwordJuggler() : IllegalStateException("Player cannot juggle swords")