package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap
import java.lang.Math.abs

class PlayerCharacter(image: Bitmap) : Character(image), PlayerCharacterInterface {

    init {
        w = image.width / 3
        h = image.height / 3

        x = getScreenWidth()
        y = getScreenHeight()
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

        var nX = _x
        var nY = _y

        x = _x
        y = _y

        if(_x<=getScreenWidth()*0.1+w){
            x = getScreenWidth()*0.1.toInt()+w
        }

        if(_x>=getScreenWidth()*0.9-w){
            x = getScreenWidth()*0.9.toInt()-w
        }

        if(_y<=getScreenHeight()*0.1+h){
            y = getScreenHeight()*0.1.toInt()+h
        }

        if(_y>=getScreenHeight()*0.9-h){
            y = getScreenHeight()*0.9.toInt()-h
        }


        /*
        if (_x >= getScreenWidth()*0.8 - w) {
            val resta = _x - (getScreenWidth()*0.8 - w)
            nX -= resta.toInt()
            x = nX
            y = nY

        }

        if (_x <= getScreenWidth()*0.4 + w) {
            val resta = w - _x
            nX += resta
            x = nX
            y = nY
        }

        if (_y >= getScreenHeight()*0.8 - h) {
            val resta = _y - (getScreenHeight()*0.8 - h)
            nY -= resta.toInt()
            y = nY
            x = nX
        }

        if (_y <= getScreenHeight()*0.4 + h) {
            val resta = h - _y
            nY += resta
            y = nY
            x = nX
        } else {
            x = nX
            y = nY
        }
        */

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

        x += (xVelocity)
        y += (yVelocity)

    }


}