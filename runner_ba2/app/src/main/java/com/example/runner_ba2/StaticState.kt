package com.example.runner_ba2

//Represents a static obstacle in the game world.*/
class StaticObstacle(
    x: Float,
    y: Float,
    val width: Float,
    val height: Float,
    val speed: Float,
    val damage: Int
) : Obstacle() {

    init {
        setPosition(Position(x, y))
    }

    //Updates the position of the static obstacle by moving it downward based on its speed.*/
    override fun update() {
        val position = getPosition()
        position.y += speed // Moves the obstacle down by its speed
        setPosition(position)}

    override fun toString(): String {
        return "StaticObstacle(x=${getPosition().x}, y=${getPosition().y}, width=$width, height=$height, speed=$speed, damage=$damage)"
    }
}