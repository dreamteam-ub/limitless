package edu.ub.pis.joc.limitless.view

import android.graphics.Canvas
import android.view.SurfaceHolder
import edu.ub.pis.joc.limitless.engine.GameEngine

class GameThread(
    private val surfaceHolder: SurfaceHolder,
    private val gameView: GameView,
    private val gameEngine: GameEngine
) : Thread() {
    private var running: Boolean = false

    private val targetFPS = 30

    init {
        this.name = "GameThread"
    }

    fun setRunning(isRunning: Boolean) {
        this.running = isRunning
    }

    override fun run() {
        var startTime: Long
        var timeMillis: Long
        var waitTime: Long
        val targetTime = (1000 / targetFPS).toLong()
        while (running) {
            startTime = System.nanoTime()
            canvas = null

            try {
                // locking the canvas allows us to draw on to it
                canvas = this.surfaceHolder.lockCanvas()

                synchronized(surfaceHolder) {
                    if (gameView.pause) {
                        running = false
                    }
                    this.gameEngine.update()
                    if (canvas != null) {
                        this.gameView.draw(canvas!!)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                if (canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }

            timeMillis = (System.nanoTime() - startTime) / 1000000
            waitTime = targetTime - timeMillis

            if (waitTime > 0) {
                sleep(waitTime)
            }

        }
    }

    companion object {
        private var canvas: Canvas? = null
    }
}