package edu.ub.pis.joc.limitless.view

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.widget.Toast
import edu.ub.pis.joc.limitless.R

import edu.ub.pis.joc.limitless.model.game.PlayerCharacter
import edu.ub.pis.joc.limitless.model.game.Skull


class GameView(context: Context) : SurfaceView(context), SurfaceHolder.Callback {
    private val thread: GameThread
    private var personatge : PlayerCharacter? = null
    private var skull : Skull? = null

    init {
        // add callback
        holder.addCallback(this)

        // instantiate the game thread
        thread = GameThread(holder, this)
    }


    override fun surfaceCreated(surfaceHolder: SurfaceHolder) {

        personatge = PlayerCharacter(
            BitmapFactory.decodeResource(
                resources,
                R.drawable.won_heart
            )
        )

        skull = Skull(
            BitmapFactory.decodeResource(
                resources,
                R.drawable.world4_select
            )
        )



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

    /**
     * Function to update the positions of game objects
    */
    fun update() {

        skull!!.update()
        if (touched){
            personatge!!.update(touched_x, touched_y)

        }
        skull!!.characterHitsPlayer(personatge!!)



    }


    /**
     * Everything that has to be drawn on Canvas
     */
    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        skull!!.draw(canvas)
        personatge!!.draw(canvas)
    }



    var touched_x = 0
    var touched_y =0
    var touched = false

    override fun onTouchEvent(event: MotionEvent): Boolean {

        touched_x = event.x.toInt()
        touched_y = event.y.toInt()

        val action = event.action
        when (action) {
            MotionEvent.ACTION_DOWN->
                if (touched_x > (personatge!!.x - personatge!!.w) && touched_x < (personatge!!.x + personatge!!.w)
                    && touched_y < (personatge!!.y + personatge!!.h) && touched_y > (personatge!!.y - personatge!!.h)) {
                    touched=true
                }
            MotionEvent.ACTION_MOVE -> if (touched_x > (personatge!!.x - personatge!!.w) && touched_x < (personatge!!.x + personatge!!.w)
                && touched_y < (personatge!!.y + personatge!!.h) && touched_y > (personatge!!.y - personatge!!.h)) {
                touched=true
            }
            MotionEvent.ACTION_UP -> touched = false
            MotionEvent.ACTION_CANCEL -> touched = false
            MotionEvent.ACTION_OUTSIDE -> touched = false

        }


        return touched
    }





}

