package edu.ub.pis.joc.limitless.model.game

import android.graphics.*
import edu.ub.pis.joc.limitless.view.HEIGHT_REFERENCE
import edu.ub.pis.joc.limitless.view.ViewAdjuster
import edu.ub.pis.joc.limitless.view.ViewAdjuster.screenHeight
import edu.ub.pis.joc.limitless.view.ViewAdjuster.screenWidth
import edu.ub.pis.joc.limitless.view.WIDTH_REFERENCE

class Coin(image: ArrayList<Bitmap>, posX: Int, posY: Int) : Character(image, posX, posY), ObjectsInGameInterface {

    override var w: Int = CharacterData.wCoin[0]
    override var h: Int = CharacterData.hCoin[0]

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
                w = CharacterData.wCoin[0]
                h = CharacterData.hCoin[0]
                canvas.drawBitmap(imageList[0], null, rect, null)
            } else if (contador <= 4) {
                w = CharacterData.wCoin[1]
                h = CharacterData.hCoin[1]
                canvas.drawBitmap(imageList[1], null, rect, null)
            } else if (contador <= 6) {
                w = CharacterData.wCoin[2]
                h = CharacterData.hCoin[2]
                canvas.drawBitmap(imageList[2], null, rect, null)
            } else if (contador <= 8) {
                w = CharacterData.wCoin[3]
                h = CharacterData.hCoin[3]
                canvas.drawBitmap(imageList[3], null, rect, null)
            } else if (contador <= 10) {
                w = CharacterData.wCoin[4]
                h = CharacterData.hCoin[4]
                canvas.drawBitmap(imageList[4], null, rect, null)
            } else if (contador <= 12) {
                w = CharacterData.wCoin[5]
                h = CharacterData.hCoin[5]
                canvas.drawBitmap(imageList[5], null, rect, null)
            } else if (contador <= 14) {
                //Moneda normal
                w = CharacterData.wCoin[6]
                h = CharacterData.hCoin[6]
                canvas.drawBitmap(imageList[6], null, rect, null)
            } else if (contador <= 16) {
                //Empieza a girar
                w = CharacterData.wCoin[7]
                h = CharacterData.hCoin[6]
                canvas.drawBitmap(imageList[7], null, rect, null)
            } else if (contador <= 18) {
                w = CharacterData.wCoin[8]
                h = CharacterData.hCoin[6]
                canvas.drawBitmap(imageList[8], null, rect, null)
            } else if (contador <= 20) {
                w = CharacterData.wCoin[9]
                h = CharacterData.hCoin[6]
                canvas.drawBitmap(imageList[9], null, rect, null)
            } else if (contador <= 22) {
                w = CharacterData.wCoin[10]
                h = CharacterData.hCoin[6]
                canvas.drawBitmap(imageList[10], null, rect, null)
            } else if (contador <= 24) {
                w = CharacterData.wCoin[4]
                h = CharacterData.hCoin[6]
                canvas.drawBitmap(imageList[11], null, rect, null)
            } else if (contador <= 26) {
                w = CharacterData.wCoin[10]
                h = CharacterData.hCoin[6]
                canvas.drawBitmap(imageList[12], null, rect, null)
            } else if (contador <= 28) {
                w = CharacterData.wCoin[9]
                h = CharacterData.hCoin[6]
                canvas.drawBitmap(imageList[13], null, rect, null)
            } else if (contador <= 30) {
                w = CharacterData.wCoin[8]
                h = CharacterData.hCoin[6]
                canvas.drawBitmap(imageList[14], null, rect, null)
            } else if (contador <= 32) {
                w = CharacterData.wCoin[7]
                h = CharacterData.hCoin[6]
                canvas.drawBitmap(imageList[15], null, rect, null)
            } else if (contador <= 34) {
                w = CharacterData.wCoin[8]
                h = CharacterData.hCoin[6]
                canvas.drawBitmap(imageList[14], null, rect, null)
            } else if (contador <= 36) {
                w = CharacterData.wCoin[9]
                h = CharacterData.hCoin[6]
                canvas.drawBitmap(imageList[13], null, rect, null)
            } else if (contador <= 38) {
                w = CharacterData.wCoin[10]
                h = CharacterData.hCoin[6]
                canvas.drawBitmap(imageList[12], null, rect, null)
            } else if (contador <= 40) {
                w = CharacterData.wCoin[11]
                h = CharacterData.hCoin[6]
                canvas.drawBitmap(imageList[11], null, rect, null)
            } else if (contador <= 42) {
                w = CharacterData.wCoin[10]
                h = CharacterData.hCoin[6]
                canvas.drawBitmap(imageList[10], null, rect, null)
            } else if (contador <= 44) {
                w = CharacterData.wCoin[9]
                h = CharacterData.hCoin[6]
                canvas.drawBitmap(imageList[9], null, rect, null)
            } else if (contador <= 46) {
                w = CharacterData.wCoin[8]
                h = CharacterData.hCoin[6]
                canvas.drawBitmap(imageList[8], null, rect, null)
            } else if (contador <= 48) {
                w = CharacterData.wCoin[12]
                h = CharacterData.hCoin[6]
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