package com.example.runner_ba2

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var gameView: GameView
    private lateinit var collisionSystem: CollisionSystem
    private lateinit var game: Game

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize game components
        collisionSystem = CollisionSystem()
        game = Game()

        // Setup GameView
        gameView = findViewById(R.id.gameView)
        gameView.setGame(game)

        // Add collision listeners
        collisionSystem.addListener(ScoreManager())
        collisionSystem.addListener(GameOverManager())

        // Start the game
        game.start()

        // Set up button click listeners
        setupControls()
    }

    private fun setupControls() {
        val buttonLeft: Button = findViewById(R.id.buttonLeft)
        val buttonRight: Button = findViewById(R.id.buttonRight)

        buttonLeft.setOnClickListener {
            game.handleInput(Input(InputType.LEFT))
            game.getPlayer().update() // Force la mise à jour immédiate de la position
            gameView.invalidate() // Force le rafraîchissement de l'affichage
        }

        buttonRight.setOnClickListener {
            game.handleInput(Input(InputType.RIGHT))
            game.getPlayer().update() // Force la mise à jour immédiate de la position
            gameView.invalidate() // Force le rafraîchissement de l'affichage
        }
    }
}