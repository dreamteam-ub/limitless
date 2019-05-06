package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.util.Log
import java.lang.Math.*

class DemonFireColumn(image:ArrayList<Bitmap>, posX: Int, posY: Int) : Enemy(image, posX, posY) {
    override var xVelocity: Int = 26
    override var yVelocity: Int = 26

    override var w = image[0].width/8
    override var h = image[0].height/8

    var wDemon = 0
    var hDemon = 0
    var xDemon = 0
    var yDemon = 0

    var degrees = 0.0

    override var activeEnemy = true

    var contador: Int = 0

    override fun update() {
        dissapearTimer--
        x = (xDemon + ((hDemon/2)*sin(((degrees)*PI)/180))*1.5).toInt()
        y = (yDemon - ((hDemon/2)*cos(((degrees)*PI)/180))*1.5).toInt()
    }

    override fun draw(canvas: Canvas) {

        if (contador <= 3) {
            if(contador == 0){
                degrees = 0.0
            } else {
                degrees += 3.3
            }
            w = imageList[0].width/8
            h = imageList[0].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[0], null, rect, null)
        } else if (contador <= 6) {
            if(contador == 4){
                degrees = 10.0
            } else {
                degrees += 3.3
            }
            w = imageList[1].width/8
            h = imageList[1].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[1], null, rect, null)
        } else if (contador <= 9) {
            if(contador == 7){
                degrees = 20.0
            } else {
                degrees += 3.3
            }
            w = imageList[2].width/8
            h = imageList[2].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[2], null, rect, null)
        } else if (contador <= 12) {
            if(contador == 10){
                degrees = 30.0
            } else {
                degrees += 3.3
            }
            w = imageList[3].width/8
            h = imageList[3].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[3], null, rect, null)
        } else if (contador <= 15) {
            if(contador == 13){
                degrees = 40.0
            } else {
                degrees += 3.3
            }
            w = imageList[4].width/8
            h = imageList[4].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[4], null, rect, null)
        } else if (contador <= 18) {
            if(contador == 16){
                degrees = 50.0
            } else {
                degrees += 3.3
            }
            w = imageList[5].width/8
            h = imageList[5].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[5], null, rect, null)
        } else if (contador <= 21) {
            if(contador == 19){
                degrees = 60.0
            } else {
                degrees += 3.3
            }
            w = imageList[6].width/8
            h = imageList[6].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[6], null, rect, null)
        } else if (contador <= 24) {
            if(contador == 22){
                degrees = 70.0
            } else {
                degrees += 3.3
            }
            w = imageList[7].width/8
            h = imageList[7].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[7], null, rect, null)
        } else if (contador <= 27) {
            if(contador == 25){
                degrees = 80.0
            } else {
                degrees += 3.3
            }
            w = imageList[8].width/8
            h = imageList[8].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[8], null, rect, null)
        } else if (contador <= 30) {
            if(contador == 28){
                degrees = 90.0
            } else {
                degrees += 3.3
            }
            w = imageList[9].width/8
            h = imageList[9].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[9], null, rect, null)
        } else if (contador <= 33) {
            if(contador == 31){
                degrees = 100.0
            } else {
                degrees += 3.3
            }
            w = imageList[10].width/8
            h = imageList[10].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[10], null, rect, null)
        } else if (contador <= 36) {
            if(contador == 34){
                degrees = 110.0
            } else {
                degrees += 3.3
            }
            w = imageList[11].width/8
            h = imageList[11].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[11], null, rect, null)
        } else if (contador <= 39) {

            if(contador == 37){
                degrees = 120.0
            } else {
                degrees += 3.3
            }
            w = imageList[12].width/8
            h = imageList[12].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[12], null, rect, null)
        } else if (contador <= 42) {
            if(contador == 40){
                degrees = 130.0
            } else {
                degrees += 3.3
            }
            w = imageList[13].width/8
            h = imageList[13].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[13], null, rect, null)
        } else if (contador <= 45) {
            if(contador == 43){
                degrees = 140.0
            } else {
                degrees += 3.3
            }
            w = imageList[14].width/8
            h = imageList[14].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[14], null, rect, null)
        } else if (contador <= 48) {
            if(contador == 46){
                degrees = 150.0
            } else {
                degrees += 3.3
            }
            w = imageList[15].width/8
            h = imageList[15].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[15], null, rect, null)
        } else if (contador <= 51) {
            if(contador == 49){
                degrees = 160.0
            } else {
                degrees += 3.3
            }
            w = imageList[16].width/8
            h = imageList[16].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[16], null, rect, null)
        } else if (contador <= 54) {
            if(contador == 52){
                degrees = 170.0
            } else {
                degrees += 3.3
            }
            w = imageList[17].width/8
            h = imageList[17].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[17], null, rect, null)
        } else if (contador <= 57) {
            if(contador == 55){
                degrees = 180.0
            } else {
                degrees += 3.3
            }
            w = imageList[18].width/8
            h = imageList[18].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[18], null, rect, null)
        } else if (contador <= 60) {
            if(contador == 58){
                degrees = 190.0
            } else {
                degrees += 3.3
            }
            w = imageList[19].width/8
            h = imageList[19].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[19], null, rect, null)
        } else if (contador <= 63) {
            if(contador == 61){
                degrees = 200.0
            } else {
                degrees += 3.3
            }
            w = imageList[20].width/8
            h = imageList[20].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[20], null, rect, null)
        } else if (contador <= 66) {
            if(contador == 64){
                degrees = 210.0
            } else {
                degrees += 3.3
            }
            w = imageList[21].width/8
            h = imageList[21].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[21], null, rect, null)
        } else if (contador <= 69) {
            if(contador == 67){
                degrees = 220.0
            } else {
                degrees += 3.3
            }
            w = imageList[22].width/8
            h = imageList[22].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[22], null, rect, null)
        } else if (contador <= 72) {
            if(contador == 70){
                degrees = 230.0
            } else {
                degrees += 3.3
            }
            w = imageList[23].width/8
            h = imageList[23].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[23], null, rect, null)
        } else if (contador <= 75) {
            if(contador == 73){
                degrees = 240.0
            } else {
                degrees += 3.3
            }
            w = imageList[24].width/8
            h = imageList[24].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[24], null, rect, null)
        } else if (contador <= 78) {
            if(contador == 76){
                degrees = 250.0
            } else {
                degrees += 3.3
            }
            w = imageList[25].width/8
            h = imageList[25].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[25], null, rect, null)
        } else if (contador <= 81) {
            if(contador == 79){
                degrees = 260.0
            } else {
                degrees += 3.3
            }
            w = imageList[26].width/8
            h = imageList[26].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[26], null, rect, null)
        } else if (contador <= 84) {
            if(contador == 82){
                degrees = 270.0
            } else {
                degrees += 3.3
            }
            w = imageList[27].width/8
            h = imageList[27].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[27], null, rect, null)
        } else if (contador <= 87) {
            if(contador == 85){
                degrees = 280.0
            } else {
                degrees += 3.3
            }
            w = imageList[28].width/8
            h = imageList[28].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[28], null, rect, null)
        } else if (contador <= 90) {
            if(contador == 88){
                degrees = 290.0
            } else {
                degrees += 3.3
            }
            w = imageList[29].width/8
            h = imageList[29].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[29], null, rect, null)
        } else if (contador <= 93) {
            if(contador == 91){
                degrees = 300.0
            } else {
                degrees += 3.3
            }
            w = imageList[30].width/8
            h = imageList[30].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[30], null, rect, null)
        }else if (contador <= 96) {
            if(contador == 94){
                degrees = 310.0
            } else {
                degrees += 3.3
            }
            w = imageList[31].width/8
            h = imageList[31].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[31], null, rect, null)
        }else if (contador <= 99) {
            if(contador == 97){
                degrees = 320.0
            } else {
                degrees += 3.3
            }
            w = imageList[32].width/8
            h = imageList[32].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[32], null, rect, null)
        }else if (contador <= 102) {
            if(contador == 100){
                degrees = 330.0
            } else {
                degrees += 3.3
            }
            w = imageList[33].width/8
            h = imageList[33].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[33], null, rect, null)
        }else if (contador <= 105) {
            if(contador == 103){
                degrees = 340.0
            } else {
                degrees += 3.3
            }
            w = imageList[34].width/8
            h = imageList[34].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[34], null, rect, null)
        }else if (contador <= 108) {
            if(contador == 106){
                degrees = 350.0
            } else {
                degrees += 3.3
            }
            w = imageList[35].width/8
            h = imageList[35].height/8
            rect.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2)
            canvas.drawBitmap(imageList[35], null, rect, null)
        }
        contador = (contador + 1) % 109
    }
}