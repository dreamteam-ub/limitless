package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.Data.screenHeight
import edu.ub.pis.joc.limitless.model.Data.screenWidth
import kotlin.math.sin

class Eye(image: ArrayList<Bitmap>, posX: Int, posY: Int) : Enemy(image, posX, posY) {

    override var xVelocity: Int = 10
    override var yVelocity: Int = 9


    override var h = image[0].height / 10
    override var w = image[0].width / 10

    var contador : Int = 0
    override fun update() {
        dissapearTimer--
        contador++
        when (concreteBehavior) {
            0 -> {
                //Amunt i avall desde esquerra
                x += xVelocity
                y += yVelocity
                if(contador==10){
                    yVelocity *= -1
                    contador = 0
                }
            }
            1 -> {
                //Izquierda
                x -= xVelocity
            }
            2 -> {
                //Arriba
                y -= yVelocity
            }
            3 -> {
                //Derecha
                x += xVelocity
            }
            4 -> {
                //Abajo Izquierda
                x -= xVelocity
                y += yVelocity
            }
            5 -> {
                //Arriba Izquierda
                x -= xVelocity+5
                y -= yVelocity+5
            }
            6 -> {
                //Arriba Derecha
                x += xVelocity+5
                y -= yVelocity+5
            }
            7 -> {
                //Abajo Derecha
                x += xVelocity+5
                y += yVelocity+5
            }
        }
    }

}