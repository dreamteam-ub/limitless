package edu.ub.pis.joc.limitless.model.game

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas

class Skull(image: ArrayList<Bitmap>) : Enemy(image) {

    override var h = image[0].height /4
    override var w = image[0].width /4

    //posicion inicial
    override var x: Int = (getScreenWidth()*0.5).toInt()
    override var y: Int = (getScreenHeight()*0.1).toInt()

    override val imageList : ArrayList<Bitmap> = image

    var contador : Int = 0

    override fun update() {

    }

    override fun draw(canvas: Canvas){
        val halfW: Int = w / 2
        val halfH: Int = h / 2
        rect.set(x - halfW, y - halfH, x + halfW, y + halfH)
        if(contador<=10) {
            canvas.drawBitmap(imageList[0], null, rect, null)
        } else if (contador <= 20){
            canvas.drawBitmap(imageList[1], null, rect, null)
        } else if (contador <= 30){
            canvas.drawBitmap(imageList[2], null, rect, null)
        } else if (contador <= 40){
            canvas.drawBitmap(imageList[3], null, rect, null)
        } else if (contador <= 50){
            canvas.drawBitmap(imageList[4], null, rect, null)
        } else if (contador <= 60){
            canvas.drawBitmap(imageList[5], null, rect, null)
        } else if (contador <= 70){
            canvas.drawBitmap(imageList[6], null, rect, null)
        } else if (contador <= 80){
            canvas.drawBitmap(imageList[7], null, rect, null)
        } else if (contador <= 90){
            canvas.drawBitmap(imageList[8], null, rect, null)
        } else if (contador <= 100){
            canvas.drawBitmap(imageList[9], null, rect, null)
        } else if (contador <= 110){
            canvas.drawBitmap(imageList[10], null, rect, null)
        } else if (contador <= 120){
            canvas.drawBitmap(imageList[11], null, rect, null)
        } else if (contador <= 130){
            canvas.drawBitmap(imageList[12], null, rect, null)
        } else if (contador <= 140){
            canvas.drawBitmap(imageList[13], null, rect, null)
        }

        contador++

        if(contador ==141) {
            contador = 0
        }
    }
}