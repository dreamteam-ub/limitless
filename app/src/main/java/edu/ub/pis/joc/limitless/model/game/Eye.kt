package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap

class Eye(image: Bitmap) : Character(image), EnemyInterface {

    override var xVelocity: Int = 20
    override var yVelocity: Int = 20

    override fun update() {
        //val randomNum = ThreadLocalRandom.current().nextInt(1, 5)

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