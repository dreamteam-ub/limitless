package edu.ub.pis.joc.limitless.model.game

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Rect
import android.util.Log
import android.widget.Toast

abstract class Character(var image: Bitmap) {

    var x: Int = 0
    var y: Int = 0
    var w: Int = 0
    var h: Int = 0

    var rect : Rect? = null //hitbox

    private val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    private val screenHeight = Resources.getSystem().displayMetrics.heightPixels

    init {
        //medida imagen

        w = image.width/2
        h = image.height/2

        //posicion inicial
        x = screenWidth/3
        y = screenHeight/3

        rect = Rect()




    }

    /**
     * Draws the object on to the canvas.
     */
    fun draw(canvas: Canvas) {
        //vamos a hacer nosotros mismos las coordenadas left,top,right y bottom para meterlas en
        //el hitbox
        var halfW : Int = w/2
        var halfH : Int = h/2
        rect!!.set(x-halfW,y-halfH,x+halfW,y+halfH)
        canvas.drawBitmap(image, null, rect, null)
    }


    //getters of screen width and height

    fun getScreenWidth() : Int {
        return screenWidth
    }

    fun getScreenHeight() : Int {
        return screenHeight
    }

    fun characterHitsPlayer(playerCharacter: PlayerCharacter){

        if (this.rect!!.intersect(playerCharacter.rect)){

            playerCharacter.die()

        }


    }


}