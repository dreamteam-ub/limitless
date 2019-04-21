package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap

class NumberCharacter(image: ArrayList<Bitmap>) : Character(image), ObjectsInGameInterface {

    var value : Int? = null

    override var x = (getScreenWidth()*0.5).toInt()
    override var y = (getScreenHeight()*0.5).toInt()

    override var h = image[0].height /10
    override var w = image[0].width /10

    override val imageList : ArrayList<Bitmap> = image



     override fun update() {

    }

    override fun isTaken() {
        imageList[0].recycle()
    }

    fun getValue() : Int{
        return this.value!!
    }

    fun setValue(value : Int){
        this.value=value
    }
}