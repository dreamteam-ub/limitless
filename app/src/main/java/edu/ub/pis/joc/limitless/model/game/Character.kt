package edu.ub.pis.joc.limitless.model.game

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Rect

abstract class Character(var image: Bitmap) {

    private val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    private val screenHeight = Resources.getSystem().displayMetrics.heightPixels

    //posicion inicial
    open var x: Int = screenWidth / 3
    open var y: Int = screenHeight/ 3

    //medida imagen
    open var w: Int = image.width / 2
    open var h: Int = image.height / 2

    var rect: Rect = Rect() //hitbox

    /**
     * Draws the object on to the canvas.
     */
    fun draw(canvas: Canvas) {
        //vamos a hacer nosotros mismos las coordenadas left,top,right y bottom para meterlas en
        //el hitbox
        val halfW: Int = w / 2
        val halfH: Int = h / 2
        rect.set(x - halfW, y - halfH, x + halfW, y + halfH)
        canvas.drawBitmap(image, null, rect, null)
    }




    //getters of screen width and height

    fun getScreenWidth(): Int {
        return screenWidth
    }

    fun getScreenHeight(): Int {
        return screenHeight
    }



}