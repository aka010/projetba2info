package com.example.runner_ba2

open class Obstacle : GameObject() {
    open fun update() {
        // Logique de base pour mettre à jour l'obstacle
    }

    open fun isCollidingWithPlayer(): Boolean {
        // Logique de base pour la détection de collision
        return false
    }
}
