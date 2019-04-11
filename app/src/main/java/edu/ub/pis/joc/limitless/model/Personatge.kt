package edu.ub.pis.joc.limitless.model

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import java.util.concurrent.ThreadLocalRandom

class Personatge(var image: Bitmap) {
    var x: Int = 0
    var y: Int = 0
    var w: Int = 0
    var h: Int = 0
    private var xVelocity = 20
    private var yVelocity = 20
    private val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    private val screenHeight = Resources.getSystem().displayMetrics.heightPixels

    init {
        w = image.width
        h = image.height

        x = screenWidth/2
        y = screenHeight/2
    }

    /**
     * Draws the object on to the canvas.
     */
    fun draw(canvas: Canvas) {
        canvas.drawBitmap(image, x.toFloat(), y.toFloat(), null)
    }

    /**
     * update properties for the game object
     */
    fun update() {
        //val randomNum = ThreadLocalRandom.current().nextInt(1, 5)

        if (x > screenWidth - image.width || x < image.width) {
            xVelocity = xVelocity * -1
        }
        if (y > screenHeight - image.height || y < image.height) {
            yVelocity = yVelocity * -1
        }

        x += (xVelocity)
        y += (yVelocity)

    }

}