package edu.ub.pis.joc.limitless.view

import android.content.Context
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.util.Log
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.widget.Toast
import edu.ub.pis.joc.limitless.R

import edu.ub.pis.joc.limitless.model.game.PlayerCharacter


class GameView(context: Context) : SurfaceView(context), SurfaceHolder.Callback {
    private val thread: GameThread
    private var personatge : PlayerCharacter? = null
    //Tamaño pantalla
    private val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    private val screenHeight = Resources.getSystem().displayMetrics.heightPixels


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
        //Character tendra un Rectangulo, le asginaremos los bounds aqui
        personatge!!.rect.set(resources.getDrawable(R.drawable.won_heart).bounds)



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


    }


    /**
     * Everything that has to be drawn on Canvas
     */
    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        personatge!!.draw(canvas)
    }

    private var oldX: Float = 0.toFloat()
    private var oldY: Float = 0.toFloat()


    //ontouch per a moure el character

    //falta que no surti dels limits de la pantalla
    //falta que l'objecte pugui arrosegar-se bé i des del centre del bitmap

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                oldX = event.x
                oldY = event.y

            }

            MotionEvent.ACTION_MOVE -> {

                val newX = event.x
                val newY = event.y

                //if (personatge!!.rect.contains(oldX.toInt(),oldY.toInt())) {
                //comprovar si anteriorment estava a aquesta posició

                    personatge!!.update(newX.toInt(), newY.toInt())

                    oldX = newX
                    oldY = newY


            }
        }

        return true
    }



}

