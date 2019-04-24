package edu.ub.pis.joc.limitless.view.GameScreen

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Rect

class PauseButton(var image : Bitmap) {

    var xPixels = Resources.getSystem().displayMetrics.widthPixels
    var yPixels = Resources.getSystem().displayMetrics.heightPixels

    var w = xPixels*0.1
    var h = yPixels*0.05

    var x = (xPixels*0.1).toInt()
    var y = (yPixels*0.99).toInt()

    var rect: Rect = Rect() //hitbox

    fun draw(canvas: Canvas) {

        val halfW: Int = (w/2).toInt()
        val halfH: Int = (h/2).toInt()
        rect.set(x - halfW, y - halfH, x + halfW, y + halfH)
        canvas.drawBitmap(image, null, rect, null)
    }

}