package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap

class BlackHole(image: ArrayList<Bitmap>, posX: Int, posY: Int, behaviour:Int) : Enemy(image, posX, posY, behaviour) {

    override var xVelocity: Int = 0
    override var yVelocity: Int = 0

    override var activeEnemy: Boolean = true

    override var concreteBehaviour = behaviour

    override fun update() {
        //static only we update if it is visible or not

    }

}