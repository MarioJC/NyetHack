fun main() {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    // Aura
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    println(auraColor)

    val healthStatus = if (healthPoints == 100)
        "is in excellent condition!"
    else if (healthPoints in 90..99)
        "has a few scratches."
    else if (healthPoints in 75..89)
        if (isBlessed)
            "has some minor wounds but is healing quickly!"
        else
            "has some minor wounds."
    else if (healthPoints in 15..74)
        "looks pretty hurt."
    else
        "is in awful condition!"

    // Player status
    println(name + " " + healthStatus)
}