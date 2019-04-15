package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap

class Skull(image: Bitmap) : Character(image), EnemyInterface {

    override var xVelocity: Int = 10
    override var yVelocity: Int = 10

    init {
        x = getScreenWidth() / 2
        y = getScreenHeight() / 2

        h = image.height / 4
        w = image.width / 4
    }

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