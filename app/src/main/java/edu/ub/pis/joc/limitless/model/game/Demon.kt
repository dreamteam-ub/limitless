package edu.ub.pis.joc.limitless.model.game

import android.content.res.AssetManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.util.Log
import edu.ub.pis.joc.limitless.view.ViewAdjuster
import edu.ub.pis.joc.limitless.view.ViewAdjuster.screenHeight
import edu.ub.pis.joc.limitless.view.ViewAdjuster.screenWidth
import kotlin.math.PI
import kotlin.math.sin

class Demon(image: ArrayList<Bitmap>, posX: Int, posY: Int, childList:Int, assets: AssetManager, behaviour:Int) : ComplexEnemy(image, posX, posY,childList,assets,behaviour) {

    override var w: Int = CharacterData.demonWidth
    override var h: Int = CharacterData.demonHeight

    override var xVelocity: Int = 10
    override var yVelocity: Int = 10

    override var concreteBehaviour = behaviour

    var yOriginal = posY
    var xOriginal = posX

    var projectileWavesList : ArrayList<DemonFireColumn> = generateChildList()

    override fun update() {
        if(dissapearTimer > 0){
            dissapearTimer--
        }

        if(dissapearTimer == 0){
            if(x<=0 || x>=ViewAdjuster.screenWidth || y<=0 || y>= ViewAdjuster.screenHeight){
                dissapearTimer = -1
            }
        }

        when (concreteBehaviour) {
            0 -> {
                //Sinusoidal esquerra a dreta
                val altura = ViewAdjuster.screenHeight*0.05 //Subir el multiplicador para mas altura
                val movimientos = 2 //Se haran tantos movimientos sinusoidales
                x += xVelocity
                y = yOriginal-(sin(((x.toDouble()/ViewAdjuster.screenWidth)*movimientos*2* PI)) *altura).toInt()
            }
            1 -> {
                //Sinusoidal dreta a esquerra
                val altura = ViewAdjuster.screenHeight*0.05 //Subir el multiplicador para mas altura
                val movimientos = 2 //Se haran tantos movimientos sinusoidales
                x -= xVelocity
                y = yOriginal-(sin(((x.toDouble()/ViewAdjuster.screenWidth)*movimientos*2* PI)) *altura).toInt()
            }
            2 -> {
                //Sinusoidal dalt a baix
                val altura = ViewAdjuster.screenWidth*0.1 //Subir el multiplicador para mas altura
                val movimientos = 6 //Se haran tantos movimientos sinusoidales
                x = xOriginal-(sin(((y.toDouble()/ViewAdjuster.screenHeight)*movimientos*2* PI)) *altura).toInt()
                y += (1.3*yVelocity).toInt() //A mas multiplicador mas rapido ira
            }
            3 -> {
                //Sinusoidal baix a dalt
                val altura = ViewAdjuster.screenWidth*0.1 //Subir el multiplicador para mas altura
                val movimientos = 6 //Se haran tantos movimientos sinusoidales
                x = xOriginal-(sin(((y.toDouble()/ViewAdjuster.screenHeight)*movimientos*2* PI)) *altura).toInt()
                y -= (1.3*yVelocity).toInt() //A mas multiplicador mas rapido ira
            }
            4 -> {
                //Abajo Izquierda
                if ((x >= ViewAdjuster.screenWidth && xVelocity>0) || ((x <= 0)&& xVelocity<0) ) {
                    xVelocity *= -1
                }
                x += (xVelocity*1.5).toInt()
                y += yVelocity
            }
            5 -> {
                //Arriba Izquierda
                if ((x >= ViewAdjuster.screenWidth && xVelocity>0) || ((x <= 0)&& xVelocity<0) ) {
                    xVelocity *= -1
                }
                x += (xVelocity*1.5).toInt()
                y -= yVelocity
            }
            6 -> {
                //Arriba Derecha
                if ((x >= ViewAdjuster.screenWidth && xVelocity>0) || ((x <= 0)&& xVelocity<0) ) {
                    xVelocity *= -1
                }
                x += (xVelocity*1.5).toInt()
                y -= yVelocity
            }
            7 -> {
                //Abajo Derecha
                if ((x >= ViewAdjuster.screenWidth && xVelocity>0)|| ((x <= 0)&& xVelocity<0) ) {
                    xVelocity *= -1
                }
                x += (xVelocity*1.5).toInt()
                y += yVelocity
            }
            8->{
                if ((x>=ViewAdjuster.screenWidth && xVelocity>0) || (x <= 0&& xVelocity<0) ) {
                    xVelocity *= -1
                }
                if ((y>=ViewAdjuster.screenHeight && yVelocity>0) || (y <= 0&& yVelocity<0)) {
                    yVelocity *= -1
                }

                x += (xVelocity)
                y += (yVelocity)
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

        val tmp : ArrayList<DemonFireColumn> = ArrayList()
        var enemy : Enemy
        when(childListConditional){
            0->{
                Log.d("H DEMON PARENT", h.toString())
                enemy = characterFactory.createCharacter(DEMON_FIRE_COLUMN,this.x,this.y-150,0,w,h) as DemonFireColumn
                enemy.dissapearTimer = 200
                enemy.xDemon = x
                enemy.yDemon = y
                tmp.add(enemy)
                return tmp
            }
            1->{
                enemy = characterFactory.createCharacter(DEMON_FIRE_COLUMN,this.x,this.y-150,0,w,h) as DemonFireColumn
                enemy.dissapearTimer = 200
                enemy.xDemon = x
                enemy.yDemon = y
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(DEMON_FIRE_COLUMN,this.x,this.y+150,0,w,h) as DemonFireColumn
                enemy.dissapearTimer = 200
                enemy.contador = 55
                enemy.xDemon = x
                enemy.yDemon = y
                tmp.add(enemy)
                return tmp
            }
            2->{
                enemy = characterFactory.createCharacter(DEMON_FIRE_COLUMN,this.x,this.y-150,0,w,h) as DemonFireColumn
                enemy.dissapearTimer = 200
                enemy.xDemon = x
                enemy.yDemon = y
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(DEMON_FIRE_COLUMN,this.x+75,this.y+75,0,w,h) as DemonFireColumn
                enemy.dissapearTimer = 200
                enemy.contador = 41
                enemy.xDemon = x
                enemy.yDemon = y
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(DEMON_FIRE_COLUMN,this.x-75,this.y+75,0,w,h) as DemonFireColumn
                enemy.dissapearTimer = 200
                enemy.contador = 68
                enemy.xDemon = x
                enemy.yDemon = y
                tmp.add(enemy)
                return tmp
            }
            3->{
                enemy = characterFactory.createCharacter(DEMON_FIRE_COLUMN,this.x,this.y-150,0,w,h) as DemonFireColumn
                enemy.dissapearTimer = 200
                enemy.xDemon = x
                enemy.yDemon = y
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(DEMON_FIRE_COLUMN,this.x,this.y+150,0,w,h) as DemonFireColumn
                enemy.dissapearTimer = 200
                enemy.contador = 55
                enemy.xDemon = x
                enemy.yDemon = y
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(DEMON_FIRE_COLUMN,this.x+150,this.y,0,w,h) as DemonFireColumn
                enemy.dissapearTimer = 200
                enemy.contador = 28
                enemy.xDemon = x
                enemy.yDemon = y
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(DEMON_FIRE_COLUMN,this.x-150,this.y,0,w,h) as DemonFireColumn
                enemy.dissapearTimer = 200
                enemy.contador = 82
                enemy.xDemon = x
                enemy.yDemon = y
                tmp.add(enemy)
                return tmp
            }
        }
        return tmp
    }

    override fun characterHitsPlayer(playerCharacter: PlayerCharacter): Boolean {
        var hit = false
        for (i in 0 until projectileWavesList.size){
                if (projectileWavesList[i].rect.intersects(playerCharacter.rect.left,playerCharacter.rect.top,playerCharacter.rect.right,playerCharacter.rect.bottom)) {
                    playerCharacter.die()
                    hit = true
                }
        }
        return hit
    }
}