package edu.ub.pis.joc.limitless.view.gamescreen


import android.content.res.AssetManager
import android.graphics.*
import edu.ub.pis.joc.limitless.engine.FONT_LIMITS
import edu.ub.pis.joc.limitless.view.ViewAdjuster
import edu.ub.pis.joc.limitless.view.ViewAdjuster.screenHeight
import edu.ub.pis.joc.limitless.view.ViewAdjuster.screenWidth

class Limits (var min: Int, var max: Int, assets : AssetManager) {

    val paint = Paint()

    var w = screenWidth
    var h = screenHeight * 0.1

    var x = (screenWidth * 0.5).toInt()
    var y = (screenHeight * 0.1).toInt()

    var rect: Rect = Rect() //hitbox

    init {
        paint.color = Color.WHITE
        paint.style = Paint.Style.FILL
        paint.textSize = (ViewAdjuster.screenHeight * 60.0f) / 2028
        paint.typeface = Typeface.createFromAsset(assets, FONT_LIMITS)
    }


    fun draw(canvas: Canvas) {
        val halfW: Int = (w / 2).toInt()
        val halfH: Int = (h / 2).toInt()
        rect.set(x - halfW, y - halfH, x + halfW, y + halfH)
        canvas.drawText("MIN: $min  MAX: $max", (rect.left.toFloat() + ViewAdjuster.screenWidth/3.5f),rect.top.toFloat()+(ViewAdjuster.screenHeight * 15f)/2028, paint)
    }
}