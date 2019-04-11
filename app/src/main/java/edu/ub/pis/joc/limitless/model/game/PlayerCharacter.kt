package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap

class PlayerCharacter(image: Bitmap) : Character(image), PlayerCharacterInterface {





    override fun update(newX : Int , newY : Int) {

        x=newX
        y=newY

    }






}