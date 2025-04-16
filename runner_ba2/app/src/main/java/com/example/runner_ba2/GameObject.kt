package com.example.runner_ba2

import android.graphics.RectF

/**

Represents a game object in the game world.*/
open class GameObject {
    private var x: Float = 0f
    private var y: Float = 0f
    private  var rectF: RectF = RectF(x, y, x + 50f, y+ 50f)

    // Get the position of the object
    fun getPosition(): Position = Position(x, y)

    fun getRectF(): RectF = rectF

    // Set the position of the object
    fun setPosition(position: Position) {
        // Ensure the position is within the game world bounds (if any)
        if (position.x < 0 || position.y < 0) {
            throw IllegalArgumentException("Position cannot be negative")
        }
        this.x = position.x
        this.y = position.y
        this.rectF = RectF(x, y, x + 50f, y+ 50f)
    }

    override fun toString(): String {
        return "GameObject(x=$x, y=$y)"
    }
}