fun main() {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    // wijziging tov boek: accolades rond characters in format string
    // (anders groot risico op ongewenste substituties)
    val statusFormatString = "({HP})({A}) --> {H}"

    // Aura
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal

    val karma = (Math.pow(Math.random(), (110 - healthPoints) / 100.0) * 20).toInt()
    val auraColor = when (karma) {
        in 0..5 -> "RED"
        in 6..10 -> "ORANGE"
        in 11..15 -> "PURPLE"
        in 16..20 -> "GREEN"
        else -> "RAINBOW"
    }

    val healthStatus = when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed) "has some minor wounds but is healing quickly!"
                     else "has some minor wounds."
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }

    // Player status
    val formattedString = statusFormatString
        .replace("{HP}", "HP: $healthPoints")
        .replace("{A}", "Aura: ${if (auraVisible) auraColor else "NONE"}")
        .replace("{B}", "Blessed: ${if (isBlessed) "YES" else "NO"})")
        .replace("{H}", "$name $healthStatus")

    println(formattedString)
}