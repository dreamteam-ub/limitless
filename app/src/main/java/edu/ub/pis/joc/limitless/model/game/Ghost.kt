package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap
import edu.ub.pis.joc.limitless.view.ViewAdjuster
import edu.ub.pis.joc.limitless.view.ViewAdjuster.screenHeight
import edu.ub.pis.joc.limitless.view.ViewAdjuster.screenWidth
import kotlin.math.PI
import kotlin.math.sin

class Ghost(image: ArrayList<Bitmap>, posX: Int, posY: Int, behaviour: Int) : Enemy(image, posX, posY, behaviour) {

    override var w: Int = (screenWidth * 0.137962).toInt()
    override var h: Int = (screenHeight * 0.071499).toInt()

    override var xVelocity: Int = 20
    override var yVelocity: Int = 20

    override var activeEnemy: Boolean = true

    override var concreteBehaviour = behaviour

    var yOriginal = posY

    override fun update() {

        if (dissapearTimer > 0) {
            dissapearTimer--
        }

        if (dissapearTimer == 0) {
            if (x <= 0 || x >= ViewAdjuster.screenWidth || y <= 0 || y >= ViewAdjuster.screenHeight) {
                dissapearTimer = -1
            }
        }

        when (concreteBehaviour) {
            0 -> {
                if ((x >= ViewAdjuster.screenWidth && xVelocity > 0) || (x <= 0 && xVelocity < 0)) {
                    xVelocity *= -1
                }
                if ((y >= ViewAdjuster.screenHeight && yVelocity > 0) || (y <= 0 && yVelocity < 0)) {
                    yVelocity *= -1
                }

                x += (xVelocity)
                y += (yVelocity)
            }
            1 -> {
                if ((y >= ViewAdjuster.screenHeight && yVelocity > 0) || (y <= 0 && yVelocity < 0)) {
                    yVelocity *= -1
                }
                y += (yVelocity)
                //movimiento vertical


            }
            2 -> {
                if ((x >= ViewAdjuster.screenWidth && xVelocity > 0) || (x <= 0 && xVelocity < 0)) {
                    xVelocity *= -1
                }
                x += (xVelocity)
                //movimiento horizontal
            }
            3 -> {
                //Sinusoidal esquerra a dreta
                val altura = ViewAdjuster.screenHeight * 0.05 //Subir el multiplicador para mas altura
                val movimientos = 2 //Se haran tantos movimientos sinusoidales
                x += xVelocity
                y = yOriginal - (sin(((x.toDouble() / ViewAdjuster.screenWidth) * movimientos * 2 * PI)) * altura).toInt()
            }
            4 -> {
                //Sinusoidal dreta a esquerra
                val altura = ViewAdjuster.screenHeight * 0.05 //Subir el multiplicador para mas altura
                val movimientos = 2 //Se haran tantos movimientos sinusoidales
                x -= xVelocity
                y = yOriginal - (sin(((x.toDouble() / ViewAdjuster.screenWidth) * movimientos * 2 * PI)) * altura).toInt()
            }
        }
    }


}