class Player {
    val name = "madrigal"
        get() = field.capitalize()

    fun castFireBall(numFireBalls: Int = 2) =
        println("A glass of Fireball springs into existence. (x$numFireBalls)")
}