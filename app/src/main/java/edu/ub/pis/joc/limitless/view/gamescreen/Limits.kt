package edu.ub.pis.joc.limitless.view.gamescreen


import android.graphics.*
import edu.ub.pis.joc.limitless.model.Data.screenWidth
import edu.ub.pis.joc.limitless.model.Data.screenHeight

class Limits (var min: Int, var max: Int ) {

    val paint = Paint()

    var w = screenWidth * 0.1
    var h = screenHeight * 0.05

    var x = (screenWidth * 0.3).toInt()
    var y = (screenHeight * 0.1).toInt()

    var rect: Rect = Rect() //hitbox

    init {
        paint.color = Color.WHITE
        paint.style = Paint.Style.FILL
        paint.textSize = 40.0f
        paint.typeface = Typeface.SERIF
    }


    fun draw(canvas: Canvas) {

        val halfW: Int = (w / 2).toInt()
        val halfH: Int = (h / 2).toInt()
        rect.set(x - halfW, y - halfH, x + halfW, y + halfH)

        canvas.drawText("MIN: " +  min.toString() + "  " + "MAX: " + max.toString(), x.toFloat() - 15f, y.toFloat() - 10f, paint)

    }
}