package edu.ub.pis.joc.limitless.view.gamescreen


import android.content.res.AssetManager
import android.graphics.*
import edu.ub.pis.joc.limitless.engine.FONT_LIMITS
import edu.ub.pis.joc.limitless.model.Data.screenWidth
import edu.ub.pis.joc.limitless.model.Data.screenHeight

class Limits (var min: Int, var max: Int, assets : AssetManager) {

    val paint = Paint()

    var w = screenWidth * 0.5
    var h = screenHeight * 0.1

    var x = (screenWidth * 0.5).toInt()
    var y = (screenHeight * 0.1).toInt()

    var rect: Rect = Rect() //hitbox

    init {
        paint.color = Color.WHITE
        paint.style = Paint.Style.FILL
        paint.textSize = 60.0f
        paint.typeface = Typeface.createFromAsset(assets, FONT_LIMITS)
    }


    fun draw(canvas: Canvas) {
        val halfW: Int = (w / 2).toInt()
        val halfH: Int = (h / 2).toInt()
        rect.set(x - halfW, y - halfH, x + halfW, y + halfH)
        canvas.drawText("MIN: $min  MAX: $max", rect.bottom.toFloat(),rect.top.toFloat()+15f,paint)
    }
}