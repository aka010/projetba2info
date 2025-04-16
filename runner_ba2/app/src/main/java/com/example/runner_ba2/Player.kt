package com.example.runner_ba2

class Player(
    private var lives: Int,
    private var lane: Int

// La voie actuelle du joueur
) : GameObject() {
    init {
        // Positionner le joueur en bas de l'écran dans sa voie initiale
        val laneWidth = GameView.WIDTH / (MAX_LANE + 1)
        val x = lane * laneWidth + (laneWidth / 2)
        val y = GameView.HEIGHT - 200f // Un peu au-dessus du bas de l'écran
        setPosition(Position(x, y))
    }

    companion object {
        const val MIN_LANE = 0 // La voie la plus à gauche
        const val MAX_LANE = 2 // La voie la plus à droite, ajustez selon votre jeu
    }

    /**
     * Déplace le joueur vers la gauche.
     * Si le joueur est déjà sur la voie la plus à gauche (MIN_LANE), il ne se déplace pas.
     */
    fun moveLeft() {
        if (lane > MIN_LANE) {
            lane--
            println("Player moved left to lane: $lane")
        } else {
            println("Player is already on the leftmost lane.")
        }
    }

    fun moveRight() {
        if (lane < MAX_LANE) {
            lane++
            println("Player moved right to lane: $lane")
        } else {
            println("Player is already on the rightmost lane.")
        }
    }
    /**
     * Réduit le nombre de vies du joueur de 1.
     * Si le joueur n'a plus de vies (lives <= 0), le jeu passe à l'état de fin (Game Over).
     */
    fun loseLife() {
        if (lives > 0) {
            lives--
            println("Player lost a life. Remaining lives: $lives")

            if (lives == 0) {
                println("Game Over! Player has no lives left.")
                // Transition vers GameOverState ou logique associée
            }
        }
    }

    /**
     * Met à jour l'état du joueur.
     * (Définition à ajouter plus tard selon les besoins du jeu)
     */
    fun update() {
        val laneWidth = GameView.WIDTH / (MAX_LANE + 1)
        val targetX = lane * laneWidth + (laneWidth / 2)

        val currentPos = getPosition()
        currentPos.x = targetX.coerceIn(50f, GameView.WIDTH - 50f) // Limiter aux bords
        currentPos.y = GameView.HEIGHT - 200f // Maintenir la position verticale
        setPosition(currentPos)
    }

    fun resetLives() {
        lives = 3
    }
}