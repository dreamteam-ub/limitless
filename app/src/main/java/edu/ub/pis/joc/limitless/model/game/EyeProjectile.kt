package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Matrix
import edu.ub.pis.joc.limitless.model.Data


class EyeProjectile (image:ArrayList<Bitmap>, posX: Int, posY: Int, behaviour : Int) : Enemy(image, posX, posY,behaviour) {

    override var xVelocity: Int = 26
    override var yVelocity: Int = 26

    var chosenWAndH = false

    override var concreteBehaviour = behaviour

    override var activeEnemy = true

    fun chooseWidhtAndHeight(){
        when (concreteBehaviour) {
            0 -> {
                w = imageList[0].width
                h = imageList[0].height
            }
            4 -> {
                w = imageList[0].width
                h = imageList[0].height
            }
            2 -> {
                w = imageList[2].width
                h = imageList[2].height
            }
            6 -> {
                w = imageList[2].width
                h = imageList[2].height
            }
            else -> {
                //Arriba
                w = imageList[3].width
                h = imageList[3].height
            }
        }
    }

    override fun update() {
        if(dissapearTimer > 0){
            dissapearTimer--
        }

        if(dissapearTimer == 0){
            if(x<=0 || x>= Data.screenWidth || y<=0 || y>= Data.screenHeight){
                dissapearTimer = -1
            }
        }

        when (concreteBehaviour) {
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
        when (concreteBehaviour) {
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