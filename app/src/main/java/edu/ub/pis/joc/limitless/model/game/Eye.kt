package edu.ub.pis.joc.limitless.model.game

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.util.Log
import edu.ub.pis.joc.limitless.model.Data
import kotlin.math.PI
import kotlin.math.sin
import kotlin.math.abs

class Eye(image: ArrayList<Bitmap>, posX: Int, posY: Int, childList: Int, context: Context, behaviour:Int) :
    ComplexEnemy(image, posX, posY, childList, context,behaviour) {

    override var xVelocity: Int = 10
    override var yVelocity: Int = 9

    override var h = image[0].height / 10
    override var w = image[0].width / 10

    var yOriginal = posY
    var xOriginal = posX

    override var concreteBehaviour = behaviour

    var contador: Int = 0

    var projectileWavesList: ArrayList<ArrayList<EyeProjectile>> = generateChildList()
    override var projectileDraw: ArrayList<Boolean> = generateBooleans()
    override var projectileRelocate: ArrayList<Boolean> = generateBooleans()

    var drawChild: Boolean = false

    override fun update() {
        dissapearTimer--
        when (concreteBehaviour) {
            0 -> {
                //Sinusoidal esquerra a dreta
                var altura = Data.screenHeight * 0.05 //Subir el multiplicador para mas altura
                var movimientos = 2 //Se haran tantos movimientos sinusoidales
                x += xVelocity
                y = yOriginal - (sin(((x.toDouble() / Data.screenWidth) * movimientos * 2 * PI)) * altura).toInt()
            }
            1 -> {
                //Sinusoidal dreta a esquerra
                var altura = Data.screenHeight * 0.05 //Subir el multiplicador para mas altura
                var movimientos = 2 //Se haran tantos movimientos sinusoidales
                x -= xVelocity
                y = yOriginal - (sin(((x.toDouble() / Data.screenWidth) * movimientos * 2 * PI)) * altura).toInt()
            }
            2 -> {
                //Sinusoidal dalt a baix
                var altura = Data.screenWidth * 0.1 //Subir el multiplicador para mas altura
                var movimientos = 6 //Se haran tantos movimientos sinusoidales
                x = xOriginal - (sin(((y.toDouble() / Data.screenHeight) * movimientos * 2 * PI)) * altura).toInt()
                y += (1.3 * yVelocity).toInt() //A mas multiplicador mas rapido ira
            }
            3 -> {
                //Sinusoidal baix a dalt
                var altura = Data.screenWidth * 0.1 //Subir el multiplicador para mas altura
                var movimientos = 6 //Se haran tantos movimientos sinusoidales
                x = xOriginal - (sin(((y.toDouble() / Data.screenHeight) * movimientos * 2 * PI)) * altura).toInt()
                y -= (1.3 * yVelocity).toInt() //A mas multiplicador mas rapido ira
            }
            4 -> {
                //Abajo Izquierda
                x -= xVelocity
                y += yVelocity
            }
            5 -> {
                //Arriba Izquierda
                x -= xVelocity + 5
                y -= yVelocity + 5
            }
            6 -> {
                //Arriba Derecha
                x += xVelocity + 5
                y -= yVelocity + 5
            }
            7 -> {
                //Abajo Derecha
                x += xVelocity + 5
                y += yVelocity + 5
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

    fun generateChildList(): ArrayList<ArrayList<EyeProjectile>> {

        var tmpFinal: ArrayList<ArrayList<EyeProjectile>> = ArrayList()
        var tmp: ArrayList<EyeProjectile> = ArrayList()
        var enemy: Enemy
        when (childListConditional) {
            0 -> {
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 0
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 4
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 1
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 3
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 5
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 7
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 1
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 2
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 3
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                return tmpFinal
            }
            1 -> {
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 0
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 4
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 1
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 3
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 5
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 7
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 5
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 6
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 7
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                return tmpFinal
            }
            2 -> {
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 0
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 2
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 6
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 1
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 3
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 5
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 7
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 2
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 3
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 4
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 5
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 6
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                return tmpFinal
            }
            3 -> {
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 3
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 4
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 5
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 1
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 3
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 5
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 7
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 1
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 2
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 3
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 5
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 6
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 7
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                return tmpFinal
            }
            4 -> {
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 1
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 3
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 5
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 7
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 0
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 2
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 4
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 6
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                return tmpFinal
            }
            5 -> {
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 0
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 2
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 6
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 0
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 1
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 2
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 3
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 4
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 5
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 6
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 7
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                tmp.clear()
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 2
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 4
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 6
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                return tmpFinal
            }
            6 -> {
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 0
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 1
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 7
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                return tmpFinal
            }
            7 -> {
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 3
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 4
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 5
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                return tmpFinal
            }
            8 -> {
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 4
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 6
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 7
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                return tmpFinal
            }
            9 -> {
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 1
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 2
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                enemy = characterFactory.createCharacter(EYE_PROJECTILE, 0, 0) as EyeProjectile
                enemy.concreteBehaviour = 3
                enemy.dissapearTimer = 40
                tmp.add(enemy)
                tmpFinal.add(tmp.clone() as ArrayList<EyeProjectile>)
                return tmpFinal
            }
        }
        return tmpFinal
    }

    fun generateBooleans(): ArrayList<Boolean> {
        var tmp: ArrayList<Boolean> = ArrayList()
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