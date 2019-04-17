package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap
import java.lang.Math.abs

class PlayerCharacter(image: Bitmap) : Character(image), PlayerCharacterInterface {

    init {
        w = image.width / 3
        h = image.height / 3

        x = getScreenWidth()/2
        y = getScreenHeight()/2
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



        if (_x >= getScreenWidth() - w) {
            val resta = _x - (getScreenWidth() - w)
            nX -= resta
            x = nX
            y = nY

        }

        if (_x <= 0 + w) {
            val resta = w - _x
            nX += resta
            x = nX
            y = nY
        }

        if (_y >= getScreenHeight() - h) {
            val resta = _y - (getScreenHeight() - h)
            nY -= resta
            y = nY
            x = nX
        }

        if (_y <= 0 + h) {
            val resta = h - _y
            nY += resta
            y = nY
            x = nX
        } else {
            x = nX
            y = nY
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

        x += (xVelocity)
        y += (yVelocity)

    }


}