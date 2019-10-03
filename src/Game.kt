fun main() {
    val name = "Madrigal"
    val healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    // Aura
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)
    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    var fireBallsCast : Int = 0
    fireBallsCast += castFireBall(9)
    fireBallsCast += castFireBall()

    // Player status
    printPlayerStatus(auraColor, isBlessed, name, healthStatus, fireBallsCast)
}

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String,
    numFireballsCast: Int
) {
    println("(Aura: $auraColor) (Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
    println("A total of $numFireballsCast fireballs were cast. $name is ${inebrationStatus(numFireballsCast)}!")
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean) =
    if (isBlessed && healthPoints > 50 || isImmortal) "GREEN" else "NONE"

private fun castFireBall(numFireBalls: Int = 2) : Int {
    println("A glass of Fireball springs into existence. (x$numFireBalls)")
    return numFireBalls
}

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
    when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed) "has some minor wounds but is healing quickly!"
        else "has some minor wounds."
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }

private fun inebrationStatus(inebrationValue: Int) =
    when (inebrationValue) {
        in 1..10 -> "tipsy"
        in 11..20 -> "sloshed"
        in 21..30 -> "soused"
        in 31..40 -> "stewed"
        in 41..50 -> "t0aSt3d"
        else -> "dead"
    }