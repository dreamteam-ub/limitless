package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap
import android.graphics.Canvas
import edu.ub.pis.joc.limitless.view.ViewAdjuster
import edu.ub.pis.joc.limitless.view.ViewAdjuster.screenHeight
import edu.ub.pis.joc.limitless.view.ViewAdjuster.screenWidth

class SkullLaser(image: ArrayList<Bitmap>, posX: Int, posY: Int, behaviour:Int,wSkull: Int,hSkull:Int) : Enemy(image, posX, posY,behaviour) {

    override var w: Int = CharacterData.wSkullLaser
    override var h: Int = CharacterData.hSkullLaser

    var contador : Int = 0

    override var activeEnemy = false

    override var concreteBehaviour = behaviour

    var left: Int
    var top: Int
    var right: Int
    var bottom : Int

    var firstDraw = true


    init {
        var degrees : Float
        when(concreteBehaviour){
            0->{
                degrees = 0f
                x= (ViewAdjuster.screenWidth*0.34).toInt()
                y= 0
                left = x-(w/2)
                top = y+(hSkull/2)
                right = x+(w/2)
                bottom = ViewAdjuster.screenHeight
            }
            1->{
                degrees = 0f
                x= (ViewAdjuster.screenWidth*0.67).toInt()
                y= 0
                left = x-(w/2)
                top = y+(hSkull/2)
                right = x+(w/2)
                bottom = ViewAdjuster.screenHeight
            }
            2->{
                degrees = 90f
                x= ViewAdjuster.screenWidth
                y= (ViewAdjuster.screenHeight*0.25).toInt()
                w = CharacterData.hSkullLaser
                h = CharacterData.wSkullLaser
                left = 0
                top = y-(h/2)
                right = x-(wSkull/2)
                bottom = y+(h/2)
            }
            3->{
                degrees = 90f
                x= ViewAdjuster.screenWidth
                y= (ViewAdjuster.screenHeight*0.5).toInt()
                w = CharacterData.hSkullLaser
                h = CharacterData.wSkullLaser
                left = 0
                top = y-(h/2)
                right = x-(wSkull/2)
                bottom = y+(h/2)
            }
            4->{
                degrees = 90f
                x= ViewAdjuster.screenWidth
                y= (ViewAdjuster.screenHeight*0.75).toInt()
                w = CharacterData.hSkullLaser
                h = CharacterData.wSkullLaser
                left = 0
                top = y-(h/2)
                right = x-(wSkull/2)
                bottom = y+(h/2)
            }
            5->{
                degrees = 180f
                x= (ViewAdjuster.screenWidth*0.67).toInt()
                y= ViewAdjuster.screenHeight
                left = x-(w/2)
                top = 0
                right = x+(w/2)
                bottom = y-(hSkull/2)
            }
            6->{
                degrees = 180f
                x= (ViewAdjuster.screenWidth*0.34).toInt()
                y= ViewAdjuster.screenHeight
                left = x-(w/2)
                top = 0
                right = x+(w/2)
                bottom = y-(hSkull/2)
            }
            7->{
                degrees = 270f
                x= 0
                y= (ViewAdjuster.screenHeight*0.75).toInt()
                w = CharacterData.hSkullLaser
                h = CharacterData.wSkullLaser
                left = x+(wSkull/2)
                top = y-(h/2)
                right = ViewAdjuster.screenWidth
                bottom = y+(h/2)
            }
            8->{
                degrees = 270f
                x= 0
                y= (ViewAdjuster.screenHeight*0.5).toInt()
                w = CharacterData.hSkullLaser
                h = CharacterData.wSkullLaser
                left = x+(wSkull/2)
                top = y-(h/2)
                right = ViewAdjuster.screenWidth
                bottom = y+(h/2)
            }
            9->{
                degrees = 270f
                x= 0
                y= (ViewAdjuster.screenHeight*0.25).toInt()
                w = CharacterData.hSkullLaser
                h = CharacterData.wSkullLaser
                left = x+(wSkull/2)
                top = y-(h/2)
                right = ViewAdjuster.screenWidth
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

        if (degrees > 0.0f) {
            rotate(degrees)
        }

    }

    override fun update() {
        dissapearTimer--
    }

    override fun draw(canvas: Canvas){

        if(firstDraw) {
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
            }
            contador = (contador + 1)
            if (contador == 43) {
                firstDraw = false
                contador = 0
            }
        } else {
            if(dissapearTimer<=42){
                if (dissapearTimer == 42) {
                    canvas.drawBitmap(imageList[7], null, rect, null)
                } else if (dissapearTimer == 41) {
                    canvas.drawBitmap(imageList[6], null, rect, null)
                } else if (dissapearTimer == 40) {
                    activeEnemy = false
                    canvas.drawBitmap(imageList[5], null, rect, null)
                } else if (dissapearTimer == 39) {
                    canvas.drawBitmap(imageList[4], null, rect, null)
                } else if (dissapearTimer == 38) {
                    canvas.drawBitmap(imageList[3], null, rect, null)
                } else if (dissapearTimer == 37) {
                    canvas.drawBitmap(imageList[2], null, rect, null)
                }else if (dissapearTimer in 34..36) {
                    canvas.drawBitmap(imageList[1], null, rect, null)
                } else if (dissapearTimer in 31..33) {
                    canvas.drawBitmap(imageList[0], null, rect, null)
                } else if (dissapearTimer in 28..30) {
                    canvas.drawBitmap(imageList[1], null, rect, null)
                } else if (dissapearTimer in 25..27) {
                    canvas.drawBitmap(imageList[0], null, rect, null)
                }else if (dissapearTimer in 22..24) {
                    canvas.drawBitmap(imageList[1], null, rect, null)
                } else if (dissapearTimer in 19..21) {
                    canvas.drawBitmap(imageList[0], null, rect, null)
                } else if (dissapearTimer in 16..18) {
                    canvas.drawBitmap(imageList[1], null, rect, null)
                } else if (dissapearTimer in 13..15) {
                    canvas.drawBitmap(imageList[0], null, rect, null)
                }
            } else {
                if (contador == 0) {
                    //Skull 8
                    canvas.drawBitmap(imageList[8], null, rect, null)
                } else if (contador == 1) {
                    //Skull 8 Light
                    canvas.drawBitmap(imageList[9], null, rect, null)
                }
                contador = (contador + 1) % 2
            }
        }
    }
}