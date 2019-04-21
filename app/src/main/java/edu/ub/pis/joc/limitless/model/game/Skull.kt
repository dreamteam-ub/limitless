package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap
import android.graphics.drawable.AnimationDrawable
import android.media.Image
import android.widget.ImageView
import edu.ub.pis.joc.limitless.R

class Skull(image: ArrayList<Bitmap>) : Enemy(ArrayList<Bitmap>()) {

    override var xVelocity: Int = 10
    override var yVelocity: Int = 10

    override var h = image[0].height /4
    override var w = image[0].width /4

    override fun update() {

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