package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap
import edu.ub.pis.joc.limitless.model.Data

class Demon(image: ArrayList<Bitmap>, posX: Int, posY: Int) : Enemy(image, posX, posY) {

    override var xVelocity: Int = 10
    override var yVelocity: Int = 10

    override var h = image[0].height / 4
    override var w = image[0].width / 4

    override fun update(behaviour: Int) {
        when (behaviour) {
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