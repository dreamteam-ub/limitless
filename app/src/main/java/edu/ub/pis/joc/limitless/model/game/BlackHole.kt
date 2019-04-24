package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap

class BlackHole(image: ArrayList<Bitmap>) : Enemy(image) {

    override var xVelocity: Int = 0
    override var yVelocity: Int = 0

    override val imageList : ArrayList<Bitmap> = image

    override var activeEnemy: Boolean = true

    override fun update() {
        //static only we update if it is visible or not

    }

}