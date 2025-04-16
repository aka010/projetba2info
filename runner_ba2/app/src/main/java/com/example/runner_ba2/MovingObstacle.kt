package com.example.runner_ba2

import kotlin.math.sin

//Represents a moving obstacle (destructible) with sinusoidal horizontal motion.*/
class MovingObstacle(
    x: Float,
    y: Float,
    val width: Float,
    val height: Float,
    val speed: Float,
    val damage: Int,
    val horizontalSpeed: Float,
    val amplitude: Float
) : Obstacle() {

    private var time: Float = 0f

    init {
        setPosition(Position(x, y))
    }

    //Updates the position of the moving obstacle by adding vertical and sinusoidal horizontal motion.*/
    override fun update() {
        val position = getPosition()

        // Move downward
        position.y += speed

        // Add sinusoidal horizontal motion
        time += 0.1f
        position.x += horizontalSpeed * sin(time) * amplitude

        setPosition(position)
    }

    override fun toString(): String {
        return "MovingObstacle(x=${getPosition().x}, y=${getPosition().y}, width=$width, height=$height, speed=$speed, damage=$damage, horizontalSpeed=$horizontalSpeed, amplitude=$amplitude)"
    }
}
