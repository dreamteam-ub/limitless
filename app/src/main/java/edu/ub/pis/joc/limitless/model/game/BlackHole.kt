package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap

class BlackHole(image: Bitmap) : Character(image) , EnemieInterface {

    override var xVelocity: Int = 0
    override var yVelocity: Int = 0



    override fun update() {
        //static only we update if it is visible or not

    }
}