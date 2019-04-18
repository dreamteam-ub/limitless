package edu.ub.pis.joc.limitless.model.game

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Rect

class InGameBorder (var image: Bitmap){

    var xPixels = Resources.getSystem().displayMetrics.widthPixels
    var yPixels = Resources.getSystem().displayMetrics.heightPixels

    var w = xPixels*0.8
    var h = yPixels*0.8

    var x = xPixels/2
    var y = yPixels/2

    var rect: Rect = Rect() //hitbox

    fun draw(canvas: Canvas) {

        val halfW: Int = (w/2).toInt()
        val halfH: Int = (h/2).toInt()
        rect.set(x - halfW, y - halfH, x + halfW, y + halfH)
        canvas.drawBitmap(image, null, rect, null)
    }

}