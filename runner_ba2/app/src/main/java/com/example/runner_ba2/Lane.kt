package com.example.runner_ba2

class Lane(
    private val position: Int // Position de la voie
) {
    private val obstacles: MutableList<Obstacle> = mutableListOf() // Liste des obstacles dans la voie

    /*

    Ajoute un obstacle à la voie.
    @param obstacle L'obstacle à ajouter.*/
    fun addObstacle(obstacle: Obstacle) {
        obstacles.add(obstacle)
        println("Obstacle added to lane at position: $position")}

    /*

    Met à jour l'état des obstacles dans la voie.
    (Définition à ajouter plus tard selon les besoins du jeu)*/
    fun update() {// Mettre à jour chaque obstacle dans la voie
        val iterator = obstacles.iterator()
        while (iterator.hasNext()) {
            val obstacle = iterator.next()
            obstacle.update()

            // Supprimer les obstacles qui sont sortis de l'écran
            if (obstacle.getPosition().y > GameView.HEIGHT) {
                iterator.remove()
            }
        }
    }

}
