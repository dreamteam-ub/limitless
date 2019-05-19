package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap
import android.graphics.Canvas
import android.util.Log

class Bomb(
    image: ArrayList<Bitmap>, posX: Int, posY: Int, behaviour:Int) : Enemy(image, posX, posY, behaviour) {

    override var xVelocity: Int = 0
    override var yVelocity: Int = 0

    override var activeEnemy: Boolean = false
    private var firstDraw : Boolean = true
    var contador: Int = 0

    override var concreteBehaviour = behaviour

    override fun update() {
        this.dissapearTimer--
        //static only we update if it is visible or not
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
                canvas.drawBitmap(imageList[10], null, rect, null)
            } else if (contador <= 6) {
                //Aparicion 2
                canvas.drawBitmap(imageList[11], null, rect, null)
            } else if (contador <= 9) {
                //Aparicion 3
                canvas.drawBitmap(imageList[12], null, rect, null)
            } else if (contador <= 12) {
                //Aparicion 4
                canvas.drawBitmap(imageList[13], null, rect, null)
            } else if (contador <= 15) {
                //Aparicion 2
                canvas.drawBitmap(imageList[10], null, rect, null)
            } else if (contador <= 18) {
                //Aparicion 3
                canvas.drawBitmap(imageList[11], null, rect, null)
            } else if (contador <= 21) {
                //Aparicion 4
                canvas.drawBitmap(imageList[12], null, rect, null)
            } else if (contador <= 24) {
                //Aparicion 5
                canvas.drawBitmap(imageList[13], null, rect, null)
            } else if (contador <= 27) {
                //Aparicion 2
                canvas.drawBitmap(imageList[10], null, rect, null)
            } else if (contador <= 30) {
                //Aparicion 3
                canvas.drawBitmap(imageList[11], null, rect, null)
            } else if (contador <= 33) {
                //Aparicion 4
                canvas.drawBitmap(imageList[12], null, rect, null)
            } else if (contador <= 36) {
                //Aparicion 5
                canvas.drawBitmap(imageList[13], null, rect, null)
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
                activeEnemy=true
            }
        } else {
            if(dissapearTimer<=15){
                if (dissapearTimer >= 15) {
                    w = imageList[5].width
                    h = imageList[5].height
                    //Desparicion 1
                    canvas.drawBitmap(imageList[5], null, rect, null)
                } else if (dissapearTimer >= 12) {
                    w = imageList[4].width
                    h = imageList[4].height
                    //Desparicion 2
                    canvas.drawBitmap(imageList[4], null, rect, null)
                } else if (dissapearTimer >= 9) {
                    w = imageList[3].width
                    h = imageList[3].height
                    //Desparicion 3
                    canvas.drawBitmap(imageList[3], null, rect, null)
                } else if (dissapearTimer >= 6) {
                    w = imageList[2].width
                    h = imageList[2].height
                    //Desparicion 4
                    canvas.drawBitmap(imageList[2], null, rect, null)
                } else if (dissapearTimer >= 3) {
                    w = imageList[1].width
                    h = imageList[1].height
                    //Desparicion 4
                    canvas.drawBitmap(imageList[1], null, rect, null)
                }
                else if (dissapearTimer >= 0) {
                    w = imageList[0].width
                    h = imageList[0].height
                    //Desparicion 4
                    canvas.drawBitmap(imageList[0], null, rect, null)
                }
            } else {
                if (contador <= 3) {
                    //Aparicion 1
                    canvas.drawBitmap(imageList[6], null, rect, null)
                } else if (contador <= 6) {
                    //Aparicion 2
                    canvas.drawBitmap(imageList[7], null, rect, null)
                } else if (contador <= 9) {
                    //Aparicion 3
                    canvas.drawBitmap(imageList[8], null, rect, null)
                } else if (contador <= 12) {
                    //Aparicion 4
                    canvas.drawBitmap(imageList[9], null, rect, null)
                }
                contador = (contador + 1) % 13
            }
        }
    }

}