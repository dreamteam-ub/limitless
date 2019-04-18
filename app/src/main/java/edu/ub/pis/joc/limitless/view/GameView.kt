package edu.ub.pis.joc.limitless.view

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.widget.ImageView
import android.widget.Toast
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.engine.GameEngine
import edu.ub.pis.joc.limitless.model.game.*


class GameView(context: Context, nivell:Int) : SurfaceView(context), SurfaceHolder.Callback {
    private val thread: GameThread
    //private var characterFactory : CharacterFactory? = null
    private val gameEngine : GameEngine


    init {
        // add callback
        holder.addCallback(this)
        gameEngine= GameEngine(context,nivell)
        // instantiate the game thread
        thread = GameThread(holder,this, gameEngine)
        //characterFactory=CharacterFactory(context)

    }


    override fun surfaceCreated(surfaceHolder: SurfaceHolder) {

        // start the game thread
        thread.setRunning(true)
        thread.start()
    }

    override fun surfaceChanged(surfaceHolder: SurfaceHolder, i: Int, i1: Int, i2: Int) {

    }

    override fun surfaceDestroyed(surfaceHolder: SurfaceHolder) {
        var retry = true
        while (retry) {
            try {
                thread.setRunning(false)
                thread.join()
            } catch (e: Exception) {
                e.printStackTrace()
            }

            retry = false
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        gameEngine.touched_x = event.x.toInt()
        gameEngine.touched_y = event.y.toInt()

        val action = event.action
        when (action) {
            MotionEvent.ACTION_DOWN->
                if (gameEngine.touched_x > (gameEngine.getPlayer().x - gameEngine.getPlayer().w) && gameEngine.touched_x < (gameEngine.getPlayer().x + gameEngine.getPlayer().w)
                    && gameEngine.touched_y < (gameEngine.getPlayer().y + gameEngine.getPlayer().h) && gameEngine.touched_y > (gameEngine.getPlayer().y - gameEngine.getPlayer().h)) {
                    gameEngine.touched= 1
                } else {
                    gameEngine.touched = 2
                }
            MotionEvent.ACTION_MOVE -> if (gameEngine.touched_x > (gameEngine.getPlayer().x - gameEngine.getPlayer().w) && gameEngine.touched_x < (gameEngine.getPlayer().x + gameEngine.getPlayer().w)
                && gameEngine.touched_y < (gameEngine.getPlayer().y + gameEngine.getPlayer().h) && gameEngine.touched_y > (gameEngine.getPlayer().y - gameEngine.getPlayer().h)) {
                gameEngine.touched= 1
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

}

