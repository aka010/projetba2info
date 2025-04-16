package com.example.runner_ba2

class ObstacleManager {
    private val obstacles: MutableList<Obstacle> = mutableListOf()
    private var difficultyLevel: Int = 1
    var obstacleScrollSpeed = 5f

    fun updateObstacles() {
        println("Mise à jour des obstacles")
        val iterator = obstacles.iterator()
        while (iterator.hasNext()) {
            val obstacle = iterator.next()
            obstacle.update()

            // Supprime si en dehors de l'écran
            if (obstacle.getPosition().y > GameView.HEIGHT) {
                iterator.remove()
            }
        }
    }


    fun generateObstacles(difficultyLevel: Int) {
        // Probabilité de générer un obstacle augmente avec la difficulté
        val chance = 0.1f + (difficultyLevel * 0.05f)

        // Choisir aléatoirement entre obstacle statique et mobile
        val isMoving = Math.random() < 0.3

        val laneWidth = GameView.WIDTH / 3
        val randomLane = (0..2).random()
        val x = randomLane * laneWidth + (laneWidth / 2)

        val obstacle = if (isMoving) {
            MovingObstacle(
                x = x,
                y = GameView.HEIGHT/9,
                width = 50f,
                height = 50f,
                speed = 5f ,
                damage = 1,
                horizontalSpeed = 2f/10,
                amplitude = 30f
            )
        } else {
            StaticObstacle(
                x = x,
                y = GameView.HEIGHT/9,
                width = 50f,
                height = 50f,
                speed = 5f ,
                damage = 1
            )
        }

        obstacles.add(obstacle)
    }

    fun getObstacles(): List<Obstacle> {
        return obstacles
    }

    fun setDifficultyLevel(level: Int) {
        difficultyLevel = level
        println("Niveau de difficulté des obstacles défini sur : $difficultyLevel")
    }
}