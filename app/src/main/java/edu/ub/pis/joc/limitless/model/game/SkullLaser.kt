package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap
import android.graphics.Canvas
import android.util.Log
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.Data.screenHeight

class SkullLaser(image: ArrayList<Bitmap>, posX: Int, posY: Int, behaviour:Int,wSkull: Int,hSkull:Int) : Enemy(image, posX, posY,behaviour) {

    override var h = image[0].height
    override var w = image[0].width

    var contador : Int = 0

    override var activeEnemy = false

    override var concreteBehaviour = behaviour

    var left: Int
    var top: Int
    var right: Int
    var bottom : Int


    init {
        var degrees : Float
        when(concreteBehaviour){
            0->{
                degrees = 0f
                x= (Data.screenWidth*0.34).toInt()
                y= 0
                left = x-(w/2)
                top = y+(hSkull/2)
                right = x+(w/2)
                bottom = Data.screenHeight
            }
            1->{
                degrees = 0f
                x= (Data.screenWidth*0.67).toInt()
                y= 0
                left = x-(w/2)
                top = y+(hSkull/2)
                right = x+(w/2)
                bottom = Data.screenHeight
            }
            2->{
                degrees = 90f
                x= Data.screenWidth
                y= (Data.screenHeight*0.25).toInt()
                w = imageList[0].height
                h = imageList[0].width
                left = 0
                top = y-(h/2)
                right = x-(wSkull/2)
                bottom = y+(h/2)
            }
            3->{
                degrees = 90f
                x= Data.screenWidth
                y= (Data.screenHeight*0.5).toInt()
                w = imageList[0].height
                h = imageList[0].width
                left = 0
                top = y-(h/2)
                right = x-(wSkull/2)
                bottom = y+(h/2)
            }
            4->{
                degrees = 90f
                x= Data.screenWidth
                y= (Data.screenHeight*0.75).toInt()
                w = imageList[0].height
                h = imageList[0].width
                left = 0
                top = y-(h/2)
                right = x-(wSkull/2)
                bottom = y+(h/2)
            }
            5->{
                degrees = 180f
                x= (Data.screenWidth*0.67).toInt()
                y= Data.screenHeight
                left = x-(w/2)
                top = 0
                right = x+(w/2)
                bottom = y-(hSkull/2)
            }
            6->{
                degrees = 180f
                x= (Data.screenWidth*0.34).toInt()
                y= Data.screenHeight
                left = x-(w/2)
                top = 0
                right = x+(w/2)
                bottom = y-(hSkull/2)
            }
            7->{
                degrees = 270f
                x= 0
                y= (Data.screenHeight*0.75).toInt()
                w = imageList[0].height
                h = imageList[0].width
                left = x+(wSkull/2)
                top = y-(h/2)
                right = Data.screenWidth
                bottom = y+(h/2)
            }
            8->{
                degrees = 270f
                x= 0
                y= (Data.screenHeight*0.5).toInt()
                w = imageList[0].height
                h = imageList[0].width
                left = x+(wSkull/2)
                top = y-(h/2)
                right = Data.screenWidth
                bottom = y+(h/2)
            }
            9->{
                degrees = 270f
                x= 0
                y= (Data.screenHeight*0.25).toInt()
                w = imageList[0].height
                h = imageList[0].width
                left = x+(wSkull/2)
                top = y-(h/2)
                right = Data.screenWidth
                bottom = y+(h/2)
            }
            else->{
                degrees = 0f
                x= 0
                y= 0
                left = 0
                top = 0
                right = 0
                bottom = 0
            }
        }

        rect.set(left, top,right, bottom)
        rotate(degrees)

    }

    override fun update() {

    }

    override fun draw(canvas: Canvas){
        Log.d("LEFT",left.toString())
        Log.d("TOP",top.toString())
        Log.d("RIGHT",right.toString())
        Log.d("BOTTOM", bottom.toString())
        Log.d("W", w.toString())
        Log.d("H", h.toString())
        if (contador in 13..15){
            //Beam 1 - Corresponde a Skull 4
            canvas.drawBitmap(imageList[0], null, rect, null)
        } else if (contador in 16..18){
            //Beam 1 Light - Corresponde a Skull 4 Light
            canvas.drawBitmap(imageList[1], null, rect, null)
        } else if (contador in 19..21){
            //Beam 1 - Corresponde a Skull 4
            canvas.drawBitmap(imageList[0], null, rect, null)
        } else if (contador in 22..24){
            //Beam 1 Light - Corresponde a Skull 4 Light
            canvas.drawBitmap(imageList[1], null, rect, null)
        } else if (contador in 25..27){
            //Beam 1 - Corresponde a Skull 4
            canvas.drawBitmap(imageList[0], null, rect, null)
        } else if (contador in 28..30){
            //Beam 1 Light - Corresponde a Skull 4 Light
            canvas.drawBitmap(imageList[1], null, rect, null)
        } else if (contador in 31..33){
            //Beam 1 - Corresponde a Skull 4
            canvas.drawBitmap(imageList[0], null, rect, null)
        } else if (contador in 34..36){
            //Beam 1 Light - Corresponde a Skull 4 Light
            canvas.drawBitmap(imageList[1], null, rect, null)
        } else if (contador == 37){
            //Beam 2 - Corresponde a Skull 5
            canvas.drawBitmap(imageList[2], null, rect, null)
        } else if (contador == 38){
            //Beam 2 Light - Corresponde a Skull 5 Light
            canvas.drawBitmap(imageList[3], null, rect, null)
        } else if (contador == 39){
            //Beam 3 - Corresponde a Skull 6
            canvas.drawBitmap(imageList[4], null, rect, null)
        } else if (contador == 40){
            //Beam 3 Light - Corresponde a Skull 6 Light
            canvas.drawBitmap(imageList[5], null, rect, null)
        } else if (contador == 41){
            //Beam 4 - Corresponde a Skull 7
            activeEnemy = true
            canvas.drawBitmap(imageList[6], null, rect, null)
        } else if (contador == 42){
            //Beam 4 Light - Corresponde a Skull 7 Light
            canvas.drawBitmap(imageList[7], null, rect, null)
        } else if (contador == 43){
            //Beam 5 - Corresponde a Skull 8
            canvas.drawBitmap(imageList[8], null, rect, null)
        } else if (contador == 44){
            //Beam 5 Light - Corresponde a Skull 8 Light
            canvas.drawBitmap(imageList[9], null, rect, null)
        } else if (contador == 45){
            //Beam 5 - Corresponde a Skull 8
            canvas.drawBitmap(imageList[8], null, rect, null)
        } else if (contador == 46){
            //Beam 5 Light - Corresponde a Skull 8 Light
            canvas.drawBitmap(imageList[9], null, rect, null)
        } else if (contador == 47){
            //Beam 5 - Corresponde a Skull 8
            canvas.drawBitmap(imageList[8], null, rect, null)
        } else if (contador == 48){
            //Beam 5 Light - Corresponde a Skull 8 Light
            canvas.drawBitmap(imageList[9], null, rect, null)
        } else if (contador == 49){
            //Beam 5 - Corresponde a Skull 8
            canvas.drawBitmap(imageList[8], null, rect, null)
        } else if (contador == 50){
            //Beam 5 Light - Corresponde a Skull 8 Light
            canvas.drawBitmap(imageList[9], null, rect, null)
        } else if (contador == 51){
            //Beam 5 - Corresponde a Skull 8
            canvas.drawBitmap(imageList[8], null, rect, null)
        } else if (contador == 52){
            //Beam 5 Light - Corresponde a Skull 8 Light
            canvas.drawBitmap(imageList[9], null, rect, null)
        } else if (contador == 53){
            //Beam 5 - Corresponde a Skull 8
            canvas.drawBitmap(imageList[8], null, rect, null)
        } else if (contador == 54) {
            //Beam 5 Light - Corresponde a Skull 8 Light
            canvas.drawBitmap(imageList[9], null, rect, null)
        } else if (contador == 55){
            //Beam 5 - Corresponde a Skull 8
            canvas.drawBitmap(imageList[8], null, rect, null)
        } else if (contador == 56) {
            //Beam 5 Light - Corresponde a Skull 8 Light
            canvas.drawBitmap(imageList[9], null, rect, null)
            dissapearTimer = 0
        }

        contador = (contador+1) % 57

    }
}