package edu.ub.pis.joc.limitless.view

import android.app.Dialog
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.widget.ImageButton
import android.widget.Toast
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.engine.GameEngine
import kotlinx.android.synthetic.main.game_pause_dialog.view.*
import kotlin.concurrent.withLock


class GameView(context: Context, nivell: Int) : SurfaceView(context), SurfaceHolder.Callback {
    private val thread: GameThread
    private val gameEngine: GameEngine
    var pause : Boolean = false
    lateinit var dialog: Dialog

    init {
        // add callback
        holder.addCallback(this)
        gameEngine = GameEngine(context, nivell)
        // instantiate the game thread
        thread = GameThread(holder, this, gameEngine)




    }


    override fun surfaceCreated(surfaceHolder: SurfaceHolder) {
        // start the game thread
        thread.setRunning(true)
        thread.start()
        dialog = Dialog(context)
        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val vista = layoutInflater.inflate(R.layout.game_pause_dialog, null)
        dialog.setContentView(vista)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val resumeDiag : ImageButton = vista.findViewById(R.id.resumeButtonDiag)
        val worldsDiag : ImageButton = vista.findViewById(R.id.worldsButtonPauseDiag)
        val menuDiag : ImageButton = vista.findViewById(R.id.menuButtonPauseDiag)

        resumeDiag.setOnClickListener {
            pause=false
            resumeThread()
            dialog.dismiss()
        }
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

        when (event.action) {
            MotionEvent.ACTION_DOWN ->
                if (gameEngine.touched_x > (gameEngine.getPlayer().x - gameEngine.getPlayer().w)
                    && gameEngine.touched_x < (gameEngine.getPlayer().x + gameEngine.getPlayer().w)
                    && gameEngine.touched_y < (gameEngine.getPlayer().y + gameEngine.getPlayer().h)
                    && gameEngine.touched_y > (gameEngine.getPlayer().y - gameEngine.getPlayer().h)
                ) {
                    gameEngine.touched = 1
                }

                else if (gameEngine.touched_x > (gameEngine.pauseButton!!.x - gameEngine.pauseButton!!.w)
                && gameEngine.touched_x < (gameEngine.pauseButton!!.x + gameEngine.pauseButton!!.w)
                && gameEngine.touched_y < (gameEngine.pauseButton!!.y + gameEngine.pauseButton!!.h)
                && gameEngine.touched_y > (gameEngine.pauseButton!!.y - gameEngine.pauseButton!!.h)
                ){

                    if(!dialog.isShowing){
                        dialog.show()
                        pause=true
                    }



                }else {
                    gameEngine.touched = 2
                }
            MotionEvent.ACTION_MOVE ->
                if (gameEngine.touched_x > (gameEngine.getPlayer().x - gameEngine.getPlayer().w)
                && gameEngine.touched_x < (gameEngine.getPlayer().x + gameEngine.getPlayer().w)
                && gameEngine.touched_y < (gameEngine.getPlayer().y + gameEngine.getPlayer().h)
                && gameEngine.touched_y > (gameEngine.getPlayer().y - gameEngine.getPlayer().h)
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

    fun resumeThread(){
        thread.lock.withLock {
            if (!pause){
                thread.condition.signalAll()
            }
        }
    }



}

