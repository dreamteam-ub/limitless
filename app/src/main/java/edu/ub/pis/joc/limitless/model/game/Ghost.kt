package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap

class Ghost(image: ArrayList<Bitmap>) : Enemy(image) {

    override var xVelocity: Int = 10
    override var yVelocity: Int = 10

    override var h = image[0].height / 3
    override var w = image[0].width / 3

    override val imageList : ArrayList<Bitmap> = image

    override var activeEnemy: Boolean = true

    override fun update() {

        if (x > this.getScreenWidth() - w || x < w) {
            xVelocity *= -1
        }
        if (y > this.getScreenHeight() - h || y < h) {
            yVelocity *= -1
        }

        x += (xVelocity)
        y += (yVelocity)

    }

}