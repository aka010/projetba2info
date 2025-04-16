package com.example.runner_ba2

open class Obstacle : GameObject() {
    private var hasCollided: Boolean = false

    open fun update() {
        // Logique de base pour mettre à jour l'obstacle
    }

    open fun isCollidingWithPlayer(player: Player): Boolean {
        // Logique de base pour la détection de collision
        return if (this.getRectF().intersect(player.getRectF()) && !hasCollided) {
            hasCollided = true
            true
        } else {
            false
        }
    }
}
