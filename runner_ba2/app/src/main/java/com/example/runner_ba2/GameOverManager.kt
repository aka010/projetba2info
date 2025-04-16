package com.example.runner_ba2

/**

Handles game-over logic when collisions occur.*/
class GameOverManager : CollisionListener {
    override fun onCollision(gameObject1: GameObject, gameObject2: GameObject) {
        println("GameOverManager: Collision detected between $gameObject1 and $gameObject2")
        // Add logic to handle game-over scenarios
    }
}