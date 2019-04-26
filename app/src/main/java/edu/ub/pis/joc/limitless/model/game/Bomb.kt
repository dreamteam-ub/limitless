package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap
import android.graphics.Canvas
import android.util.Log

class Bomb(
    image: ArrayList<Bitmap>, posX: Int, posY: Int) : Enemy(image, posX, posY) {

    override var xVelocity: Int = 0
    override var yVelocity: Int = 0

    override var w = image[0].width/16
    override var h = image[0].height/16

    override var activeEnemy: Boolean = true
    private var firstDraw : Boolean = true

    var contador: Int = 0



    override fun update() {
        this.dissapearTimer--
        //static only we update if it is visible or not
    }

    override fun draw(canvas: Canvas) {

        val halfW: Int = w / 2
        val halfH: Int = h / 2
        rect.set(x - halfW, y - halfH, x + halfW, y + halfH)

        if(firstDraw){
            if (contador <= 5) {
                w = imageList[0].width/16
                h = imageList[0].height/16
                //Aparicion 1
                canvas.drawBitmap(imageList[0], null, rect, null)
            } else if (contador <= 10) {
                w = imageList[1].width/16
                h = imageList[1].height/16
                //Aparicion 2
                canvas.drawBitmap(imageList[1], null, rect, null)
            } else if (contador <= 15) {
                w = imageList[2].width/16
                h = imageList[2].height/16
                //Aparicion 3
                canvas.drawBitmap(imageList[2], null, rect, null)
            } else if (contador <= 20) {
                w = imageList[3].width/16
                h = imageList[3].height/16
                //Aparicion 4
                canvas.drawBitmap(imageList[3], null, rect, null)
            } else if (contador <= 25) {
                w = imageList[4].width/16
                h = imageList[4].height/16
                //Aparicion 5
                canvas.drawBitmap(imageList[4], null, rect, null)
            } else if (contador <= 30) {
                w = imageList[5].width/16
                h = imageList[5].height/16
                //Ultima animacion aparicion
                canvas.drawBitmap(imageList[5], null, rect, null)
            }
            contador = (contador+1)
            if(contador == 31){
                firstDraw = false
                contador = 0
                w = imageList[6].width/16
                h = imageList[6].height/16
            }
        } else {
            if(dissapearTimer<=30){
                if (dissapearTimer >= 25) {
                    w = imageList[5].width/16
                    h = imageList[5].height/16
                    //Desparicion 1
                    canvas.drawBitmap(imageList[5], null, rect, null)
                } else if (dissapearTimer >= 20) {
                    w = imageList[4].width/16
                    h = imageList[4].height/16
                    //Desparicion 2
                    canvas.drawBitmap(imageList[4], null, rect, null)
                } else if (dissapearTimer >= 15) {
                    w = imageList[3].width/16
                    h = imageList[3].height/16
                    //Desparicion 3
                    canvas.drawBitmap(imageList[3], null, rect, null)
                } else if (dissapearTimer >= 10) {
                    w = imageList[2].width/16
                    h = imageList[2].height/16
                    //Desparicion 4
                    canvas.drawBitmap(imageList[2], null, rect, null)
                } else if (dissapearTimer >= 5) {
                    w = imageList[1].width/16
                    h = imageList[1].height/16
                    //Desparicion 4
                    canvas.drawBitmap(imageList[1], null, rect, null)
                }
                else if (dissapearTimer >= 0) {
                    w = imageList[0].width/16
                    h = imageList[0].height/16
                    //Desparicion 4
                    canvas.drawBitmap(imageList[0], null, rect, null)
                }
            } else {
                if (contador <= 5) {
                    //Aparicion 1
                    canvas.drawBitmap(imageList[6], null, rect, null)
                } else if (contador <= 10) {
                    //Aparicion 2
                    canvas.drawBitmap(imageList[7], null, rect, null)
                } else if (contador <= 15) {
                    //Aparicion 3
                    canvas.drawBitmap(imageList[8], null, rect, null)
                } else if (contador <= 20) {
                    //Aparicion 4
                    canvas.drawBitmap(imageList[9], null, rect, null)
                }
                contador = (contador + 1) % 21
            }
        }
    }

}