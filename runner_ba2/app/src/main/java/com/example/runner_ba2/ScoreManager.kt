package com.example.runner_ba2

/**

Handles scoring when collisions occur.*/
class ScoreManager : CollisionListener {
    override fun onCollision(gameObject1: GameObject, gameObject2: GameObject) {
        println("ScoreManager: Collision detected between $gameObject1 and $gameObject2")
        // Add logic to update the score
    }
}