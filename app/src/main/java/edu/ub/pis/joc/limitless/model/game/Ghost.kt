package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap
import android.util.Log
import edu.ub.pis.joc.limitless.model.Data

class Ghost(image: ArrayList<Bitmap>, posX: Int, posY: Int, behaviour:Int) : Enemy(image, posX, posY,behaviour) {

    override var xVelocity: Int = 20
    override var yVelocity: Int = 20

    override var h = image[0].height /8
    override var w = image[0].width /8

    override var activeEnemy: Boolean = true

    override var concreteBehaviour = behaviour

    override fun update() {

       this.dissapearTimer--

        when (concreteBehaviour) {
            0 -> {
                if (x >= Data.screenWidth || ((x <= 0)&& xVelocity<0) ) {
                    xVelocity *= -1
                }
                if (y >= Data.screenHeight || ((y <= 0)&& yVelocity<0)) {
                    Log.d("Y CHANGE","oof")
                    yVelocity *= -1
                }

                x += (xVelocity)
                y += (yVelocity)
            }
            1 -> {
                if (y > Data.screenHeight - h || y < h) {
                    yVelocity *= -1
                }
                y += (yVelocity)
                //movimiento vertical


            }
            2-> {
                if (x > Data.screenWidth - w || x < w){
                    xVelocity *= -1
                }
                x += (xVelocity)
                //movimiento horizontal
            }
        }
    }


}