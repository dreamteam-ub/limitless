package edu.ub.pis.joc.limitless.view

import android.app.Dialog
import android.content.Context
import android.graphics.Canvas
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import edu.ub.pis.joc.limitless.engine.GameEngine
import android.support.v4.content.LocalBroadcastManager
import android.content.Intent
import edu.ub.pis.joc.limitless.model.Data

const val TIME_SURVIVED = "survived_time"

class GameView(appContext: Context, private val dialog: Dialog, var mode : Boolean) : SurfaceView(appContext), SurfaceHolder.Callback {
    private var thread: GameThread
    private val gameEngine: GameEngine

    var pause = false

    init {
        // add callback
        holder.addCallback(this)
        gameEngine = GameEngine(appContext, mode)
        // instantiate the game thread
        thread = GameThread(holder, this, gameEngine)
    }

    override fun surfaceCreated(surfaceHolder: SurfaceHolder) {
        // start the game thread
        if (thread.state == Thread.State.TERMINATED) {
            thread = GameThread(holder, this, gameEngine)
        }
        thread.setRunning(true)
        thread.start()
    }

    override fun surfaceChanged(surfaceHolder: SurfaceHolder, i: Int, i1: Int, i2: Int) {

    }

    override fun surfaceDestroyed(surfaceHolder: SurfaceHolder) {
        while (thread.isAlive) {
            try {
                thread.setRunning(false)
                thread.join()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        gameEngine.touched_x = event.x.toInt()
        gameEngine.touched_y = event.y.toInt()

        when (event.action) {
            MotionEvent.ACTION_DOWN ->
                if (gameEngine.touched_x > (gameEngine.player.x - gameEngine.player.w)
                    && gameEngine.touched_x < (gameEngine.player.x + gameEngine.player.w)
                    && gameEngine.touched_y < (gameEngine.player.y + gameEngine.player.h)
                    && gameEngine.touched_y > (gameEngine.player.y - gameEngine.player.h)
                ) {
                    gameEngine.touched = 1
                } else if (gameEngine.touched_x > (gameEngine.pauseButton.x - gameEngine.pauseButton.w)
                    && gameEngine.touched_x < (gameEngine.pauseButton.x + gameEngine.pauseButton.w)
                    && gameEngine.touched_y < (gameEngine.pauseButton.y + gameEngine.pauseButton.h)
                    && gameEngine.touched_y > (gameEngine.pauseButton.y - gameEngine.pauseButton.h)
                ) {
                    if (!dialog.isShowing) {
                        dialog.show()
                    }
                } else {
                    gameEngine.touched = 2
                }
            MotionEvent.ACTION_MOVE ->
                if (gameEngine.touched_x > (gameEngine.player.x - gameEngine.player.w)
                    && gameEngine.touched_x < (gameEngine.player.x + gameEngine.player.w)
                    && gameEngine.touched_y < (gameEngine.player.y + gameEngine.player.h)
                    && gameEngine.touched_y > (gameEngine.player.y - gameEngine.player.h)
                ) {
                    gameEngine.touched = 1
                } else {
                    gameEngine.touched = 2
                }
            MotionEvent.ACTION_UP -> gameEngine.touched = 0
            MotionEvent.ACTION_CANCEL -> gameEngine.touched = 0
            MotionEvent.ACTION_OUTSIDE -> gameEngine.touched = 0
        }
        return true
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        gameEngine.draw(canvas!!)
    }

    fun resumeThread() {
        pause = false
        surfaceCreated(holder)
    }

    fun pauseThread() {
        pause = true
    }

    fun endThisGame() {
        val lbm = LocalBroadcastManager.getInstance(context)
        val intent = Intent(END_GAME)
        intent.putExtra(MODE_INFINITY, mode)
        val time = gameEngine.gameTime/30
        intent.putExtra(TIME_SURVIVED, time)
        if (gameEngine.player.imageList[0].isRecycled) {
            // PERDER POR MUERTE
            intent.putExtra(END_GAME, 0)
            if (mode) {
                if (time > Data.user.survived!!) {
                    Data.user.survived = time
                } else {
                    intent.putExtra(MODE_INFINITY, false)
                }
            }
        } else {
            if (gameEngine.player.accumulate > gameEngine.scoreLimits[0] && gameEngine.player.accumulate < gameEngine.scoreLimits[1]) {
                // GANAR PUNTUACION
                intent.putExtra(END_GAME, 1)
            } else {
                // PERDER PUNTUACION
                intent.putExtra(END_GAME, 0)
            }
        }
        lbm.sendBroadcast(intent)
    }

}

