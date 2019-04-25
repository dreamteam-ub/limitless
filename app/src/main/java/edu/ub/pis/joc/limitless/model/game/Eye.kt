package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap
import edu.ub.pis.joc.limitless.model.Data.screenHeight
import edu.ub.pis.joc.limitless.model.Data.screenWidth

class Eye(image: ArrayList<Bitmap>, posX: Int, posY: Int) : Enemy(image, posX, posY) {

    override var xVelocity: Int = 10
    override var yVelocity: Int = 10


    override var h = image[0].height / 3
    override var w = image[0].width / 3

    override fun update() {

        if (x > screenWidth - w || x < w) {
            xVelocity *= -1
        }
        if (y > screenHeight - h || y < h) {
            yVelocity *= -1
        }

        x += (xVelocity)
        y += (yVelocity)
    }

}