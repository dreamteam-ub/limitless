package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap

class PlayerCharacter(image: Bitmap) : Character(image), PlayerCharacterInterface {


    override fun update(newX : Int , newY : Int) {

        x=newX
        y=newY

    }

    //elimina totalment el bitmap de la surfaceview
    override fun die() {
        image.recycle()
    }






}