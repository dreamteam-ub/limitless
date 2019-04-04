package edu.ub.pis.joc.limitless.model

import android.widget.ImageView

abstract class Actor(posicionX: Int, posicionY: Int, image: ImageView) {

    var posX : Int = posicionX
    var posY : Int = posicionY
    var img : ImageView = image


    abstract fun update()

    abstract fun draw()


}