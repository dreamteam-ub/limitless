package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap

class Bomb(
    image: ArrayList<Bitmap>, posX: Int, posY: Int) : Enemy(image, posX, posY) {

    override var xVelocity: Int = 0
    override var yVelocity: Int = 0

    override var activeEnemy: Boolean = true


    override fun update(behaviour : Int) {
        //static only we update if it is visible or not

    }

}