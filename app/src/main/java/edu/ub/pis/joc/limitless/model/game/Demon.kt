package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap

class Demon(image: Bitmap) : Enemy(image), EnemyInterface {

    override var xVelocity: Int = 20
    override var yVelocity: Int = 20


}