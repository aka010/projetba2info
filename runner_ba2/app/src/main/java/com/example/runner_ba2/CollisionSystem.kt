package com.example.runner_ba2

//The CollisionSystem manages collision detection and notifies registered listeners about collisions.*/
class CollisionSystem {

    // List of listeners that will be notified of collisions
    private val listeners = mutableListOf<CollisionListener>()

    //Add a listener to the system.*/
    fun addListener(listener: CollisionListener) {
        listeners.add(listener)
    }

    //Remove a listener from the system.*/
    fun removeListener(listener: CollisionListener) {
        listeners.remove(listener)
    }

    //Notify all registered listeners about a collision.*/
    fun notifyCollision(gameObject1: GameObject, gameObject2: GameObject) {
        for (listener in listeners) {
            listener.onCollision(gameObject1, gameObject2) // Notify each listener}}
        }
    }
}
