package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap
import edu.ub.pis.joc.limitless.model.Data
import android.content.Context

class Demon(image: ArrayList<Bitmap>, posX: Int, posY: Int,childList:Int,context: Context) : ComplexEnemy(image, posX, posY,childList,context) {

    override var xVelocity: Int = 20
    override var yVelocity: Int = 20

    override var h = image[0].height / 4
    override var w = image[0].width / 4

    override fun update() {
        when (concreteBehavior) {
            0 -> {
                if (x > Data.screenWidth - w || x < w) {
                    xVelocity *= -1
                }
                if (y > Data.screenHeight - h || y < h) {
                    yVelocity *= -1
                }

                x += (xVelocity)
                y += (yVelocity)
            }
            1 -> {
                if (y > Data.screenHeight - h || y < h) {
                    yVelocity *= -1
                }
                y += (yVelocity)
                //movimiento vertical


            }
            2->{
                if (x > Data.screenWidth - w || x < w) {
                    xVelocity *= -1
                }
                x += (xVelocity)
                //movimiento horizontal

            }
        }
    }
}