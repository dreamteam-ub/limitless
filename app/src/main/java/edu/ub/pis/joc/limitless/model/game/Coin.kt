package edu.ub.pis.joc.limitless.model.game

import android.graphics.*

class Coin(image: ArrayList<Bitmap>, posX: Int, posY: Int) : Character(image, posX, posY), ObjectsInGameInterface {

    val paint = Paint()

    var value: Int = 0

    override var dissapearTimer : Int = 0

    var activeCoin: Boolean = false
    private var firstDraw : Boolean = true
    var contador: Int = 0

    init {
        paint.color = Color.YELLOW
        paint.style = Paint.Style.FILL
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

        if(firstDraw){
            if (contador <= 2) {
                w = imageList[0].width
                h = imageList[0].height
                canvas.drawBitmap(imageList[0], null, rect, null)
            } else if (contador <= 4) {
                w = imageList[1].width
                h = imageList[1].height
                canvas.drawBitmap(imageList[1], null, rect, null)
            }else if (contador <= 6) {
                w = imageList[2].width
                h = imageList[2].height
                canvas.drawBitmap(imageList[2], null, rect, null)
            }else if (contador <= 8) {
                w = imageList[3].width
                h = imageList[3].height
                canvas.drawBitmap(imageList[3], null, rect, null)
            }else if (contador <= 10) {
                w = imageList[4].width
                h = imageList[4].height
                canvas.drawBitmap(imageList[4], null, rect, null)
            }else if (contador <= 12) {
                w = imageList[5].width
                h = imageList[5].height
                canvas.drawBitmap(imageList[5], null, rect, null)
            } else if (contador <= 14) {
                w = imageList[6].width
                h = imageList[6].height
                canvas.drawBitmap(imageList[6], null, rect, null)
            } else if (contador <= 16) {
                w = imageList[7].width
                h = imageList[7].height
                canvas.drawBitmap(imageList[7], null, rect, null)
            } else if (contador <= 18) {
                w = imageList[8].width
                h = imageList[8].height
                canvas.drawBitmap(imageList[8], null, rect, null)
            } else if (contador <= 20) {
                w = imageList[9].width
                h = imageList[9].height
                canvas.drawBitmap(imageList[9], null, rect, null)
            } else if (contador <= 22) {
                w = imageList[10].width
                h = imageList[10].height
                canvas.drawBitmap(imageList[10], null, rect, null)
            } else if (contador <= 24) {
                w = imageList[11].width
                h = imageList[11].height
                canvas.drawBitmap(imageList[11], null, rect, null)
            } else if (contador <= 26) {
                w = imageList[12].width
                h = imageList[12].height
                canvas.drawBitmap(imageList[12], null, rect, null)
            } else if (contador <= 28) {
                w = imageList[13].width
                h = imageList[13].height
                canvas.drawBitmap(imageList[13], null, rect, null)
            } else if (contador <= 30) {
                w = imageList[14].width
                h = imageList[14].height
                canvas.drawBitmap(imageList[14], null, rect, null)
            } else if (contador <= 32) {
                w = imageList[15].width
                h = imageList[15].height
                canvas.drawBitmap(imageList[15], null, rect, null)
            } else if (contador <= 34) {
                w = imageList[14].width
                h = imageList[14].height
                canvas.drawBitmap(imageList[14], null, rect, null)
            } else if (contador <= 36) {
                w = imageList[13].width
                h = imageList[13].height
                canvas.drawBitmap(imageList[13], null, rect, null)
            }else if (contador <= 38) {
                w = imageList[12].width
                h = imageList[12].height
                canvas.drawBitmap(imageList[12], null, rect, null)
            } else if (contador <= 40) {
                w = imageList[11].width
                h = imageList[11].height
                canvas.drawBitmap(imageList[11], null, rect, null)
            } else if (contador <= 42) {
                w = imageList[10].width
                h = imageList[10].height
                canvas.drawBitmap(imageList[10], null, rect, null)
            } else if (contador <= 44) {
                w = imageList[9].width
                h = imageList[9].height
                canvas.drawBitmap(imageList[9], null, rect, null)
            } else if (contador <= 46) {
                w = imageList[8].width
                h = imageList[8].height
                canvas.drawBitmap(imageList[8], null, rect, null)
            }else if (contador <= 48) {
                w = imageList[7].width
                h = imageList[7].height
                canvas.drawBitmap(imageList[7], null, rect, null)
            }
            contador = (contador+1)
            if(contador == 49){
                firstDraw = false
                contador = 0
                activeCoin=true
            }
        } else {
            canvas.drawBitmap(imageList[6], null, rect, null)

            if (value.toString().length == 1 && value >= 0) { //positius 1 xifra
                paint.textSize = 60.0f
                canvas.drawText(value.toString(), x.toFloat() - 15f, y.toFloat() + 12f, paint)
            } else if (value.toString().length == 2 && value < 0) { //negatius 1 xifra
                paint.textSize = 60.0f
                paint.color = Color.WHITE
                canvas.drawText(value.toString(), x.toFloat() - 25f, y.toFloat() + 12f, paint)
            } else if (value.toString().length == 2 && value > 0) { //positius 2 xifres
                paint.textSize = 60.0f
                canvas.drawText(value.toString(), x.toFloat() - 20f, y.toFloat() + 12f, paint)
            } else if (value.toString().length == 3 && value < 0) { //negatius 2 xifres
                paint.textSize = 55.0f
                paint.color = Color.WHITE
                canvas.drawText(value.toString(), x.toFloat() - 33f, y.toFloat() + 12f, paint)
            }
        }
    }
}