package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap
import android.graphics.Canvas

class SkullLaser(image: ArrayList<Bitmap>) : Enemy(image) {

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
        val appropiateH: Int = (((h/3.36).toInt())/2)-10
        rect.set(x - halfW, y+appropiateH,x + halfW, getScreenHeight())
        if (contador in 41..50){
            canvas.drawBitmap(imageList[0], null, rect, null)
        } else if (contador in 51..60){
            canvas.drawBitmap(imageList[1], null, rect, null)
        } else if (contador in 61..70){
            canvas.drawBitmap(imageList[2], null, rect, null)
        } else if (contador in 71..80){
            canvas.drawBitmap(imageList[3], null, rect, null)
        } else if (contador in 81..90){
            canvas.drawBitmap(imageList[4], null, rect, null)
        } else if (contador in 91..100){
            canvas.drawBitmap(imageList[5], null, rect, null)
        } else if (contador in 101..110){
            canvas.drawBitmap(imageList[6], null, rect, null)
        } else if (contador in 111..120){
            canvas.drawBitmap(imageList[7], null, rect, null)
        } else if (contador in 121..130){
            canvas.drawBitmap(imageList[8], null, rect, null)
        } else if (contador in 131..140){
            canvas.drawBitmap(imageList[9], null, rect, null)
        }

        contador++

        if(contador ==141) {
            contador = 0
        }
    }
}