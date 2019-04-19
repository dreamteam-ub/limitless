package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap

class NumberCharacter(image: Bitmap) : Character(image), ObjectsInGameInterface {

    var value : Int? = null

    override var x = (getScreenWidth()*0.5).toInt()
    override var y = (getScreenHeight()*0.5).toInt()



     override fun update() {

    }

    override fun isTaken() {
        image.recycle()
    }

    fun getValue() : Int{
        return this.value!!
    }

    fun setValue(value : Int){
        this.value=value
    }
}