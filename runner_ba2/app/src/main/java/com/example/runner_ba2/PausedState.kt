package com.example.runner_ba2


class PausedState(private val game: Game, private val previousState: GameState) : GameState {

    override fun enter() {
        println("Entering Paused State")
    }

    override fun exit() {
        println("Exiting Paused State")
    }

    override fun update() {
        // Pas de mise à jour pendant la pause
    }

    override fun handleInput(input: Input) {
        when (input.type) {
            InputType.RESUME -> game.resume()
            InputType.MENU -> game.changeState(StartMenuState(game))
            InputType.QUIT -> System.exit(0)
            else -> {} // Ignorer les autres entrées
        }
    }
}
