package edu.ub.pis.joc.limitless.model.game

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.support.design.widget.CoordinatorLayout

class Skull(image: ArrayList<Bitmap>, posX: Int, posY: Int,childList:Int,context: Context) : ComplexEnemy(image, posX, posY,childList,context) {

    override var h = image[0].height / 4
    override var w = image[0].width / 4

    var contador: Int = 0

    override fun update() {

    }

    override fun draw(canvas: Canvas) {
        val halfW: Int = w / 2
        val halfH: Int = h / 2
        rect.set(x - halfW, y - halfH, x + halfW, y + halfH)
        if (contador <= 3) {
            //Skull 1
            canvas.drawBitmap(imageList[0], null, rect, null)
        } else if (contador <= 6) {
            //Skull 2
            canvas.drawBitmap(imageList[1], null, rect, null)
        } else if (contador <= 9) {
            //Skull 3
            canvas.drawBitmap(imageList[2], null, rect, null)
        } else if (contador <= 12) {
            //Skull 3 Light
            canvas.drawBitmap(imageList[3], null, rect, null)
        } else if (contador <= 15) {
            //Skull 4
            canvas.drawBitmap(imageList[4], null, rect, null)
        } else if (contador <= 18) {
            //Skull 4 Light
            canvas.drawBitmap(imageList[5], null, rect, null)
        } else if (contador <= 21) {
            //Skull 4
            canvas.drawBitmap(imageList[4], null, rect, null)
        } else if (contador <= 24) {
            //Skull 4 Light
            canvas.drawBitmap(imageList[5], null, rect, null)
        } else if (contador <= 27) {
            //Skull 4
            canvas.drawBitmap(imageList[4], null, rect, null)
        } else if (contador <= 30) {
            //Skull 4 Light
            canvas.drawBitmap(imageList[5], null, rect, null)
        } else if (contador <= 33) {
            //Skull 4
            canvas.drawBitmap(imageList[4], null, rect, null)
        } else if (contador <= 36) {
            //Skull 4 Light
            canvas.drawBitmap(imageList[5], null, rect, null)
        } else if (contador == 37) {
            //Skull 5
            canvas.drawBitmap(imageList[6], null, rect, null)
        } else if (contador == 38) {
            //Skull 5 Light
            canvas.drawBitmap(imageList[7], null, rect, null)
        } else if (contador == 39) {
            //Skull 6
            canvas.drawBitmap(imageList[8], null, rect, null)
        } else if (contador == 40) {
            //Skull 6 Light
            canvas.drawBitmap(imageList[9], null, rect, null)
        } else if (contador == 41) {
            //Skull 7
            canvas.drawBitmap(imageList[10], null, rect, null)
        } else if (contador == 42) {
            //Skull 7 Light
            canvas.drawBitmap(imageList[11], null, rect, null)
        } else if (contador == 43) {
            //Skull 8
            canvas.drawBitmap(imageList[12], null, rect, null)
        } else if (contador == 44) {
            //Skull 8 Light
            canvas.drawBitmap(imageList[13], null, rect, null)
        } else if (contador == 45) {
            //Skull 8
            canvas.drawBitmap(imageList[12], null, rect, null)
        } else if (contador == 46) {
            //Skull 8 Light
            canvas.drawBitmap(imageList[13], null, rect, null)
        } else if (contador == 47) {
            //Skull 8
            canvas.drawBitmap(imageList[12], null, rect, null)
        } else if (contador == 48) {
            //Skull 8 Light
            canvas.drawBitmap(imageList[13], null, rect, null)
        } else if (contador == 49) {
            //Skull 8
            canvas.drawBitmap(imageList[12], null, rect, null)
        } else if (contador == 50) {
            //Skull 8 Light
            canvas.drawBitmap(imageList[13], null, rect, null)
        } else if (contador == 51) {
            //Skull 8
            canvas.drawBitmap(imageList[12], null, rect, null)
        } else if (contador == 52) {
            //Skull 8 Light
            canvas.drawBitmap(imageList[13], null, rect, null)
        } else if (contador == 53) {
            //Skull 8
            canvas.drawBitmap(imageList[12], null, rect, null)
        } else if (contador == 54) {
            //Skull 8 Light
            canvas.drawBitmap(imageList[13], null, rect, null)
        } else if (contador == 55) {
            //Skull 8
            canvas.drawBitmap(imageList[12], null, rect, null)
        } else if (contador == 56) {
            //Skull 8 Light
            canvas.drawBitmap(imageList[13], null, rect, null)
        }

        contador = (contador + 1) % 57
    }
}