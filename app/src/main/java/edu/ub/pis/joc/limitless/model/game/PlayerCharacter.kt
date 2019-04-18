package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap
import java.lang.Math.abs

class PlayerCharacter(image: Bitmap) : Character(image), PlayerCharacterInterface {

    init {
        w = image.width / 3
        h = image.height / 3

        x = (getScreenWidth()*0.5).toInt()
        y = (getScreenHeight()*0.5).toInt()
    }


    override fun update(_x: Int, _y: Int, canFast: Boolean) {
        if (canFast) {
            moveFast(_x, _y)
        } else {
            moveNormal(_x, _y)
        }
    }

    override fun playerTakesNumber(number: Number) {

        if (this.rect.intersect(number.rect)) {
            //get number value etc etc
            number.isTaken()
        }
    }


    //elimina totalment el bitmap de la surfaceview
    override fun die() {
        this.image.recycle()
    }

    fun moveNormal(_x: Int, _y: Int) {

        x = _x
        y = _y

        if(_x<=getScreenWidth()*0.1+w/2){
            x = (getScreenWidth()*0.1).toInt()+w/2
        }

        if(_x>=getScreenWidth()*0.9-w/2){
            x = (getScreenWidth()*0.9).toInt()-w/2
        }

        if(_y<=getScreenHeight()*0.1+h/2){
            y = (getScreenHeight()*0.1).toInt()+h/2
        }

        if(_y>=getScreenHeight()*0.9-h/2){
            y = (getScreenHeight()*0.9).toInt()-h/2
        }

    }

    fun moveFast(_x: Int, _y: Int) {

        var xVelocity: Int = abs(_x - x) / 3
        var yVelocity: Int = abs(_y - y) / 3

        if (_x < x) {
            xVelocity *= -1
        }

        if (_y < y) {
            yVelocity *= -1
        }

        if(_x<=getScreenWidth()*0.1+w/2){
            x = (getScreenWidth()*0.1).toInt()+w/2
            x -= (xVelocity)
        }

        if(_x>=getScreenWidth()*0.9-w/2){
            x = (getScreenWidth()*0.9).toInt()-w/2
            x -= (xVelocity)
        }

        if(_y<=getScreenHeight()*0.1+h/2){
            y = (getScreenHeight()*0.1).toInt()+h/2
            y -= (yVelocity)
        }

        if(_y>=getScreenHeight()*0.9-h/2){
            y = (getScreenHeight()*0.9).toInt()-h/2
            y -= (yVelocity)
        }

        x += (xVelocity)
        y += (yVelocity)

    }


}