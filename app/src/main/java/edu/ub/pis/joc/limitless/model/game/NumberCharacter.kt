package edu.ub.pis.joc.limitless.model.game

import android.graphics.*

class NumberCharacter(image: ArrayList<Bitmap>, posX: Int, posY: Int, var value: Int, font : Typeface) : Character(image, posX, posY), ObjectsInGameInterface {

    override var h = image[0].height / 10
    override var w = image[0].width / 10

    private val paint = Paint()

    init {
        paint.color = Color.WHITE
        paint.style = Paint.Style.FILL
        paint.textSize = 40.0f
        paint.typeface = font
    }

    override fun update() {

    }

    override fun isTaken() {
        imageList[0].recycle()
    }

    override fun draw(canvas: Canvas) {
        val halfW: Int = w / 2
        val halfH: Int = h / 2
        rect.set(x - halfW, y - halfH, x + halfW, y + halfH)

        canvas.drawBitmap(imageList[0], null, rect, null)
        canvas.drawText(value.toString(), x.toFloat() - 20f, y.toFloat() + 10f, paint)
    }
}