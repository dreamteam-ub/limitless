package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap
import edu.ub.pis.joc.limitless.model.Data.screenHeight
import edu.ub.pis.joc.limitless.model.Data.screenWidth
import java.lang.Math.abs

class PlayerCharacter(image: ArrayList<Bitmap>, posX: Int, posY: Int) : Character(image, posX, posY), PlayerCharacterInterface {

    var accumulate: Int = 0

    override var w = image[0].width / 6
    override var h = image[0].height / 6

    override fun update(_x: Int, _y: Int, canFast: Boolean) {
        if (canFast) {
            moveFast(_x, _y)
        } else {
            moveNormal(_x, _y)
        }
    }

    override fun takesCoin(coin: Coin) {

        if (this.rect.intersect(coin.rect)) {
            accumulate += coin.value
            coin.isTaken()
        }
    }


    //elimina totalment el bitmap de la surfaceview
    override fun die() {
        this.imageList[0].recycle()
    }

    fun moveNormal(_x: Int, _y: Int) {

        x = _x
        y = _y

        if (_x <= screenWidth * 0.1 + w / 2) {
            x = (screenWidth * 0.1).toInt() + w / 2
        }

        if (_x >= screenWidth * 0.9 - w / 2) {
            x = (screenWidth * 0.9).toInt() - w / 2
        }

        if (_y <= screenHeight * 0.1 + h / 2) {
            y = (screenHeight * 0.1).toInt() + h / 2
        }

        if (_y >= screenHeight * 0.9 - h / 2) {
            y = (screenHeight * 0.9).toInt() - h / 2
        }

    }

    fun moveFast(_x: Int, _y: Int) {

        var xVelocity: Int = abs(_x - x) / 3
        var yVelocity: Int = abs(_y - y) / 3

        var xOutOfBorder: Boolean = false
        var yOutOfBorder: Boolean = false

        if (_x < x) {
            xVelocity *= -1
        }

        if (_y < y) {
            yVelocity *= -1
        }

        if (_x <= (screenWidth * 0.1).toInt() + w / 2) {
            xOutOfBorder = true
            if (x + (xVelocity) >= (screenWidth * 0.1).toInt() + w / 2) {
                x += (xVelocity)
            } else {
                x = (screenWidth * 0.1).toInt() + w / 2
            }
        }

        if (_x >= (screenWidth * 0.9).toInt() - w / 2) {
            xOutOfBorder = true
            if (x + (xVelocity) <= (screenWidth * 0.9).toInt() - w / 2) {
                x += (xVelocity)
            } else {
                x = (screenWidth * 0.9).toInt() - w / 2
            }
        }

        if (_y <= (screenHeight * 0.1).toInt() + h / 2) {
            yOutOfBorder = true
            if (y + (yVelocity) >= (screenHeight * 0.1).toInt() + h / 2) {
                y += (yVelocity)
            } else {
                y = (screenHeight * 0.1).toInt() + h / 2
            }
        }

        if (_y >= (screenHeight * 0.9).toInt() - h / 2) {
            yOutOfBorder = true
            if (y + (yVelocity) <= (screenHeight * 0.9).toInt() - h / 2) {
                y += (yVelocity)
            } else {
                y = (screenHeight * 0.9).toInt() - h / 2
            }
        }

        if (!xOutOfBorder) {
            x += (xVelocity)
        }
        if (!yOutOfBorder) {
            y += (yVelocity)
        }

    }

}