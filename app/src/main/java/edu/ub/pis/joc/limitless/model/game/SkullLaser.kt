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
        if (contador in 21..25){
            //Beam 1 - Corresponde a Skull 4
            canvas.drawBitmap(imageList[0], null, rect, null)
        } else if (contador in 26..30){
            //Beam 1 Light - Corresponde a Skull 4 Light
            canvas.drawBitmap(imageList[1], null, rect, null)
        } else if (contador in 31..35){
            //Beam 1 - Corresponde a Skull 4
            canvas.drawBitmap(imageList[0], null, rect, null)
        } else if (contador in 36..40){
            //Beam 1 Light - Corresponde a Skull 4 Light
            canvas.drawBitmap(imageList[1], null, rect, null)
        } else if (contador in 41..45){
            //Beam 1 - Corresponde a Skull 4
            canvas.drawBitmap(imageList[0], null, rect, null)
        } else if (contador in 46..50){
            //Beam 1 Light - Corresponde a Skull 4 Light
            canvas.drawBitmap(imageList[1], null, rect, null)
        } else if (contador in 51..55){
            //Beam 1 - Corresponde a Skull 4
            canvas.drawBitmap(imageList[0], null, rect, null)
        } else if (contador in 56..60){
            //Beam 1 Light - Corresponde a Skull 4 Light
            canvas.drawBitmap(imageList[1], null, rect, null)
        } else if (contador in 61..62){
            //Beam 2 - Corresponde a Skull 5
            canvas.drawBitmap(imageList[2], null, rect, null)
        } else if (contador in 63..64){
            //Beam 2 Light - Corresponde a Skull 5 Light
            canvas.drawBitmap(imageList[3], null, rect, null)
        } else if (contador in 65..66){
            //Beam 3 - Corresponde a Skull 6
            canvas.drawBitmap(imageList[4], null, rect, null)
        } else if (contador in 67..68){
            //Beam 3 Light - Corresponde a Skull 6 Light
            canvas.drawBitmap(imageList[5], null, rect, null)
        } else if (contador in 69..70){
            //Beam 4 - Corresponde a Skull 7
            activeEnemy = true
            canvas.drawBitmap(imageList[6], null, rect, null)
        } else if (contador in 71..72){
            //Beam 4 Light - Corresponde a Skull 7 Light
            canvas.drawBitmap(imageList[7], null, rect, null)
        } else if (contador in 73..74){
            //Beam 5 - Corresponde a Skull 8
            canvas.drawBitmap(imageList[8], null, rect, null)
        } else if (contador in 75..76){
            //Beam 5 Light - Corresponde a Skull 8 Light
            canvas.drawBitmap(imageList[9], null, rect, null)
        } else if (contador in 77..78){
            //Beam 5 - Corresponde a Skull 8
            canvas.drawBitmap(imageList[8], null, rect, null)
        } else if (contador in 79..80){
            //Beam 5 Light - Corresponde a Skull 8 Light
            canvas.drawBitmap(imageList[9], null, rect, null)
        } else if (contador in 81..82){
            //Beam 5 - Corresponde a Skull 8
            canvas.drawBitmap(imageList[8], null, rect, null)
        } else if (contador in 83..84){
            //Beam 5 Light - Corresponde a Skull 8 Light
            canvas.drawBitmap(imageList[9], null, rect, null)
        } else if (contador in 85..86){
            //Beam 5 - Corresponde a Skull 8
            canvas.drawBitmap(imageList[8], null, rect, null)
        } else if (contador in 87..88){
            //Beam 5 Light - Corresponde a Skull 8 Light
            canvas.drawBitmap(imageList[9], null, rect, null)
        } else if (contador in 89..90){
            //Beam 5 - Corresponde a Skull 8
            canvas.drawBitmap(imageList[8], null, rect, null)
        } else if (contador in 91..92){
            //Beam 5 Light - Corresponde a Skull 8 Light
            canvas.drawBitmap(imageList[9], null, rect, null)
        } else if (contador in 93..94){
            //Beam 5 - Corresponde a Skull 8
            canvas.drawBitmap(imageList[8], null, rect, null)
        } else if (contador in 95..96) {
            //Beam 5 Light - Corresponde a Skull 8 Light
            canvas.drawBitmap(imageList[9], null, rect, null)
        } else if (contador in 97..98){
            //Beam 5 - Corresponde a Skull 8
            canvas.drawBitmap(imageList[8], null, rect, null)
        } else if (contador in 99..100) {
            //Beam 5 Light - Corresponde a Skull 8 Light
            canvas.drawBitmap(imageList[9], null, rect, null)
        }

        contador++

        if(contador ==101) {
            contador = 0
            activeEnemy = false
        }
    }
}