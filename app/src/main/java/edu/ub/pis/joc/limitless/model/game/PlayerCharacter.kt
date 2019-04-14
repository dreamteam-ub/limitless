package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap

class PlayerCharacter(image: Bitmap) : Character(image), PlayerCharacterInterface {


    override fun update(newX : Int , newY : Int) {
        /* colissio parets
        if (x >= getScreenWidth() - w){
            x = newX-1;
            y=newY
        }

        if (x <= 0){
            x = newX+1;
            y=newY
        }

        if (y >= getScreenHeight() - h){
            y =newY-1
            x= newX
        }

        if (y <= 0){
            y=newY+1
            x= newX
        }
        */
            x = newX
            y = newY


    }

    //elimina totalment el bitmap de la surfaceview
    override fun die() {
        image.recycle()
    }






}