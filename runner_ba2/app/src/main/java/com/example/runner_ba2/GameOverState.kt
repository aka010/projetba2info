package com.example.runner_ba2

class GameOverState(private val game: Game) : GameState {

    private var finalScore: Int = 0  // Score stocké localement

    override fun enter() {
        println("Game Over!")
        checkHighScore()
    }

    override fun exit() {
        println("Exiting Game Over State")
    }

    override fun update() {
        // Animations de fin de jeu si nécessaire
    }

    override fun handleInput(input: Input) {
        when (input.type) {
            InputType.RESTART -> {
                // Redémarrer le jeu avec un nouvel état PlayingState
                game.changeState(PlayingState(game))
            }
            InputType.MENU -> game.changeState(StartMenuState(game))
            InputType.QUIT -> System.exit(0)
            else -> {} // Ignorer les autres entrées
        }
    }

    private fun checkHighScore() {
        // Vérifier si le score est un nouveau record
        println("Checking high score...")
    }
}