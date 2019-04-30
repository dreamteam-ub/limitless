package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Matrix


class EyeProjectile (image:ArrayList<Bitmap>, posX: Int, posY: Int) : Enemy(image, posX, posY) {

    override var xVelocity: Int = 26
    override var yVelocity: Int = 26

    var chosenWAndH = false

    fun chooseWidhtAndHeight(){
        when (concreteBehavior) {
            0 -> {
                w = imageList[0].width/8
                h = imageList[0].height/8
            }
            4 -> {
                w = imageList[0].width/8
                h = imageList[0].height/8
            }
            2 -> {
                w = imageList[2].width/8
                h = imageList[2].height/8
            }
            6 -> {
                w = imageList[2].width/8
                h = imageList[2].height/8
            }
            else -> {
                //Arriba
                w = imageList[3].width/8
                h = imageList[3].height/8
            }
        }
    }


    override var activeEnemy = true

    override fun update() {
        dissapearTimer--

        when (concreteBehavior) {
            0 -> {
                //Abajo
                y += yVelocity
            }
            1 -> {
            //Abajo Izquierda
            x -= xVelocity
            y += yVelocity
            }
            2 -> {
                //Izquierda
                x -= xVelocity
            }
            3 -> {
                //Arriba Izquierda
                x -= xVelocity
                y -= yVelocity
            }
            4 -> {
                //Arriba
                y -= yVelocity
            }
            5 -> {
                //Arriba Derecha
                x += xVelocity
                y -= yVelocity
            }
            6 -> {
                //Derecha
                x += xVelocity
            }
            7 -> {
                //Abajo Derecha
                x += xVelocity
                y += yVelocity
            }
        }
    }

    override fun draw(canvas: Canvas) {
        if(!chosenWAndH){
            chooseWidhtAndHeight()
            chosenWAndH=true
        }
        val halfW: Int = w / 2
        val halfH: Int = h / 2
        rect.set(x - halfW, y - halfH, x + halfW, y + halfH)
        when (concreteBehavior) {
            0 -> {
                //Abajo
                canvas.drawBitmap(imageList[0], null, rect, null)
            }
            1 -> {
                //Abajo Izquierda
                canvas.drawBitmap(imageList[1], null, rect, null)
            }
            2-> {
                //Izquierda
                canvas.drawBitmap(imageList[2], null, rect, null)
            }
            3-> {
                //Arriba Izquierda
                canvas.drawBitmap(imageList[3], null, rect, null)
            }
            4-> {
                //Arriba
                canvas.drawBitmap(imageList[4], null, rect, null)
            }
            5-> {
                //Arriba Derecha
                canvas.drawBitmap(imageList[5], null, rect, null)
            }
            6-> {
                //Derecha
                canvas.drawBitmap(imageList[6], null, rect, null)
            }
            7-> {
                //Abajo Derecha
                canvas.drawBitmap(imageList[7], null, rect, null)
            }
        }
    }

}