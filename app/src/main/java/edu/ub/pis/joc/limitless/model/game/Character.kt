package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Rect

abstract class Character(image: ArrayList<Bitmap>, posX: Int, posY: Int) {

    //posicion inicial
    open var x: Int = posX
    open var y: Int = posY

    //medida imagen
    open var w: Int = image[0].width
    open var h: Int = image[0].height

    open val imageList: ArrayList<Bitmap> = image

    open var dissapearTimer : Int = 0


    var rect: Rect = Rect() //hitbox

    open fun rotate(degrees : Float) {
        val matrix = Matrix()
        matrix.postRotate(degrees)

        for ((i, img) in imageList.withIndex()) {
            imageList[i] = Bitmap.createBitmap(img, 0, 0, img.width, img.height, matrix, true)
        }
    }

    /**
     * Draws the object on to the canvas.
     */
    open fun draw(canvas: Canvas) {
        //vamos a hacer nosotros mismos las coordenadas left,top,right y bottom para meterlas en
        //el hitbox
        val halfW: Int = w / 2
        val halfH: Int = h / 2
        rect.set(x - halfW, y - halfH, x + halfW, y + halfH)
        canvas.drawBitmap(imageList[0], null, rect, null)
    }

    fun recycleBitmapArray(image : ArrayList<Bitmap>){
        for (i in 0 until image.size){
            image[i].recycle()
        }
    }

}