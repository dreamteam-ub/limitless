package edu.ub.pis.joc.limitless.view.gamescreen

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Rect
import edu.ub.pis.joc.limitless.view.ViewAdjuster.screenHeight
import edu.ub.pis.joc.limitless.view.ViewAdjuster.screenWidth

class PauseButton(var image: Bitmap) {

    var w = screenWidth * 0.1
    var h = screenHeight * 0.05

    var x = (screenWidth * 0.1).toInt()
    var y = (screenHeight * 0.95).toInt()

    var rect: Rect = Rect() //hitbox

    fun draw(canvas: Canvas) {

        val halfW: Int = (w / 2).toInt()
        val halfH: Int = (h / 2).toInt()
        rect.set(x - halfW, y - halfH, x + halfW, y + halfH)
        canvas.drawBitmap(image, null, rect, null)
    }

}