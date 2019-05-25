package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap
import android.graphics.Canvas
import edu.ub.pis.joc.limitless.view.ViewAdjuster.screenHeight
import edu.ub.pis.joc.limitless.view.ViewAdjuster.screenWidth

class Bomb(
    image: ArrayList<Bitmap>, posX: Int, posY: Int, behaviour:Int) : Enemy(image, posX, posY, behaviour) {

    override var w: Int = (screenWidth * 0.087962).toInt()
    override var h: Int = (screenHeight * 0.040433).toInt()

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
                w = (screenWidth * 0.087962).toInt()
                h = (screenHeight * 0.040433).toInt()
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
                w = (screenWidth * 0.00277).toInt()
                h = (screenHeight * 0.001479).toInt()
                rect.set(x - w/2, y - h/2, x + w/2, y + h/2)
                //Aparicion 5
                canvas.drawBitmap(imageList[0], null, rect, null)
            } else if (contador <= 42) {
                w = (screenWidth * 0.007407).toInt()
                h = (screenHeight * 0.003451).toInt()
                //Ultima animacion aparicion
                canvas.drawBitmap(imageList[1], null, rect, null)
            }else if (contador <= 45) {
                w = (screenWidth * 0.01481).toInt()
                h = (screenHeight * 0.0069033).toInt()
                //Ultima animacion aparicion
                canvas.drawBitmap(imageList[2], null, rect, null)
            }else if (contador <= 48) {
                w = (screenWidth * 0.03055).toInt()
                h = (screenHeight * 0.0138).toInt()
                //Ultima animacion aparicion
                canvas.drawBitmap(imageList[3], null, rect, null)
            }else if (contador <= 51) {
                w = (screenWidth * 0.04629).toInt()
                h = (screenHeight * 0.021203).toInt()
                //Ultima animacion aparicion
                canvas.drawBitmap(imageList[4], null, rect, null)
            }else if (contador <= 54) {
                w = (screenWidth * 0.061111).toInt()
                h = (screenHeight * 0.028106).toInt()
                //Ultima animacion aparicion
                canvas.drawBitmap(imageList[5], null, rect, null)
            }
            contador = (contador+1)
            if(contador == 55){
                firstDraw = false
                contador = 0
                w = (screenWidth * 0.087962).toInt()
                h = (screenHeight * 0.040433).toInt()
                activeEnemy=true
            }
        } else {
            if(dissapearTimer<=15){
                if (dissapearTimer >= 15) {
                    w = (screenWidth * 0.061111).toInt()
                    h = (screenHeight * 0.028106).toInt()
                    //Desparicion 1
                    canvas.drawBitmap(imageList[5], null, rect, null)
                } else if (dissapearTimer >= 12) {
                    w = (screenWidth * 0.04629).toInt()
                    h = (screenHeight * 0.021203).toInt()
                    //Desparicion 2
                    canvas.drawBitmap(imageList[4], null, rect, null)
                } else if (dissapearTimer >= 9) {
                    w = (screenWidth * 0.03055).toInt()
                    h = (screenHeight * 0.0138).toInt()
                    //Desparicion 3
                    canvas.drawBitmap(imageList[3], null, rect, null)
                } else if (dissapearTimer >= 6) {
                    w = (screenWidth * 0.01481).toInt()
                    h = (screenHeight * 0.0069033).toInt()
                    //Desparicion 4
                    canvas.drawBitmap(imageList[2], null, rect, null)
                } else if (dissapearTimer >= 3) {
                    w = (screenWidth * 0.007407).toInt()
                    h = (screenHeight * 0.003451).toInt()
                    //Desparicion 4
                    canvas.drawBitmap(imageList[1], null, rect, null)
                }
                else if (dissapearTimer >= 0) {
                    w = (screenWidth * 0.00277).toInt()
                    h = (screenHeight * 0.001479).toInt()
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