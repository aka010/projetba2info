package com.example.runner_ba2

class Game {
    private var currentState: GameState = StartMenuState(this)
    private val gameWorld = GameWorld()
    private val player = Player(3, 1)
    private var score: Int = 0

    fun resetGame() {
        score = 0
        player.resetLives()
        changeState(PlayingState(this))
    }

    fun getScore(): Int = score

    fun setScore(newScore: Int) {
        score = newScore
    }
    fun start() {
        changeState(PlayingState(this))
    }

    fun pause() {
        changeState(PausedState(this, currentState))
    }

    fun resume() {
        changeState(PlayingState(this))
    }

    fun changeState(newState: GameState) {
        currentState.exit()
        currentState = newState
        currentState.enter()
    }

    fun update() {
        currentState.update()
        gameWorld.update()
    }

    fun handleInput(input: Input) {
        currentState.handleInput(input)
    }

    fun getPlayer(): Player = player
    fun getGameWorld(): GameWorld = gameWorld
}
