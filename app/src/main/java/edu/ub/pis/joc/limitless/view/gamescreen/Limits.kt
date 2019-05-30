package edu.ub.pis.joc.limitless.view.gamescreen


import android.content.res.AssetManager
import android.graphics.*
import edu.ub.pis.joc.limitless.engine.FONTS_ASSETS
import edu.ub.pis.joc.limitless.engine.FONT_LIMITS
import edu.ub.pis.joc.limitless.view.ViewAdjuster.screenHeight
import edu.ub.pis.joc.limitless.view.ViewAdjuster.screenWidth
import java.io.File

class Limits(var min: Int, var max: Int, assets: AssetManager) {

    val paint = Paint()

    var w = screenWidth
    var h = screenHeight * 0.1

    var x = (screenWidth * 0.5).toInt()
    var y = (screenHeight * 0.1).toInt()

    var rect: Rect = Rect() //hitbox

    init {
        paint.color = Color.WHITE
        //paint.style = Paint.Style.FILL
        paint.textSize = (screenHeight * 0.030f)
        paint.typeface = Typeface.createFromAsset(assets, FONTS_ASSETS + File.separator + FONT_LIMITS)
    }


    fun draw(canvas: Canvas) {
        val halfW: Int = (w / 2).toInt()
        val halfH: Int = (h / 2).toInt()
        rect.set(x - halfW, y - halfH, x + halfW, y + halfH)
        val texto = "MIN: $min  MAX: $max"
        canvas.drawText(texto, 0f + (screenWidth / 2) - (paint.measureText(texto) / 2), h.toFloat() / 1.5f, paint)
    }
}