package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap
import android.graphics.Canvas

class EyeProjectile (image:ArrayList<Bitmap>, posX: Int, posY: Int) : Enemy(image, posX, posY) {

    override var xVelocity: Int = 10
    override var yVelocity: Int = 10

    override var h = image[0].height /4
    override var w = image[0].width /4

    override fun update() {

    }

    override fun draw(canvas: Canvas) {
        
    }

}