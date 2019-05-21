package edu.ub.pis.joc.limitless.model.game

import android.content.Context
import android.content.res.AssetManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.util.Log
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.Data.screenHeight
import edu.ub.pis.joc.limitless.model.Data.screenWidth
import kotlin.math.PI
import kotlin.math.sin
import kotlin.math.abs

class Eye(image: ArrayList<Bitmap>, posX: Int, posY: Int, childList: Int, assets: AssetManager, behaviour:Int) :
    ComplexEnemy(image, posX, posY, childList, assets,behaviour) {

    override var w: Int = (screenWidth * 0.162037).toInt()
    override var h: Int = (screenHeight * 0.041913).toInt()

    override var xVelocity: Int = 10
    override var yVelocity: Int = 9

    var yOriginal = posY
    var xOriginal = posX

    override var concreteBehaviour = behaviour

    var contador: Int = 0

    var projectileWavesList: ArrayList<ArrayList<EyeProjectile>> = generateChildList()
    override var projectileDraw: ArrayList<Boolean> = generateBooleans()
    override var projectileRelocate: ArrayList<Boolean> = generateBooleans()

    var drawChild: Boolean = false

    var  projectileStep = 0

    var  currentRange = 0

    var indexProjectileCount = 0

    init {
        when (concreteBehaviour) {
            0,1 -> {
                projectileStep = ((Data.screenWidth*0.8)/(projectileWavesList.size+1)).toInt()
                currentRange = (Data.screenWidth*0.1).toInt()
            }
            2,3,4,5,6,7 -> {
                projectileStep = ((Data.screenHeight*0.8)/(projectileWavesList.size+1)).toInt()
                currentRange = (Data.screenHeight*0.1).toInt()
            }
        }
    }

    override fun update() {
        when (concreteBehaviour) {
            0 -> {
                //Sinusoidal esquerra a dreta
                val altura = Data.screenHeight * 0.05 //Subir el multiplicador para mas altura
                val movimientos = 2 //Se haran tantos movimientos sinusoidales
                x += (xVelocity * 1.4).toInt()
                y = yOriginal - (sin(((x.toDouble() / Data.screenWidth) * movimientos * 2 * PI)) * altura).toInt()
            }
            1 -> {
                //Sinusoidal dreta a esquerra
                val altura = Data.screenHeight * 0.05 //Subir el multiplicador para mas altura
                val movimientos = 2 //Se haran tantos movimientos sinusoidales
                x -= (xVelocity * 1.4).toInt()
                y = yOriginal - (sin(((x.toDouble() / Data.screenWidth) * movimientos * 2 * PI)) * altura).toInt()
            }
            2 -> {
                //Sinusoidal dalt a baix
                val altura = Data.screenWidth * 0.1 //Subir el multiplicador para mas altura
                val movimientos = 6 //Se haran tantos movimientos sinusoidales
                x = xOriginal - (sin(((y.toDouble() / Data.screenHeight) * movimientos * 2 * PI)) * altura).toInt()
                y += (1.4 * yVelocity).toInt() //A mas multiplicador mas rapido ira
            }
            3 -> {
                //Sinusoidal baix a dalt
                val altura = Data.screenWidth * 0.1 //Subir el multiplicador para mas altura
                val movimientos = 6 //Se haran tantos movimientos sinusoidales
                x = xOriginal - (sin(((y.toDouble() / Data.screenHeight) * movimientos * 2 * PI)) * altura).toInt()
                y -= (1.4 * yVelocity).toInt() //A mas multiplicador mas rapido ira
            }
            4 -> {
                //Abajo Izquierda
                if ((x >= Data.screenWidth && xVelocity>0) || ((x <= 0)&& xVelocity<0) ) {
                    xVelocity *= -1
                }
                x += (xVelocity*1.5).toInt()
                y += yVelocity
            }
            5 -> {
                //Arriba Izquierda
                if ((x >= Data.screenWidth && xVelocity>0) || ((x <= 0)&& xVelocity<0) ) {
                        xVelocity *= -1
                }
                x += (xVelocity*1.5).toInt()
                y -= yVelocity
            }
            6 -> {
                //Arriba Derecha
                if ((x >= Data.screenWidth && xVelocity>0) || ((x <= 0)&& xVelocity<0) ) {
                    xVelocity *= -1
                }
                x += (xVelocity*1.5).toInt()
                y -= yVelocity
            }
            7 -> {
                //Abajo Derecha
                if ((x >= Data.screenWidth && xVelocity>0)|| ((x <= 0)&& xVelocity<0) ) {
                    xVelocity *= -1
                }
                x += (xVelocity*1.5).toInt()
                y += yVelocity
            }
        }

        when (concreteBehaviour) {
            0 -> {
                //Empieza izquierda
                if(x>currentRange+projectileStep && !projectileDraw[indexProjectileCount]){
                    projectileRelocate[indexProjectileCount] = true
                    projectileDraw[indexProjectileCount] = true
                    indexProjectileCount = (indexProjectileCount+1)%(projectileWavesList.size)
                    currentRange += projectileStep
                }
            }
            1->{
                //Empieza derecha
                if(x<(Data.screenWidth-(currentRange+projectileStep)) && !projectileDraw[indexProjectileCount]){
                    projectileRelocate[indexProjectileCount] = true
                    projectileDraw[indexProjectileCount] = true
                    indexProjectileCount = (indexProjectileCount+1)%(projectileWavesList.size)
                    currentRange += projectileStep
                }
            }
            2,5,6-> {
                //Empiezan arriba
                if(y>currentRange+projectileStep && !projectileDraw[indexProjectileCount]){
                    projectileRelocate[indexProjectileCount] = true
                    projectileDraw[indexProjectileCount] = true
                    indexProjectileCount = (indexProjectileCount+1)%(projectileWavesList.size)
                    currentRange += projectileStep
                }
            }
            3,4,7-> {
                //Empiezan abajo
                if(y<(Data.screenHeight-(currentRange+projectileStep)) && !projectileDraw[indexProjectileCount]){
                    projectileRelocate[indexProjectileCount] = true
                    projectileDraw[indexProjectileCount] = true
                    indexProjectileCount = (indexProjectileCount+1)%(projectileWavesList.size)
                    currentRange += projectileStep
                }
            }
        }

        if (drawChild) {
            for (i in 0 until projectileRelocate.size) {
                if (projectileRelocate[i]) {
                    for (j in 0 until projectileWavesList[i].size) {
                        projectileWavesList[i][j].x = this.x
                        projectileWavesList[i][j].y = this.y
                    }
                }
                projectileRelocate[i] = false
            }

            for (i in 0 until projectileDraw.size) {
                if (projectileDraw[i]) {
                    for (j in 0 until projectileWavesList[i].size) {
                        projectileWavesList[i][j].update()
                    }
                }
            }
        }

        if(dissapearTimer > 0){
            dissapearTimer--
        }

        if(dissapearTimer == 0){
            if(x<=0 || x>=Data.screenWidth || y<=0 || y>= Data.screenHeight){
                dissapearTimer = -1
            }
        }
    }

    override fun draw(canvas: Canvas) {
        val halfW: Int = w / 2
        val halfH: Int = h / 2
        rect.set(x - halfW, y - halfH, x + halfW, y + halfH)
        if (contador <= 3) {
            canvas.drawBitmap(imageList[0], null, rect, null)
        } else if (contador <= 6) {
            canvas.drawBitmap(imageList[1], null, rect, null)
        } else if (contador <= 9) {
            canvas.drawBitmap(imageList[2], null, rect, null)
        } else if (contador <= 12) {
            canvas.drawBitmap(imageList[3], null, rect, null)
        } else if (contador <= 15) {
            canvas.drawBitmap(imageList[4], null, rect, null)
        } else if (contador <= 18) {
            canvas.drawBitmap(imageList[5], null, rect, null)
        } else if (contador <= 21) {
            canvas.drawBitmap(imageList[4], null, rect, null)
        } else if (contador <= 24) {
            canvas.drawBitmap(imageList[3], null, rect, null)
        } else if (contador <= 27) {
            canvas.drawBitmap(imageList[2], null, rect, null)
        } else if (contador <= 30) {
            canvas.drawBitmap(imageList[1], null, rect, null)
        }
        contador = (contador + 1) % 31


        if (drawChild) {
            for (i in 0 until projectileDraw.size) {
                if (projectileDraw[i]) {
                    for (j in 0 until projectileWavesList[i].size) {
                        projectileWavesList[i][j].draw(canvas)
                    }
                }
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun generateChildList(): ArrayList<ArrayList<EyeProjectile>> {

        val tmpFinal: ArrayList<ArrayList<EyeProjectile>> = ArrayList()
        val tmp: ArrayList<EyeProjectile> = ArrayList()
        var enemy: Enemy
        when (childListConditional) {
            //MOV HOR
            0 -> {
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,1) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,3) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,5) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,7) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,1) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,2) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,3) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                return tmpFinal
            }
            //MOV HOR
            1 -> {
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,1) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,3) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,5) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,7) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,5) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,6) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,7) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                return tmpFinal
            }
            2 ->{
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,1) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,3) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,5) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,7) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,2) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,3) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,4) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,5) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,6) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,0) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,1) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,2) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,3) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,5) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,6) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,7) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                return tmpFinal
            }
            3 -> {
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,3) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,4) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,5) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,1) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,3) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,5) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,7) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,1) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,2) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,3) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,5) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,6) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,7) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                return tmpFinal
            }
            4 -> {
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,1) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,3) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,5) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,7) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,0) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,2) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,4) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,6) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                return tmpFinal
            }
            5 -> {
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,0) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,2) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,6) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,0) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,1) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,2) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,3) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,4) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,5) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,6) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,7) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,2) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,4) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,6) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                return tmpFinal
            }
            6 -> {
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,0) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,1) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,7) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                return tmpFinal
            }
            7 -> {
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,3) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,4) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,5) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                return tmpFinal
            }
            8 -> {
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,4) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,6) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,7) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                return tmpFinal
            }
            9 -> {
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,1) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,2) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,3) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                return tmpFinal
            }
            //MOV VERTICAL

            10->{
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,5) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,6) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,7) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,4) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,6) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,0) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,5) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,6) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,7) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                return tmpFinal
            }

            //MOV VERTICAL

            11->{
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,1) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,2) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,3) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,4) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,2) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,0) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,1) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,2) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,3) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                return tmpFinal
            }

            //MOV VERT
            12->{
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,1) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,0) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,7) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,5) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,6) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,7) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,5) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,6) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,7) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,3) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,5) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,6) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                return tmpFinal
            }

            //MOV VERT
            13->{
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,3) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,4) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,5) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,1) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,2) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,3) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,1) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,2) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,3) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0,0,1) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,2) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                return tmpFinal
            }

            //MOV VERT
            14->{
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,3) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,4) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,5) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,5) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,6) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,7) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,5) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,6) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,7) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,0) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,1) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,7) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                return tmpFinal
            }

            //MOV VERT
            15->{
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,1) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,0) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,7) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,3) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,1) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,2) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,3) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,1) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,2) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,3) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,4) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,5) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                return tmpFinal
            }

            //MOV HOR
            16 -> {

                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,0) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,1) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,7) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,0) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,1) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,7) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)

            }

            //MOV HOR
            17->{

                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,3) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,4) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,5) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,5) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,4) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0,3) as EyeProjectile
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
            }
        }
        return tmpFinal
    }

    fun generateBooleans(): ArrayList<Boolean> {
        val tmp: ArrayList<Boolean> = ArrayList()
        for (i in 0 until projectileWavesList.size) {
            tmp.add(false)
        }
        return tmp
    }

    override fun characterHitsPlayer(playerCharacter: PlayerCharacter): Boolean {
        var hit = false
        for (i in 0 until projectileWavesList.size) {
            for (j in 0 until projectileWavesList[i].size) {
                if (projectileWavesList[i][j].rect.intersects(playerCharacter.rect.left,playerCharacter.rect.top,playerCharacter.rect.right,playerCharacter.rect.bottom)) {
                    playerCharacter.die()
                    hit = true
                }
            }
        }
        return hit
    }
}