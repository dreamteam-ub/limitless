package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap

class PlayerCharacter(image: Bitmap) : Character(image), PlayerCharacterInterface {

    init{
        w=image.width/3
        h=image.height/3
    }




    override fun update(newX : Int , newY : Int) {
        var nX = newX
        var nY = newY



        if (newX >= getScreenWidth()-w){
            var resta = newX-(getScreenWidth()-w)
            nX -=resta
            x=nX
            y=nY

        }

        if (newX <= 0 + w){
            var resta = w-newX
            nX +=resta
            x=nX
            y=nY
        }

        if (newY >= getScreenHeight()-h){
            var resta = newY-(getScreenHeight()-h)
            nY-=resta
            y=nY
            x=nX
        }

        if (newY <= 0 + h) {
            var resta = h-newY
            nY+= resta
            y=nY
            x=nX


        }else{
            x=nX
            y=nY
        }




    }

    override fun playerTakesNumber(number: Number) {

            if (this!!.rect!!.intersect(number!!.rect)){
                //get number value etc etc
                number.isTaken()
            }
        }



    //elimina totalment el bitmap de la surfaceview
    override fun die() {

        this.image.recycle()
    }






}