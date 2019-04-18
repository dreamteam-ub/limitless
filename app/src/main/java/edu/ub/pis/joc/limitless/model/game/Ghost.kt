package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap

class Ghost(image: Bitmap) : Enemy(image), EnemyInterface {

    override var xVelocity: Int = 10
    override var yVelocity: Int = 10

    override var h = image.height / 3
    override var w = image.width / 3

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