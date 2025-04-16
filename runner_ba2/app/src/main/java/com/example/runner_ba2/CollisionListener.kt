package com.example.runner_ba2

/**

Interface pour gérer les événements de collision.*/
interface CollisionListener {
    fun onCollision(gameObject1: GameObject, gameObject2: GameObject)
}