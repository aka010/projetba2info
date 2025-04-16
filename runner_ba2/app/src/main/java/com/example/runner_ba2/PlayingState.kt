package com.example.runner_ba2

/**

État représentant le jeu en cours.*/
class PlayingState(private val game: Game) : GameState {

    private var frameCounter = 0


    override fun enter() {
        println("Entrée dans l'état PlayingState")
    }

    override fun update() {
        println("Mise à jour de l'état PlayingState")

        // Mise à jour des obstacles et du monde
        game.getGameWorld().update()

        // Appel de la génération automatique
        frameCounter++
        if (frameCounter % 60 == 0) { // toutes les ~1 seconde à 60 FPS
            game.getGameWorld().generateObstacles()
        }

        // Collision (optionnel)
        if (game.getGameWorld().checkCollisions()) {
            game.changeState(GameOverState(game))
        }
    }


    override fun exit() {
        println("Sortie de l'état PlayingState")
    }

    override fun handleInput(input: Input) {
        when (input.type) {
            InputType.LEFT -> {
                game.getPlayer().moveLeft()
                game.getPlayer().update()
            }
            InputType.RIGHT -> {
                game.getPlayer().moveRight()
                game.getPlayer().update()
            }
            InputType.PAUSE -> game.pause()
            else -> {} // Ignorer les autres entrées
        }
    }
}