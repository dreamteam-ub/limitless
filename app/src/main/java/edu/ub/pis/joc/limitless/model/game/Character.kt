package edu.ub.pis.joc.limitless.model.game

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Rect

open abstract class Character(var image: Bitmap) {
    var x: Int = 0
    var y: Int = 0
    var w: Int = 0
    var h: Int = 0
    var rect = Rect() //hitbox

    private val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    private val screenHeight = Resources.getSystem().displayMetrics.heightPixels

    init {
        //medida imagen
        w = image.width
        h = image.height

        //posicion inicial
        x = screenWidth/3
        y = screenHeight/3


    }

    /**
     * Draws the object on to the canvas.
     */
    fun draw(canvas: Canvas) {
        canvas.drawBitmap(image, x.toFloat(), y.toFloat(), null)
    }


    //getters of screen width and height

    fun getScreenWidth() : Int {
        return screenWidth
    }

    fun getScreenHeight() : Int {
        return screenHeight
    }



}