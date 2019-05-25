package edu.ub.pis.joc.limitless.model.game

import android.graphics.*
import edu.ub.pis.joc.limitless.view.HEIGHT_REFERENCE
import edu.ub.pis.joc.limitless.view.ViewAdjuster
import edu.ub.pis.joc.limitless.view.ViewAdjuster.screenHeight
import edu.ub.pis.joc.limitless.view.ViewAdjuster.screenWidth
import edu.ub.pis.joc.limitless.view.WIDTH_REFERENCE

class Coin(image: ArrayList<Bitmap>, posX: Int, posY: Int) : Character(image, posX, posY), ObjectsInGameInterface {

    override var w: Int = (screenWidth * 0.005555).toInt()
    override var h: Int = (screenHeight * 0.002958).toInt()

    val paint = Paint()

    var value: Int = 0

    override var dissapearTimer: Int = 0

    var activeCoin: Boolean = false
    private var firstDraw: Boolean = true
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

        if (firstDraw) {
            if (contador <= 2) {
                //Empieza a crecer
                w = (screenWidth * 0.005555).toInt()
                h = (screenHeight * 0.002958).toInt()
                canvas.drawBitmap(imageList[0], null, rect, null)
            } else if (contador <= 4) {
                w = (screenWidth * 0.011111).toInt()
                h = (screenHeight * 0.0059171).toInt()
                canvas.drawBitmap(imageList[1], null, rect, null)
            } else if (contador <= 6) {
                w = (screenWidth * 0.023148).toInt()
                h = (screenHeight * 0.012327).toInt()
                canvas.drawBitmap(imageList[2], null, rect, null)
            } else if (contador <= 8) {
                w = (screenWidth * 0.034259).toInt()
                h = (screenHeight * 0.018244).toInt()
                canvas.drawBitmap(imageList[3], null, rect, null)
            } else if (contador <= 10) {
                w = (screenWidth * 0.046296).toInt()
                h = (screenHeight * 0.027120).toInt()
                canvas.drawBitmap(imageList[4], null, rect, null)
            } else if (contador <= 12) {
                w = (screenWidth * 0.057407).toInt()
                h = (screenHeight * 0.030571).toInt()
                canvas.drawBitmap(imageList[5], null, rect, null)
            } else if (contador <= 14) {
                //Moneda normal
                w = (screenWidth * 0.069444).toInt()
                h = (screenHeight * 0.0369822).toInt()
                canvas.drawBitmap(imageList[6], null, rect, null)
            } else if (contador <= 16) {
                //Empieza a girar
                w = (screenWidth * 0.060185).toInt()
                h = (screenHeight * 0.0369822).toInt()
                canvas.drawBitmap(imageList[7], null, rect, null)
            } else if (contador <= 18) {
                w = (screenWidth * 0.050925).toInt()
                h = (screenHeight * 0.0369822).toInt()
                canvas.drawBitmap(imageList[8], null, rect, null)
            } else if (contador <= 20) {
                w = (screenWidth * 0.041666).toInt()
                h = (screenHeight * 0.0369822).toInt()
                canvas.drawBitmap(imageList[9], null, rect, null)
            } else if (contador <= 22) {
                w = (screenWidth * 0.025925).toInt()
                h = (screenHeight * 0.0369822).toInt()
                canvas.drawBitmap(imageList[10], null, rect, null)
            } else if (contador <= 24) {
                w = (screenWidth * 0.0046296).toInt()
                h = (screenHeight * 0.0369822).toInt()
                canvas.drawBitmap(imageList[11], null, rect, null)
            } else if (contador <= 26) {
                w = (screenWidth * 0.025925).toInt()
                h = (screenHeight * 0.0369822).toInt()
                canvas.drawBitmap(imageList[12], null, rect, null)
            } else if (contador <= 28) {
                w = (screenWidth * 0.041666).toInt()
                h = (screenHeight * 0.0369822).toInt()
                canvas.drawBitmap(imageList[13], null, rect, null)
            } else if (contador <= 30) {
                w = (screenWidth * 0.050925).toInt()
                h = (screenHeight * 0.0369822).toInt()
                canvas.drawBitmap(imageList[14], null, rect, null)
            } else if (contador <= 32) {
                w = (screenWidth * 0.060185).toInt()
                h = (screenHeight * 0.0369822).toInt()
                canvas.drawBitmap(imageList[15], null, rect, null)
            } else if (contador <= 34) {
                w = (screenWidth * 0.050925).toInt()
                h = (screenHeight * 0.0369822).toInt()
                canvas.drawBitmap(imageList[14], null, rect, null)
            } else if (contador <= 36) {
                w = (screenWidth * 0.041666).toInt()
                h = (screenHeight * 0.0369822).toInt()
                canvas.drawBitmap(imageList[13], null, rect, null)
            } else if (contador <= 38) {
                w = (screenWidth * 0.025925).toInt()
                h = (screenHeight * 0.0369822).toInt()
                canvas.drawBitmap(imageList[12], null, rect, null)
            } else if (contador <= 40) {
                w = (screenWidth * 0.0046296).toInt()
                h = (screenHeight * 0.0369822).toInt()
                canvas.drawBitmap(imageList[11], null, rect, null)
            } else if (contador <= 42) {
                w = (screenWidth * 0.025925).toInt()
                h = (screenHeight * 0.0369822).toInt()
                canvas.drawBitmap(imageList[10], null, rect, null)
            } else if (contador <= 44) {
                w = (screenWidth * 0.041666).toInt()
                h = (screenHeight * 0.0369822).toInt()
                canvas.drawBitmap(imageList[9], null, rect, null)
            } else if (contador <= 46) {
                w = (screenWidth * 0.050925).toInt()
                h = (screenHeight * 0.0369822).toInt()
                canvas.drawBitmap(imageList[8], null, rect, null)
            } else if (contador <= 48) {
                w = (screenWidth * 0.065185).toInt()
                h = (screenHeight * 0.0369822).toInt()
                canvas.drawBitmap(imageList[7], null, rect, null)
            }
            contador = (contador + 1)
            if (contador == 49) {
                firstDraw = false
                contador = 0
                activeCoin = true
            }
        } else {
            canvas.drawBitmap(imageList[6], null, rect, null)

            if (value.toString().length == 1 && value >= 0) { //positius 1 xifra
                paint.textSize = (ViewAdjuster.screenHeight * 60.0f) / HEIGHT_REFERENCE
                canvas.drawText(
                    value.toString(),
                    x.toFloat() - (ViewAdjuster.screenWidth * 15f) / WIDTH_REFERENCE,
                    y.toFloat() + (ViewAdjuster.screenHeight * 12f) / HEIGHT_REFERENCE,
                    paint
                )
            } else if (value.toString().length == 2 && value < 0) { //negatius 1 xifra
                paint.textSize = (ViewAdjuster.screenWidth * 60.0f) / WIDTH_REFERENCE
                paint.color = Color.WHITE
                canvas.drawText(
                    value.toString(),
                    x.toFloat() - (ViewAdjuster.screenWidth * 25f) / WIDTH_REFERENCE,
                    y.toFloat() + (ViewAdjuster.screenHeight * 12f) / HEIGHT_REFERENCE,
                    paint
                )
            } else if (value.toString().length == 2 && value > 0) { //positius 2 xifres
                paint.textSize = (ViewAdjuster.screenWidth * 60.0f) / WIDTH_REFERENCE
                canvas.drawText(
                    value.toString(),
                    x.toFloat() - (ViewAdjuster.screenWidth * 20f) / WIDTH_REFERENCE,
                    y.toFloat() + (ViewAdjuster.screenHeight * 12f) / HEIGHT_REFERENCE,
                    paint
                )
            } else if (value.toString().length == 3 && value < 0) { //negatius 2 xifres
                paint.textSize = (ViewAdjuster.screenWidth * 55.0f) / WIDTH_REFERENCE
                paint.color = Color.WHITE
                canvas.drawText(
                    value.toString(),
                    x.toFloat() - (ViewAdjuster.screenWidth * 33f) / WIDTH_REFERENCE,
                    y.toFloat() + (ViewAdjuster.screenHeight * 12f) / HEIGHT_REFERENCE,
                    paint
                )
            }
        }
    }
}