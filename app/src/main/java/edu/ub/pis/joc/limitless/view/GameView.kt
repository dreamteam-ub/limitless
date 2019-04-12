package edu.ub.pis.joc.limitless.view

import android.content.Context
import android.content.res.Resources
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
        personatge!!.rect.set(100,100,100,100)



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

        //skull!!.update()


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

                    /* amb aixó farem que no es faci teletansport (a arreglar)
                    if (event.x >= personatge!!.x && event.x < (personatge!!.x + personatge!!.w)
                        && event.y >= personatge!!.x && event.y < (personatge!!.x + personatge!!.h)) {



                    }
                    */

                }


                MotionEvent.ACTION_MOVE -> {

                    val newX = event.x
                    val newY = event.y

                    personatge!!.update(newX.toInt(), newY.toInt())



                    oldX = newX
                    oldY = newY



                }




        }
        

        return true
    }



}

