package com.example.runner_ba2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView

class GameView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : SurfaceView(context, attrs, defStyleAttr), SurfaceHolder.Callback {

    companion object {
        const val WIDTH = 1080f
        const val HEIGHT = 1920f
    }

    private var gameThread: GameThread? = null
    private lateinit var game: Game
    private val paint = Paint()

    // Ajoutez ces propriétés pour la mise à l'échelle
    private var scaleX: Float = 1f
    private var scaleY: Float = 1f

    init {
        holder.addCallback(this)
        isFocusable = true
    }

    fun setGame(game: Game) {
        this.game = game
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        gameThread = GameThread(holder, this).apply {
            running = true
            start()
        }
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        scaleX = width / WIDTH
        scaleY = height / HEIGHT
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        gameThread?.running = false
        gameThread?.join()
    }

    fun update() {
        game.update()
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        canvas.save()
        canvas.scale(scaleX, scaleY)

        // Draw background
        paint.color = Color.BLACK
        canvas.drawColor(Color.BLACK)

        // Draw lanes
        paint.color = Color.GRAY
        paint.strokeWidth = 5f
        val laneWidth = WIDTH / 3
        for (i in 1..2) {
            val x = i * laneWidth
            canvas.drawLine(x, 0f, x, HEIGHT, paint)
        }

        // Draw player
        paint.color = Color.BLUE
        val player = game.getPlayer()
        val playerPos = player.getPosition()
        val playerSize = 50f
        canvas.drawRect(
            playerPos.x - playerSize/2,
            playerPos.y - playerSize/2,
            playerPos.x + playerSize/2,
            playerPos.y + playerSize/2,
            paint
        )

        // Draw obstacles
        val obstacles = game.getGameWorld().getObstacleManager().getObstacles()
        for (obstacle in obstacles) {
            when (obstacle) {
                is StaticObstacle -> {
                    paint.color = Color.RED
                    canvas.drawRect(
                        obstacle.getPosition().x - obstacle.width/2,
                        obstacle.getPosition().y - obstacle.height/2,
                        obstacle.getPosition().x + obstacle.width/2,
                        obstacle.getPosition().y + obstacle.height/2,
                        paint
                    )
                }
                is MovingObstacle -> {
                    paint.color = Color.YELLOW
                    canvas.drawCircle(
                        obstacle.getPosition().x,
                        obstacle.getPosition().y,
                        obstacle.width/2,
                        paint
                    )
                }
            }
        }

        // Draw score
        paint.color = Color.WHITE
        paint.textSize = 60f
        paint.textAlign = Paint.Align.LEFT
        canvas.drawText("Score: ${game.getScore()}", 50f, 100f, paint)

        canvas.restore()
    }

    private class GameThread(
        private val surfaceHolder: SurfaceHolder,
        private val gameView: GameView
    ) : Thread() {

        var running: Boolean = false
        private val targetFPS = 60
        private val targetTime = (1000000000 / targetFPS).toLong()

        override fun run() {
            var lastTime = System.nanoTime()

            while (running) {
                val now = System.nanoTime()
                val elapsed = now - lastTime

                if (elapsed > targetTime) {
                    var canvas: Canvas? = null
                    try {
                        canvas = surfaceHolder.lockCanvas()
                        synchronized(surfaceHolder) {
                            gameView.update()
                            canvas?.let { gameView.draw(it) }
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    } finally {
                        canvas?.let {
                            surfaceHolder.unlockCanvasAndPost(it)
                        }
                    }
                    lastTime = now
                }
            }
        }
    }
}
