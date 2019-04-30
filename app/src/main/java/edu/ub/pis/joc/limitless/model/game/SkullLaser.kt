package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap
import android.graphics.Canvas
import edu.ub.pis.joc.limitless.model.Data.screenHeight

class SkullLaser(image: ArrayList<Bitmap>, posX: Int, posY: Int) : Enemy(image, posX, posY) {

    override var h = image[0].height /4
    override var w = image[0].width /4

    var contador : Int = 0

    override fun update() {

    }

    override fun draw(canvas: Canvas){
        val halfW: Int = w / 2
        val appropiateH: Int = (((h/3.36).toInt())/2)-10
        rect.set(x - halfW, y+appropiateH,x + halfW, screenHeight)
        if (contador in 13..15){
            //Beam 1 - Corresponde a Skull 4
            canvas.drawBitmap(imageList[0], null, rect, null)
        } else if (contador in 16..18){
            //Beam 1 Light - Corresponde a Skull 4 Light
            canvas.drawBitmap(imageList[1], null, rect, null)
        } else if (contador in 19..21){
            //Beam 1 - Corresponde a Skull 4
            canvas.drawBitmap(imageList[0], null, rect, null)
        } else if (contador in 22..24){
            //Beam 1 Light - Corresponde a Skull 4 Light
            canvas.drawBitmap(imageList[1], null, rect, null)
        } else if (contador in 25..27){
            //Beam 1 - Corresponde a Skull 4
            canvas.drawBitmap(imageList[0], null, rect, null)
        } else if (contador in 28..30){
            //Beam 1 Light - Corresponde a Skull 4 Light
            canvas.drawBitmap(imageList[1], null, rect, null)
        } else if (contador in 31..33){
            //Beam 1 - Corresponde a Skull 4
            canvas.drawBitmap(imageList[0], null, rect, null)
        } else if (contador in 34..36){
            //Beam 1 Light - Corresponde a Skull 4 Light
            canvas.drawBitmap(imageList[1], null, rect, null)
        } else if (contador == 37){
            //Beam 2 - Corresponde a Skull 5
            canvas.drawBitmap(imageList[2], null, rect, null)
        } else if (contador == 38){
            //Beam 2 Light - Corresponde a Skull 5 Light
            canvas.drawBitmap(imageList[3], null, rect, null)
        } else if (contador == 39){
            //Beam 3 - Corresponde a Skull 6
            canvas.drawBitmap(imageList[4], null, rect, null)
        } else if (contador == 40){
            //Beam 3 Light - Corresponde a Skull 6 Light
            canvas.drawBitmap(imageList[5], null, rect, null)
        } else if (contador == 41){
            //Beam 4 - Corresponde a Skull 7
            activeEnemy = true
            canvas.drawBitmap(imageList[6], null, rect, null)
        } else if (contador == 42){
            //Beam 4 Light - Corresponde a Skull 7 Light
            canvas.drawBitmap(imageList[7], null, rect, null)
        } else if (contador == 43){
            //Beam 5 - Corresponde a Skull 8
            canvas.drawBitmap(imageList[8], null, rect, null)
        } else if (contador == 44){
            //Beam 5 Light - Corresponde a Skull 8 Light
            canvas.drawBitmap(imageList[9], null, rect, null)
        } else if (contador == 45){
            //Beam 5 - Corresponde a Skull 8
            canvas.drawBitmap(imageList[8], null, rect, null)
        } else if (contador == 46){
            //Beam 5 Light - Corresponde a Skull 8 Light
            canvas.drawBitmap(imageList[9], null, rect, null)
        } else if (contador == 47){
            //Beam 5 - Corresponde a Skull 8
            canvas.drawBitmap(imageList[8], null, rect, null)
        } else if (contador == 48){
            //Beam 5 Light - Corresponde a Skull 8 Light
            canvas.drawBitmap(imageList[9], null, rect, null)
        } else if (contador == 49){
            //Beam 5 - Corresponde a Skull 8
            canvas.drawBitmap(imageList[8], null, rect, null)
        } else if (contador == 50){
            //Beam 5 Light - Corresponde a Skull 8 Light
            canvas.drawBitmap(imageList[9], null, rect, null)
        } else if (contador == 51){
            //Beam 5 - Corresponde a Skull 8
            canvas.drawBitmap(imageList[8], null, rect, null)
        } else if (contador == 52){
            //Beam 5 Light - Corresponde a Skull 8 Light
            canvas.drawBitmap(imageList[9], null, rect, null)
        } else if (contador == 53){
            //Beam 5 - Corresponde a Skull 8
            canvas.drawBitmap(imageList[8], null, rect, null)
        } else if (contador == 54) {
            //Beam 5 Light - Corresponde a Skull 8 Light
            canvas.drawBitmap(imageList[9], null, rect, null)
        } else if (contador == 55){
            //Beam 5 - Corresponde a Skull 8
            canvas.drawBitmap(imageList[8], null, rect, null)
        } else if (contador == 56) {
            //Beam 5 Light - Corresponde a Skull 8 Light
            canvas.drawBitmap(imageList[9], null, rect, null)
        }

        contador = (contador+1) % 57

        if(contador == 0) {
            activeEnemy = false
        }
    }
}