package edu.ub.pis.joc.limitless.model.game

import android.graphics.*

class Coin(image: ArrayList<Bitmap>, posX: Int, posY: Int) : Character(image, posX, posY), ObjectsInGameInterface {

    override var h = image[0].height
    override var w = image[0].width

    val paint = Paint()

    var value: Int = 0

    override var dissapearTimer : Int = 0

    var activeCoin: Boolean = false
    private var firstDraw : Boolean = true
    var contador: Int = 0

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

        if(firstDraw){
            if (contador <= 3) {
                w = imageList[10].width
                h = imageList[10].height
                //Aparicion 1
                canvas.drawBitmap(imageList[7], null, rect, null)
            } else if (contador <= 6) {
                //Aparicion 2
                canvas.drawBitmap(imageList[8], null, rect, null)
            } else if (contador <= 9) {
                //Aparicion 3
                canvas.drawBitmap(imageList[9], null, rect, null)
            } else if (contador <= 12) {
                //Aparicion 4
                canvas.drawBitmap(imageList[10], null, rect, null)
            } else if (contador <= 15) {
                //Aparicion 2
                canvas.drawBitmap(imageList[7], null, rect, null)
            } else if (contador <= 18) {
                //Aparicion 3
                canvas.drawBitmap(imageList[8], null, rect, null)
            } else if (contador <= 21) {
                //Aparicion 4
                canvas.drawBitmap(imageList[9], null, rect, null)
            } else if (contador <= 24) {
                //Aparicion 5
                canvas.drawBitmap(imageList[10], null, rect, null)
            } else if (contador <= 27) {
                //Aparicion 2
                canvas.drawBitmap(imageList[7], null, rect, null)
            } else if (contador <= 30) {
                //Aparicion 3
                canvas.drawBitmap(imageList[8], null, rect, null)
            } else if (contador <= 33) {
                //Aparicion 4
                canvas.drawBitmap(imageList[9], null, rect, null)
            } else if (contador <= 36) {
                //Aparicion 5
                canvas.drawBitmap(imageList[10], null, rect, null)
            } else if (contador <= 39) {
                w = imageList[0].width/16
                h = imageList[0].height/16
                rect.set(x - w/2, y - h/2, x + w/2, y + h/2)
                //Aparicion 5
                canvas.drawBitmap(imageList[0], null, rect, null)
            } else if (contador <= 42) {
                w = imageList[1].width
                h = imageList[1].height
                //Ultima animacion aparicion
                canvas.drawBitmap(imageList[1], null, rect, null)
            }else if (contador <= 45) {
                w = imageList[2].width
                h = imageList[2].height
                //Ultima animacion aparicion
                canvas.drawBitmap(imageList[2], null, rect, null)
            }else if (contador <= 48) {
                w = imageList[3].width
                h = imageList[3].height
                //Ultima animacion aparicion
                canvas.drawBitmap(imageList[3], null, rect, null)
            }else if (contador <= 51) {
                w = imageList[4].width
                h = imageList[4].height
                //Ultima animacion aparicion
                canvas.drawBitmap(imageList[4], null, rect, null)
            }else if (contador <= 54) {
                w = imageList[5].width
                h = imageList[5].height
                //Ultima animacion aparicion
                canvas.drawBitmap(imageList[5], null, rect, null)
            }
            contador = (contador+1)
            if(contador == 55){
                firstDraw = false
                contador = 0
                w = imageList[6].width
                h = imageList[6].height
                activeCoin=true
            }
        } else {
            canvas.drawBitmap(imageList[6], null, rect, null)

            if (value.toString().length == 1 && value >= 0) { //positius 1 xifra
                canvas.drawText(value.toString(), x.toFloat() - 15f, y.toFloat() + 12f, paint)
            } else if (value.toString().length == 2 && value < 0) { //negatius 1 xifra
                paint.color = Color.WHITE
                canvas.drawText(value.toString(), x.toFloat() - 30f, y.toFloat() + 12f, paint)
            } else if (value.toString().length == 2 && value > 0) { //positius 2 xifres
                canvas.drawText(value.toString(), x.toFloat() - 18f, y.toFloat() + 12f, paint)
            } else if (value.toString().length == 3 && value < 0) { //negatius 2 xifres
                paint.color = Color.WHITE
                canvas.drawText(value.toString(), x.toFloat() - 30f, y.toFloat() + 12f, paint)
            }
        }
    }
}