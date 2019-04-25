package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap

class Ghost(image: ArrayList<Bitmap>, posX: Int, posY: Int) : Enemy(image, posX, posY) {

    override var xVelocity: Int = 10
    override var yVelocity: Int = 10

    override var h = image[0].height / 3
    override var w = image[0].width / 3

    override var activeEnemy: Boolean = true

}