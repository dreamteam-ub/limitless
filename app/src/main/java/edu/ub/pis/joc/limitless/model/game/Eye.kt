package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap
import android.graphics.Canvas
import android.util.Log
import edu.ub.pis.joc.limitless.model.Data
import kotlin.math.PI
import kotlin.math.sin
import kotlin.math.abs

class Eye(image: ArrayList<Bitmap>, posX: Int, posY: Int) : Enemy(image, posX, posY) {

    override var xVelocity: Int = 10
    override var yVelocity: Int = 9

    override var h = image[0].height / 10
    override var w = image[0].width / 10

    var yOriginal = posY
    var xOriginal = posX

    var contador : Int = 0
    override fun update() {
        dissapearTimer--
        when (concreteBehavior) {
            0 -> {
                //Sinusoidal esquerra a dreta
                var altura = Data.screenHeight*0.05 //Subir el multiplicador para mas altura
                var movimientos = 2 //Se haran tantos movimientos sinusoidales
                x += xVelocity
                y = yOriginal-(sin(((x.toDouble()/Data.screenWidth)*movimientos*2*PI))*altura).toInt()
            }
            1 -> {
                //Sinusoidal dreta a esquerra
                var altura = Data.screenHeight*0.05 //Subir el multiplicador para mas altura
                var movimientos = 2 //Se haran tantos movimientos sinusoidales
                x -= xVelocity
                y = yOriginal-(sin(((x.toDouble()/Data.screenWidth)*movimientos*2*PI))*altura).toInt()
            }
            2 -> {
                //Sinusoidal dalt a baix
                var altura = Data.screenWidth*0.1 //Subir el multiplicador para mas altura
                var movimientos = 6 //Se haran tantos movimientos sinusoidales
                x = xOriginal-(sin(((y.toDouble()/Data.screenHeight)*movimientos*2*PI))*altura).toInt()
                y += (1.3*yVelocity).toInt() //A mas multiplicador mas rapido ira
            }
            3 -> {
                //Sinusoidal baix a dalt
                var altura = Data.screenWidth*0.1 //Subir el multiplicador para mas altura
                var movimientos = 6 //Se haran tantos movimientos sinusoidales
                x = xOriginal-(sin(((y.toDouble()/Data.screenHeight)*movimientos*2*PI))*altura).toInt()
                y -= (1.3*yVelocity).toInt() //A mas multiplicador mas rapido ira
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

    override fun draw (canvas:Canvas){
        val halfW: Int = w / 2
        val halfH: Int = h / 2
        rect.set(x - halfW, y - halfH, x + halfW, y + halfH)
        if (contador <= 3) {
            canvas.drawBitmap(imageList[0], null, rect, null)
        } else if (contador <= 6) {
            canvas.drawBitmap(imageList[1], null, rect, null)
        } else if (contador <= 9) {
            canvas.drawBitmap(imageList[2], null, rect, null)
        } else if (contador <= 12) {
            canvas.drawBitmap(imageList[3], null, rect, null)
        } else if (contador <= 15) {
            canvas.drawBitmap(imageList[4], null, rect, null)
        } else if (contador <= 18) {
            canvas.drawBitmap(imageList[5], null, rect, null)
        } else if (contador <= 21) {
            canvas.drawBitmap(imageList[4], null, rect, null)
        } else if (contador <= 24) {
            canvas.drawBitmap(imageList[3], null, rect, null)
        } else if (contador <= 27) {
            canvas.drawBitmap(imageList[2], null, rect, null)
        } else if (contador <= 30) {
            canvas.drawBitmap(imageList[1], null, rect, null)
        }
        contador = (contador + 1) % 31
    }

}