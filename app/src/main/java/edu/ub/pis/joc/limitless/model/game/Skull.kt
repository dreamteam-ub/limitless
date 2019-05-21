package edu.ub.pis.joc.limitless.model.game

import android.content.res.AssetManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.util.Log
import edu.ub.pis.joc.limitless.model.Data

class Skull(image: ArrayList<Bitmap>, posX: Int, posY: Int,childList:Int,assets: AssetManager, behaviour: Int) : ComplexEnemy(image, posX, posY,childList,assets,behaviour) {

    override var w: Int = (Data.screenWidth * 0.103703).toInt()
    override var h: Int = (Data.screenHeight * 0.073964).toInt()

    var contador: Int = 0

    var projectileWavesList : ArrayList<SkullLaser>

    override var concreteBehaviour = behaviour

    var firstDraw = true

    var childDissapearTimeSet = false

    init {
        var degrees : Float
        Log.d("SKULL WITH BEHAVIOUR", behaviour.toString())
        Log.d("SKULL WITH BEHAVIOUR", concreteBehaviour.toString())
        when(concreteBehaviour){
            0->{
                degrees = 0f
                x= (Data.screenWidth*0.34).toInt()
                y= 0
            }
            1->{
                degrees = 0f
                x= (Data.screenWidth*0.67).toInt()
                y= 0
            }
            2->{
                degrees = 90f
                x= Data.screenWidth
                y= (Data.screenHeight*0.25).toInt()
                w = (Data.screenHeight * 0.073964).toInt()
                h = (Data.screenWidth * 0.103703).toInt()
            }
            3->{
                degrees = 90f
                x= Data.screenWidth
                y= (Data.screenHeight*0.5).toInt()
                w = (Data.screenHeight * 0.073964).toInt()
                h = (Data.screenWidth * 0.103703).toInt()
            }
            4->{
                degrees = 90f
                x= Data.screenWidth
                y= (Data.screenHeight*0.75).toInt()
                w = (Data.screenHeight * 0.073964).toInt()
                h = (Data.screenWidth * 0.103703).toInt()
            }
            5->{
                degrees = 180f
                x= (Data.screenWidth*0.67).toInt()
                y= Data.screenHeight
            }
            6->{
                degrees = 180f
                x= (Data.screenWidth*0.34).toInt()
                y= Data.screenHeight
            }
            7->{
                degrees = 270f
                x= 0
                y= (Data.screenHeight*0.75).toInt()
                w = (Data.screenHeight * 0.073964).toInt()
                h = (Data.screenWidth * 0.103703).toInt()
            }
            8->{
                degrees = 270f
                x= 0
                y= (Data.screenHeight*0.5).toInt()
                w = (Data.screenHeight * 0.073964).toInt()
                h = (Data.screenWidth * 0.103703).toInt()
            }
            9->{
                degrees = 270f
                x= 0
                y= (Data.screenHeight*0.25).toInt()
                w = (Data.screenHeight * 0.073964).toInt()
                h = (Data.screenWidth * 0.103703).toInt()
            }
            else->{
                degrees = 0f
                x= 0
                y= 0
            }
        }

        if (degrees > 0.0f) {
            rotate(degrees)
        }

        projectileWavesList = generateChildList()

    }

    override fun update() {
        if(!childDissapearTimeSet){
            projectileWavesList[0].dissapearTimer = this.dissapearTimer
            childDissapearTimeSet = true
        }
        projectileWavesList[0].update()
        dissapearTimer--
    }

    override fun draw(canvas: Canvas) {
        val halfW: Int = w / 2
        val halfH: Int = h / 2
        rect.set(x - halfW, y - halfH, x + halfW, y + halfH)

        if(firstDraw) {
            if (contador <= 3) {
                //Skull 1
                canvas.drawBitmap(imageList[0], null, rect, null)
            } else if (contador <= 6) {
                //Skull 2
                canvas.drawBitmap(imageList[1], null, rect, null)
            } else if (contador <= 9) {
                //Skull 3
                canvas.drawBitmap(imageList[2], null, rect, null)
            } else if (contador <= 12) {
                //Skull 3 Light
                canvas.drawBitmap(imageList[3], null, rect, null)
            } else if (contador <= 15) {
                //Skull 4
                canvas.drawBitmap(imageList[4], null, rect, null)
            } else if (contador <= 18) {
                //Skull 4 Light
                canvas.drawBitmap(imageList[5], null, rect, null)
            } else if (contador <= 21) {
                //Skull 4
                canvas.drawBitmap(imageList[4], null, rect, null)
            } else if (contador <= 24) {
                //Skull 4 Light
                canvas.drawBitmap(imageList[5], null, rect, null)
            } else if (contador <= 27) {
                //Skull 4
                canvas.drawBitmap(imageList[4], null, rect, null)
            } else if (contador <= 30) {
                //Skull 4 Light
                canvas.drawBitmap(imageList[5], null, rect, null)
            } else if (contador <= 33) {
                //Skull 4
                canvas.drawBitmap(imageList[4], null, rect, null)
            } else if (contador <= 36) {
                //Skull 4 Light
                canvas.drawBitmap(imageList[5], null, rect, null)
            } else if (contador == 37) {
                //Skull 5
                canvas.drawBitmap(imageList[6], null, rect, null)
            } else if (contador == 38) {
                //Skull 5 Light
                canvas.drawBitmap(imageList[7], null, rect, null)
            } else if (contador == 39) {
                //Skull 6
                canvas.drawBitmap(imageList[8], null, rect, null)
            } else if (contador == 40) {
                //Skull 6 Light
                canvas.drawBitmap(imageList[9], null, rect, null)
            } else if (contador == 41) {
                //Skull 7
                canvas.drawBitmap(imageList[10], null, rect, null)
            } else if (contador == 42) {
                //Skull 7 Light
                canvas.drawBitmap(imageList[11], null, rect, null)
            }
            contador = (contador + 1)
            if (contador == 43) {
                firstDraw = false
                contador = 0
            }
        } else {
            if(dissapearTimer<=42){
                if (dissapearTimer == 42) {
                    canvas.drawBitmap(imageList[11], null, rect, null)
                } else if (dissapearTimer == 41) {
                    canvas.drawBitmap(imageList[10], null, rect, null)
                } else if (dissapearTimer == 40) {
                    canvas.drawBitmap(imageList[9], null, rect, null)
                } else if (dissapearTimer == 39) {
                    canvas.drawBitmap(imageList[8], null, rect, null)
                } else if (dissapearTimer == 38) {
                    canvas.drawBitmap(imageList[7], null, rect, null)
                } else if (dissapearTimer == 37) {
                    canvas.drawBitmap(imageList[6], null, rect, null)
                }else if (dissapearTimer >= 36) {
                    canvas.drawBitmap(imageList[5], null, rect, null)
                } else if (dissapearTimer >= 33) {
                    canvas.drawBitmap(imageList[4], null, rect, null)
                } else if (dissapearTimer >= 30) {
                    canvas.drawBitmap(imageList[5], null, rect, null)
                } else if (dissapearTimer >= 27) {
                    canvas.drawBitmap(imageList[4], null, rect, null)
                }else if (dissapearTimer >= 24) {
                    canvas.drawBitmap(imageList[5], null, rect, null)
                } else if (dissapearTimer >= 21) {
                    canvas.drawBitmap(imageList[4], null, rect, null)
                } else if (dissapearTimer >= 18) {
                    canvas.drawBitmap(imageList[5], null, rect, null)
                } else if (dissapearTimer >= 15) {
                    canvas.drawBitmap(imageList[4], null, rect, null)
                }else if (dissapearTimer >= 12) {
                    canvas.drawBitmap(imageList[3], null, rect, null)
                } else if (dissapearTimer >= 9) {
                    canvas.drawBitmap(imageList[2], null, rect, null)
                } else if (dissapearTimer >= 6) {
                    canvas.drawBitmap(imageList[1], null, rect, null)
                }else if (dissapearTimer >= 0){
                    canvas.drawBitmap(imageList[0], null, rect, null)
                }
            } else {
                if (contador == 0) {
                    //Skull 8
                    canvas.drawBitmap(imageList[12], null, rect, null)
                } else if (contador == 1) {
                    //Skull 8 Light
                    canvas.drawBitmap(imageList[13], null, rect, null)
                }
                contador = (contador + 1) % 2
            }
        }

        projectileWavesList[0].draw(canvas)
    }

    fun generateChildList(): ArrayList<SkullLaser>{

        var tmp : ArrayList<SkullLaser> = ArrayList()
        var enemy : SkullLaser = characterFactory.createCharacter(SKULL_LASER,this.x,this.y, concreteBehaviour,w,h) as SkullLaser
        tmp.add(enemy)

        return tmp
    }

    override fun characterHitsPlayer(playerCharacter: PlayerCharacter): Boolean {
        var hit = false
        for (i in 0 until projectileWavesList.size){
            if (projectileWavesList[i].rect.intersects(playerCharacter.rect.left,playerCharacter.rect.top,playerCharacter.rect.right,playerCharacter.rect.bottom) && projectileWavesList[i].activeEnemy ) {
                playerCharacter.die()
                hit = true
            }
        }
        return hit
    }

}