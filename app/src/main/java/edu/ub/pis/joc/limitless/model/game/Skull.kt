package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap

class Skull(image: Bitmap) : Enemy(image), EnemyInterface {

    override var xVelocity: Int = 10
    override var yVelocity: Int = 10

    init {
        x = getScreenWidth() / 2
        y = getScreenHeight() / 2

        h = image.height / 4
        w = image.width / 4
    }




}