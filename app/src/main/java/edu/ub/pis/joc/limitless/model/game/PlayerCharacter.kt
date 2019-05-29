package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap
import edu.ub.pis.joc.limitless.view.ViewAdjuster.screenHeight
import edu.ub.pis.joc.limitless.view.ViewAdjuster.screenWidth
import edu.ub.pis.joc.limitless.view.end_game
import java.lang.Math.abs

class PlayerCharacter(image: ArrayList<Bitmap>, posX: Int, posY: Int) : Character(image, posX, posY), PlayerCharacterInterface {

    override var w: Int = (screenWidth * 0.08981).toInt()
    override var h: Int = (screenHeight * 0.044378).toInt()

    var accumulate: Int = 0

    override fun update(_x: Int, _y: Int, canFast: Boolean) {
        if (canFast) {
            moveFast(_x, _y)
        } else {
            moveNormal(_x, _y)
        }
    }
    /*
    Funcio que al colissionar amb una moneda farà que se li sumi el seu valor al comptador i retorni
    cert o fals si l'ha tocat o no.
    @params : Coin

    @return : Boolean
     */
    override fun takesCoin(coin: Coin) : Boolean {
        if (this.rect.intersect(coin.rect) && coin.activeCoin) {
            accumulate += coin.value
            return true
        }
        return false
    }


    //elimina totalment el bitmap de la surfaceview
    override fun die() {
        this.imageList[0].recycle()
        end_game = true
    }
    /*
    Funció que permet el moviment del personatge principal per la pantalla, aquest moviment es produeix
    quan arrosseguem el dit per la pantalla
    @params : Int
    @params : Int
     */
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
    /*
    A diferència de l'anterior moveNormal, aquest es caracteritza per moure's ràpidament d'un lloc a un
    altre quan fem tocs a la pantalla
    @params : Int
    @params : Int
     */
    fun moveFast(_x: Int, _y: Int) {

        var xVelocity: Int = (abs(_x - x) / 3)*2
        var yVelocity: Int = (abs(_y - y) / 3)*2

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