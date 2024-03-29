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

    var imageList: ArrayList<Bitmap> = image

    open var dissapearTimer : Int = 0
    open var appearTime : Long = 0L

    var rect: Rect = Rect() //hitbox
    /**
    Funcio que permetrà rotar la nostra imatge els graus que vulguem
    *@param Float
     */
    open fun rotate(degrees : Float) {
        val matrix = Matrix()
        matrix.postRotate(degrees)

        val tmpImgList = ArrayList<Bitmap>(imageList.size)
        for (img in imageList) {
            tmpImgList.add(Bitmap.createBitmap(img, 0, 0, img.width, img.height, matrix, false))
        }
        imageList = tmpImgList
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

}