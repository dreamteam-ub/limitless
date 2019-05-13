package edu.ub.pis.joc.limitless.model.game

import android.graphics.*

class Coin(image: ArrayList<Bitmap>, posX: Int, posY: Int) : Character(image, posX, posY), ObjectsInGameInterface {

    override var h = image[0].height
    override var w = image[0].width

    val paint = Paint()

    var value: Int = 0

    override var dissapearTimer : Int = 0

    init {
        paint.color = Color.YELLOW
        paint.style = Paint.Style.FILL
        paint.textSize = 60.0f
        paint.typeface = Typeface.DEFAULT
    }

    override fun update() {
        dissapearTimer--
        if (dissapearTimer <= 65) {
            if (dissapearTimer >= 65) {
                y = y - 7
            } else if (dissapearTimer >= 62) {
                y = y - 7
            } else if (dissapearTimer >= 59) {
                y = y - 7
            } else if (dissapearTimer >= 56) {
                y = y + 7
            } else if (dissapearTimer >= 53) {
                y = y + 7
            } else if (dissapearTimer >= 50) {
                y = y + 7
            }
        }
    }


    override fun draw(canvas: Canvas) {

        val halfW: Int = w / 2
        val halfH: Int = h / 2
        rect.set(x - halfW, y - halfH, x + halfW, y + halfH)

        canvas.drawBitmap(imageList[0], null, rect, null)
        if (value.toString().length == 1 && value >= 0) { //positius 1 xifra
            canvas.drawText(value.toString(), x.toFloat() - 15f, y.toFloat() + 12f, paint)
        }else if (value.toString().length == 2 && value < 0){ //negatius 1 xifra
            paint.color = Color.WHITE
            canvas.drawText(value.toString(), x.toFloat() - 30f, y.toFloat() + 12f, paint)
        }else if (value.toString().length == 2 && value > 0){ //positius 2 xifres
            canvas.drawText(value.toString(), x.toFloat() - 18f, y.toFloat() + 12f, paint)
        }else if (value.toString().length == 3 && value < 0){ //negatius 2 xifres
            paint.color = Color.WHITE
            canvas.drawText(value.toString(), x.toFloat() - 30f, y.toFloat() + 12f, paint)
        }
    }
}