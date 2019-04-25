package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap
import android.graphics.Canvas

class Skull(image: ArrayList<Bitmap>, posX: Int, posY: Int) : Enemy(image, posX, posY) {

    override var h = image[0].height / 4
    override var w = image[0].width / 4

    var contador: Int = 0

    override fun update() {

    }

    override fun draw(canvas: Canvas) {
        val halfW: Int = w / 2
        val halfH: Int = h / 2
        rect.set(x - halfW, y - halfH, x + halfW, y + halfH)
        if (contador <= 5) {
            //Skull 1
            canvas.drawBitmap(imageList[0], null, rect, null)
        } else if (contador <= 10) {
            //Skull 2
            canvas.drawBitmap(imageList[1], null, rect, null)
        } else if (contador <= 15) {
            //Skull 3
            canvas.drawBitmap(imageList[2], null, rect, null)
        } else if (contador <= 20) {
            //Skull 3 Light
            canvas.drawBitmap(imageList[3], null, rect, null)
        } else if (contador <= 25) {
            //Skull 4
            canvas.drawBitmap(imageList[4], null, rect, null)
        } else if (contador <= 30) {
            //Skull 4 Light
            canvas.drawBitmap(imageList[5], null, rect, null)
        } else if (contador <= 35) {
            //Skull 4
            canvas.drawBitmap(imageList[4], null, rect, null)
        } else if (contador <= 40) {
            //Skull 4 Light
            canvas.drawBitmap(imageList[5], null, rect, null)
        } else if (contador <= 45) {
            //Skull 4
            canvas.drawBitmap(imageList[4], null, rect, null)
        } else if (contador <= 50) {
            //Skull 4 Light
            canvas.drawBitmap(imageList[5], null, rect, null)
        } else if (contador <= 55) {
            //Skull 4
            canvas.drawBitmap(imageList[4], null, rect, null)
        } else if (contador <= 60) {
            //Skull 4 Light
            canvas.drawBitmap(imageList[5], null, rect, null)
        } else if (contador <= 62) {
            //Skull 5
            canvas.drawBitmap(imageList[6], null, rect, null)
        } else if (contador <= 64) {
            //Skull 5 Light
            canvas.drawBitmap(imageList[7], null, rect, null)
        } else if (contador <= 66) {
            //Skull 6
            canvas.drawBitmap(imageList[8], null, rect, null)
        } else if (contador <= 68) {
            //Skull 6 Light
            canvas.drawBitmap(imageList[9], null, rect, null)
        } else if (contador <= 70) {
            //Skull 7
            canvas.drawBitmap(imageList[10], null, rect, null)
        } else if (contador <= 72) {
            //Skull 7 Light
            canvas.drawBitmap(imageList[11], null, rect, null)
        } else if (contador <= 74) {
            //Skull 8
            canvas.drawBitmap(imageList[12], null, rect, null)
        } else if (contador <= 76) {
            //Skull 8 Light
            canvas.drawBitmap(imageList[13], null, rect, null)
        } else if (contador <= 78) {
            //Skull 8
            canvas.drawBitmap(imageList[12], null, rect, null)
        } else if (contador <= 80) {
            //Skull 8 Light
            canvas.drawBitmap(imageList[13], null, rect, null)
        } else if (contador <= 82) {
            //Skull 8
            canvas.drawBitmap(imageList[12], null, rect, null)
        } else if (contador <= 84) {
            //Skull 8 Light
            canvas.drawBitmap(imageList[13], null, rect, null)
        } else if (contador <= 86) {
            //Skull 8
            canvas.drawBitmap(imageList[12], null, rect, null)
        } else if (contador <= 88) {
            //Skull 8 Light
            canvas.drawBitmap(imageList[13], null, rect, null)
        } else if (contador <= 90) {
            //Skull 8
            canvas.drawBitmap(imageList[12], null, rect, null)
        } else if (contador <= 92) {
            //Skull 8 Light
            canvas.drawBitmap(imageList[13], null, rect, null)
        } else if (contador <= 94) {
            //Skull 8
            canvas.drawBitmap(imageList[12], null, rect, null)
        } else if (contador <= 96) {
            //Skull 8 Light
            canvas.drawBitmap(imageList[13], null, rect, null)
        } else if (contador <= 98) {
            //Skull 8
            canvas.drawBitmap(imageList[12], null, rect, null)
        } else if (contador <= 100) {
            //Skull 8 Light
            canvas.drawBitmap(imageList[13], null, rect, null)
        }

        contador = (contador + 1) % 101
    }
}