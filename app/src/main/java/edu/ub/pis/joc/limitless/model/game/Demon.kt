package edu.ub.pis.joc.limitless.model.game

import android.graphics.Bitmap
import edu.ub.pis.joc.limitless.model.Data
import android.content.Context
import android.graphics.Canvas
import android.util.Log
import kotlin.math.PI
import kotlin.math.sin

class Demon(image: ArrayList<Bitmap>, posX: Int, posY: Int,childList:Int,context: Context) : ComplexEnemy(image, posX, posY,childList,context) {

    override var xVelocity: Int = 10
    override var yVelocity: Int = 10

    override var h = image[0].height / 8
    override var w = image[0].width / 8

    var yOriginal = posY
    var xOriginal = posX

    var xChange : Int = 0
    var yChange :Int = 0

    var contador : Int = 0

    var projectileWavesList : ArrayList<DemonFireColumn> = generateChildList()

    override fun update() {
        dissapearTimer--
        when (concreteBehavior) {
            0 -> {
                //Sinusoidal esquerra a dreta
                var altura = Data.screenHeight*0.05 //Subir el multiplicador para mas altura
                var movimientos = 2 //Se haran tantos movimientos sinusoidales
                x += xVelocity
                y = yOriginal-(sin(((x.toDouble()/Data.screenWidth)*movimientos*2* PI)) *altura).toInt()
            }
            1 -> {
                //Sinusoidal dreta a esquerra
                var altura = Data.screenHeight*0.05 //Subir el multiplicador para mas altura
                var movimientos = 2 //Se haran tantos movimientos sinusoidales
                x -= xVelocity
                y = yOriginal-(sin(((x.toDouble()/Data.screenWidth)*movimientos*2* PI)) *altura).toInt()
            }
            2 -> {
                //Sinusoidal dalt a baix
                var altura = Data.screenWidth*0.1 //Subir el multiplicador para mas altura
                var movimientos = 6 //Se haran tantos movimientos sinusoidales
                x = xOriginal-(sin(((y.toDouble()/Data.screenHeight)*movimientos*2* PI)) *altura).toInt()
                y += (1.3*yVelocity).toInt() //A mas multiplicador mas rapido ira
            }
            3 -> {
                //Sinusoidal baix a dalt
                var altura = Data.screenWidth*0.1 //Subir el multiplicador para mas altura
                var movimientos = 6 //Se haran tantos movimientos sinusoidales
                x = xOriginal-(sin(((y.toDouble()/Data.screenHeight)*movimientos*2* PI)) *altura).toInt()
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
            8->{
                x = x
                y = y
            }

        }

        for (i in 0 until projectileWavesList.size){
            projectileWavesList[i].xDemon = x
            projectileWavesList[i].yDemon = y
            projectileWavesList[i].update()
        }
    }

    override fun draw (canvas: Canvas){

        for (i in 0 until projectileWavesList.size){
            projectileWavesList[i].draw(canvas)
        }

        val halfW: Int = w / 2
        val halfH: Int = h / 2
        rect.set(x - halfW, y - halfH, x + halfW, y + halfH)
        canvas.drawBitmap(imageList[0], null, rect, null)




    }

    fun generateChildList(): ArrayList<DemonFireColumn>{

        var tmp : ArrayList<DemonFireColumn> = ArrayList()
        var enemy : Enemy
        when(childListConditional){
            0->{
                enemy = characterFactory.createCharacter(DEMON_FIRE_COLUMN,this.x,this.y-150) as DemonFireColumn
                enemy.concreteBehavior = 8
                enemy.dissapearTimer = 200
                enemy.wDemon = this.w
                enemy.hDemon = this.h
                enemy.xDemon = x
                enemy.yDemon = y
                tmp.add(enemy)
                return tmp
            }
            1->{
                enemy = characterFactory.createCharacter(DEMON_FIRE_COLUMN,this.x,this.y-150) as DemonFireColumn
                enemy.concreteBehavior = 8
                enemy.dissapearTimer = 200
                enemy.wDemon = this.w
                enemy.hDemon = this.h
                enemy.xDemon = x
                enemy.yDemon = y
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(DEMON_FIRE_COLUMN,this.x,this.y+150) as DemonFireColumn
                enemy.concreteBehavior = 8
                enemy.dissapearTimer = 200
                enemy.contador = 55
                enemy.wDemon = this.w
                enemy.hDemon = this.h
                enemy.xDemon = x
                enemy.yDemon = y
                tmp.add(enemy)
                return tmp
            }
            2->{
                enemy = characterFactory.createCharacter(DEMON_FIRE_COLUMN,this.x,this.y-150) as DemonFireColumn
                enemy.concreteBehavior = 8
                enemy.dissapearTimer = 200
                enemy.wDemon = this.w
                enemy.hDemon = this.h
                enemy.xDemon = x
                enemy.yDemon = y
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(DEMON_FIRE_COLUMN,this.x+75,this.y+75) as DemonFireColumn
                enemy.concreteBehavior = 8
                enemy.dissapearTimer = 200
                enemy.contador = 41
                enemy.wDemon = this.w
                enemy.hDemon = this.h
                enemy.xDemon = x
                enemy.yDemon = y
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(DEMON_FIRE_COLUMN,this.x-75,this.y+75) as DemonFireColumn
                enemy.concreteBehavior = 8
                enemy.dissapearTimer = 200
                enemy.contador = 68
                enemy.wDemon = this.w
                enemy.hDemon = this.h
                enemy.xDemon = x
                enemy.yDemon = y
                tmp.add(enemy)
                return tmp
            }
            3->{
                enemy = characterFactory.createCharacter(DEMON_FIRE_COLUMN,this.x,this.y-150) as DemonFireColumn
                enemy.concreteBehavior = 8
                enemy.dissapearTimer = 200
                enemy.wDemon = this.w
                enemy.hDemon = this.h
                enemy.xDemon = x
                enemy.yDemon = y
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(DEMON_FIRE_COLUMN,this.x,this.y+150) as DemonFireColumn
                enemy.concreteBehavior = 8
                enemy.dissapearTimer = 200
                enemy.contador = 55
                enemy.wDemon = this.w
                enemy.hDemon = this.h
                enemy.xDemon = x
                enemy.yDemon = y
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(DEMON_FIRE_COLUMN,this.x+150,this.y) as DemonFireColumn
                enemy.concreteBehavior = 8
                enemy.dissapearTimer = 200
                enemy.contador = 28
                enemy.wDemon = this.w
                enemy.hDemon = this.h
                enemy.xDemon = x
                enemy.yDemon = y
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(DEMON_FIRE_COLUMN,this.x-150,this.y) as DemonFireColumn
                enemy.concreteBehavior = 8
                enemy.dissapearTimer = 200
                enemy.contador = 82
                enemy.wDemon = this.w
                enemy.hDemon = this.h
                enemy.xDemon = x
                enemy.yDemon = y
                tmp.add(enemy)
                return tmp
            }
        }
        return tmp
    }

    fun generateBooleans(): ArrayList<Boolean>{
        var tmp : ArrayList<Boolean> = ArrayList()
        for (i in 0 until projectileWavesList.size){
            tmp.add(false)
        }
        return tmp
    }

    override fun characterHitsPlayer(playerCharacter: PlayerCharacter): Boolean {
        var hit = false
        for (i in 0 until projectileWavesList.size){
                if (projectileWavesList[i].rect.intersect(playerCharacter.rect)) {
                    playerCharacter.die()
                    hit = true
                }
        }
        return hit
    }
}