package com.example.runner_ba2
class StartMenuState(private val game: Game) : GameState {

    // Options du menu
    private val menuOptions = listOf("Start Game", "Options", "High Scores", "Quit")
    private var selectedOption = 0

    override fun enter() {
        println("Entering Start Menu State")
        // Initialiser l'interface du menu
    }

    override fun exit() {
        println("Exiting Start Menu State")
    }

    override fun update() {
        // Mise à jour d'animations du menu si nécessaire
    }

    override fun handleInput(input: Input) {
        when (input.type) {
            InputType.UP -> {
                selectedOption = (selectedOption - 1 + menuOptions.size) % menuOptions.size
                println("Selected option: ${menuOptions[selectedOption]}")
            }
            InputType.DOWN -> {
                selectedOption = (selectedOption + 1) % menuOptions.size
                println("Selected option: ${menuOptions[selectedOption]}")
            }
            InputType.SELECT -> handleMenuSelection()
            else -> {} // Ignorer les autres entrées
        }
    }

    private fun handleMenuSelection() {
        when (selectedOption) {
            0 -> game.start() // Start Game
            1 -> println("Options menu not implemented") // Options menu
            2 -> println("High scores not implemented") // High Scores
            3 -> System.exit(0) // Quit
        }
    }
}