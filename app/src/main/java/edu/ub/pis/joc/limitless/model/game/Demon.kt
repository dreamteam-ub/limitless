package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap

class Demon(image : Bitmap) : Character(image), EnemieInterface {

    override var xVelocity: Int = 20
    override var yVelocity: Int = 20



    override fun update() {
        //val randomNum = ThreadLocalRandom.current().nextInt(1, 5)

        if (x > this.getScreenWidth() - image.width || x < image.width) {
            xVelocity = xVelocity * -1
        }
        if (y > this.getScreenHeight() - image.height || y < image.height) {
            yVelocity = yVelocity * -1
        }

        x  += (xVelocity)
        y += (yVelocity)

    }
}