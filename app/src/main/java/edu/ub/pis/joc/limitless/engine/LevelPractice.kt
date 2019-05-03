package edu.ub.pis.joc.limitless.engine

import android.content.Context
import android.graphics.Typeface
import android.util.Log
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.Data.screenHeight
import edu.ub.pis.joc.limitless.model.Data.screenWidth
import edu.ub.pis.joc.limitless.model.game.*
import java.util.ArrayList
import java.util.concurrent.ConcurrentHashMap

const val FONT_CRIME_SIX = "fonts/Crimes Times Six.ttf"

class LevelPractice(
    contextApp: Context,
    listOfEnemyCharacters: ArrayList<Enemy>,
    listOfCoins: ArrayList<Coin>
) : Level(contextApp, listOfEnemyCharacters, listOfCoins) {


    override fun buildEnemies(levelWorld: Int, time: Long) {
        //Log.d("TIME", (time).toInt().toString())
        //Log.d("CONTADOR ENEMIGOS", enemyCounter.toString())
        var listOfTmpEnemies = ArrayList<Enemy>()
        var tmp: Enemy
        when (levelWorld) {
            0 -> {
                endOfLevel = false
                if (time == 0L) {
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.2).toInt(), (screenHeight * 0.5).toInt(), 0, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.5).toInt(), 0, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.4).toInt(), (screenHeight * 0.5).toInt(), 0, 150)
                    listOfTmpEnemies.add(tmp)
                } else if (time == 50L) {
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.2).toInt(), 0, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.3).toInt(), 0, 150)
                    listOfTmpEnemies.add(tmp)
                } else if (time == 200L) {
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.8).toInt(), (screenHeight * 0.5).toInt(), 0, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.7).toInt(), (screenHeight * 0.5).toInt(), 0, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.6).toInt(), (screenHeight * 0.5).toInt(), 0, 150)
                    listOfTmpEnemies.add(tmp)
                } else if (time == 300L) {
                    endOfLevel = true
                }
                var contador : Int = 0
                while(contador < listOfEnemyCharacters.size){
                    if(listOfEnemyCharacters.get(contador).dissapearTimer == 0){
                        listOfEnemyCharacters.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            1 -> {
                endOfLevel = false
                if (time == 0L) {
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0), (screenHeight * 0.3).toInt(),0,100)
                    listOfTmpEnemies.add(tmp)
                } else if (time == 100L) {
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.1).toInt(),1,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0), (screenHeight * 0.1).toInt(),2,150)
                    listOfTmpEnemies.add(tmp)
                } else if (time == 200L) {
                    listOfEnemyCharacters.clear()
                    tmp=createEnemy(GHOST_CHAR, (screenWidth * 0), (screenHeight * 0.7).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)
                    tmp=createEnemy(GHOST_CHAR, (screenWidth * 0), (screenHeight * 0.2).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 350L){
                    endOfLevel=true
                }
                var contador : Int = 0
                while(contador < listOfEnemyCharacters.size){
                    if(listOfEnemyCharacters.get(contador).dissapearTimer == 0){
                        listOfEnemyCharacters.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            2 -> {
                endOfLevel = false
                if (time == 0L) {
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.1).toInt(),1,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.7).toInt(), (screenHeight * 0.1).toInt(),1,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.3).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.6).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)
                } else if (time == 100L) {
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.1).toInt(),1,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0), (screenHeight * 0.2).toInt(),2,150)
                    listOfTmpEnemies.add(tmp)
                } else if (time == 200L) {
                    listOfEnemyCharacters.clear()
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.1).toInt(), 1, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.7).toInt(), (screenHeight * 0.1).toInt(), 1, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0), (screenHeight * 0.3).toInt(), 2, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0), (screenHeight * 0.7).toInt(), 2, 150)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 250L){
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.75).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.2).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.7).toInt(), (screenHeight * 0.75).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.7).toInt(), (screenHeight * 0.2).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)

                }else if(time == 400L){
                    listOfEnemyCharacters.clear()
                    endOfLevel=true
                }
                var contador : Int = 0
                while(contador < listOfEnemyCharacters.size){
                    if(listOfEnemyCharacters.get(contador).dissapearTimer == 0){
                        listOfEnemyCharacters.removeAt(contador)
                        contador--
                    }
                    contador++
                }



            }
            3 -> {
                endOfLevel = false
                if (time == 0L) {
                    tmp = createEnemy(EYE_CHAR, 0, (screenHeight * 0.5).toInt(), 0, 150)
                    listOfTmpEnemies.add(tmp)
                } else if(time == 25L){
                    var x =  listOfEnemyCharacters[0].x
                    var y = listOfEnemyCharacters[0].y
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 4, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 0, 40)
                    listOfTmpEnemies.add(tmp)
                } else if(time == 50L){
                    var x =  listOfEnemyCharacters[0].x
                    var y = listOfEnemyCharacters[0].y
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 1, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 3, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 5, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 7, 40)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 75L) {
                    var x = listOfEnemyCharacters[0].x
                    var y = listOfEnemyCharacters[0].y
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 1, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 2, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 3, 40)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 150L){
                    listOfEnemyCharacters.clear()
                    tmp = createEnemy(EYE_CHAR, (screenWidth * 1), (screenHeight * 0.5).toInt(), 1, 150)
                    listOfTmpEnemies.add(tmp)
                    //endOfLevel=true
                }else if(time == 175L) {
                    var x =  listOfEnemyCharacters[0].x
                    var y = listOfEnemyCharacters[0].y
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 4, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 0, 40)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 200L) {
                    var x =  listOfEnemyCharacters[0].x
                    var y = listOfEnemyCharacters[0].y
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 1, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 3, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 5, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 7, 40)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 225L) {
                    var x =  listOfEnemyCharacters[0].x
                    var y = listOfEnemyCharacters[0].y
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 5, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 6, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 7, 40)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 275L){
                    listOfEnemyCharacters.clear()
                    endOfLevel=true
                }
                var contador : Int = 0
                while(contador < listOfEnemyCharacters.size){
                    if(listOfEnemyCharacters.get(contador).dissapearTimer == 0){
                        listOfEnemyCharacters.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            4 -> {
                endOfLevel = false
                if (time == 0L) {
                    tmp = createEnemy(EYE_CHAR, (screenWidth * 0.5).toInt(), 0, 2, 150)
                    listOfTmpEnemies.add(tmp)
                } else if(time == 25L){
                    var x =  listOfEnemyCharacters[0].x
                    var y = listOfEnemyCharacters[0].y
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 2, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 0, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 6, 40)
                    listOfTmpEnemies.add(tmp)
                } else if(time == 50L){
                    var x =  listOfEnemyCharacters[0].x
                    var y = listOfEnemyCharacters[0].y
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 1, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 3, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 5, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 7, 40)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 75L) {
                    var x = listOfEnemyCharacters[0].x
                    var y = listOfEnemyCharacters[0].y
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 2, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 3, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 4, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 5, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 6, 40)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 150L){
                    listOfEnemyCharacters.clear()
                    tmp = createEnemy(EYE_CHAR, (screenWidth * 0.5).toInt(), (screenWidth * 2), 3, 150)
                    listOfTmpEnemies.add(tmp)
                    //endOfLevel=true
                }else if(time == 175L) {
                    var x =  listOfEnemyCharacters[0].x
                    var y = listOfEnemyCharacters[0].y
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 3, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 4, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 5, 40)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 200L) {
                    var x =  listOfEnemyCharacters[0].x
                    var y = listOfEnemyCharacters[0].y
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 1, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 3, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 5, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 7, 40)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 225L) {
                    var x =  listOfEnemyCharacters[0].x
                    var y = listOfEnemyCharacters[0].y
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 5, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 6, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 7, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 1, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 2, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 3, 40)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 275L){
                    listOfEnemyCharacters.clear()
                    endOfLevel=true
                }
                var contador : Int = 0
                while(contador < listOfEnemyCharacters.size){
                    if(listOfEnemyCharacters.get(contador).dissapearTimer == 0){
                        listOfEnemyCharacters.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            5 -> {
                endOfLevel = false
                if (time == 0L) {
                    tmp = createEnemy(EYE_CHAR, 0, (screenHeight * 0.5).toInt(), 0, 150)
                    listOfTmpEnemies.add(tmp)
                } else if(time == 25L){
                    var x =  listOfEnemyCharacters[0].x
                    var y = listOfEnemyCharacters[0].y
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 1, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 3, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 5, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 7, 40)
                    listOfTmpEnemies.add(tmp)
                } else if(time == 50L){
                    var x =  listOfEnemyCharacters[0].x
                    var y = listOfEnemyCharacters[0].y
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 0, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 2, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 4, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 6, 40)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 75L) {
                    var x = listOfEnemyCharacters[0].x
                    var y = listOfEnemyCharacters[0].y
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 1, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 3, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 5, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 7, 40)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 125L) {
                    listOfEnemyCharacters.clear()

                    tmp = createEnemy(EYE_CHAR, (screenWidth * 0.5).toInt(), 0, 2, 150)
                    listOfTmpEnemies.add(tmp)
                } else if(time == 150L){
                    var x =  listOfEnemyCharacters[0].x
                    var y = listOfEnemyCharacters[0].y
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 2, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 0, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 6, 40)
                    listOfTmpEnemies.add(tmp)
                } else if(time == 175L){
                    var x =  listOfEnemyCharacters[0].x
                    var y = listOfEnemyCharacters[0].y
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 0, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 1, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 2, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 3, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 4, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 5, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 6, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 7, 40)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 220L) {
                    var x = listOfEnemyCharacters[0].x
                    var y = listOfEnemyCharacters[0].y
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 2, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 6, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 4, 40)
                    listOfTmpEnemies.add(tmp)
                }else if(time==300L){
                    listOfEnemyCharacters.clear()
                    tmp = createEnemy(EYE_CHAR, 0, (screenHeight * 0.3).toInt(), 0, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_CHAR, (screenWidth * 1), (screenHeight * 0.7).toInt(), 1, 150)
                    listOfTmpEnemies.add(tmp)
                }else if (time == 350L){
                    var x1 = listOfEnemyCharacters[0].x
                    var y1 = listOfEnemyCharacters[0].y
                    var x2 = listOfEnemyCharacters[1].x
                    var y2 = listOfEnemyCharacters[1].y
                    tmp = createEnemy(EYE_PROJECTILE, x1, y1, 0, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x1, y1, 1, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x1, y1, 7, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x2, y2, 3, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x2, y2, 4, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x2, y2, 5, 40)
                    listOfTmpEnemies.add(tmp)
                }else if (time == 400L){
                    listOfEnemyCharacters.clear()
                    tmp = createEnemy(EYE_CHAR, (screenWidth * 0.2).toInt(), 0, 2, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_CHAR, (screenWidth * 0.8).toInt(), (screenWidth * 2), 3, 150)
                    listOfTmpEnemies.add(tmp)
                }else if (time == 450L){
                    var x1 = listOfEnemyCharacters[0].x
                    var y1 = listOfEnemyCharacters[0].y
                    var x2 = listOfEnemyCharacters[1].x
                    var y2 = listOfEnemyCharacters[1].y
                    tmp = createEnemy(EYE_PROJECTILE, x1, y1, 5, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x1, y1, 6, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x1, y1, 7, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x2, y2, 1, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x2, y2, 2, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x2, y2, 3, 40)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 500L){
                    listOfEnemyCharacters.clear()
                    endOfLevel=true
                }
                var contador : Int = 0
                while(contador < listOfEnemyCharacters.size){
                    if(listOfEnemyCharacters.get(contador).dissapearTimer == 0){
                        listOfEnemyCharacters.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            6 -> {
                endOfLevel = false
                if (time == 0L) {
                    tmp = createEnemy(EYE_CHAR, 0, (screenHeight * 0.5).toInt(), 0, 150)
                    listOfTmpEnemies.add(tmp)
                } else if(time == 50L){
                    var x =  listOfEnemyCharacters[0].x
                    var y = listOfEnemyCharacters[0].y
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 0, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 1, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 2, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 3, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 4, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 5, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 6, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 7, 40)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 150L){
                    listOfEnemyCharacters.clear()
                    endOfLevel=true
                }
                var contador : Int = 0
                while(contador < listOfEnemyCharacters.size){
                    if(listOfEnemyCharacters.get(contador).dissapearTimer == 0){
                        listOfEnemyCharacters.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            7 -> {
            }
            8 -> {
            }
            9 -> {
            }
            10 -> {
            }
            11 -> {
            }
            12 -> {
            }
        }

        listOfEnemyCharacters.addAll(listOfTmpEnemies)
    }

    override fun buildCoins(levelWorld: Int, time: Long) {
        //Log.d("TIME", (time).toInt().toString())
        //Log.d("CONTADOR MONEDAS", coinCounter.toString())

        var tmpListOfCoins: ArrayList<Coin> = ArrayList()

        when (levelWorld) {
             0 -> {
                if (time  == 50L) {
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                    createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(), 3,dissapearTimer = 100))
                } else if (time == 300L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.7).toInt(), 4,dissapearTimer = 100))
                }
                var contador : Int = 0
                while(contador < listOfCoins.size){
                    if(listOfCoins.get(contador).dissapearTimer == 0){
                        listOfCoins.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            1 -> {
                if (time == 50L) {
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(), 5,dissapearTimer = 100))
                } else if (time == 200L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.6).toInt(), (screenHeight * 0.7).toInt(), 6,dissapearTimer = 100),
                        createCoin("Coin", (screenWidth * 0.2).toInt(), (screenHeight * 0.5).toInt(), 1,dissapearTimer = 100))
                }
                var contador : Int = 0
                while(contador < listOfCoins.size){
                    if(listOfCoins.get(contador).dissapearTimer == 0){
                        listOfCoins.removeAt(contador)
                        contador--
                    }
                    contador++
                }

            }
            2 -> {

                if (time == 50L) {
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(), 3,dissapearTimer = 150))

                } else if (time == 100L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.2).toInt(), 2,dissapearTimer = 150))

                } else if (time == 300L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.5).toInt(), 5,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.5).toInt(), 3,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.4).toInt(), 2,dissapearTimer = 150),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.6).toInt(), 4,dissapearTimer = 150))
                }
                var contador : Int = 0
                while(contador < listOfCoins.size){
                    if(listOfCoins.get(contador).dissapearTimer == 0){
                        listOfCoins.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            3 -> {
                if (time == 20L) {
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.4).toInt(), (screenHeight * 0.6).toInt(), 3,dissapearTimer = 100))
                }else if (time == 70L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.4).toInt(), 8,dissapearTimer = 100))
                }else if (time == 200L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.3).toInt(), 4,dissapearTimer = 100),
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.2).toInt(), 6,dissapearTimer = 100))
                }
                var contador : Int = 0
                while(contador < listOfCoins.size){
                    if(listOfCoins.get(contador).dissapearTimer == 0){
                        listOfCoins.removeAt(contador)
                        contador--
                    }
                    contador++
                }

            }
            4 -> {
                if (time == 20L) {
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.4).toInt(), 3,dissapearTimer = 100))
                }else if (time == 70L){
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.4).toInt(), 8,dissapearTimer = 100))
                }else if (time == 200L){
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.5).toInt(), 4,dissapearTimer = 100))
                }
                var contador : Int = 0
                while(contador < listOfCoins.size){
                    if(listOfCoins.get(contador).dissapearTimer == 0){
                        listOfCoins.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            5 -> {
                if (time == 20L) {
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.75).toInt(), 3,dissapearTimer = 100),
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.3).toInt(), 4,dissapearTimer = 100),
                        createCoin("Coin", (screenWidth * 0.8).toInt(), (screenHeight * 0.5).toInt(), 1,dissapearTimer = 100))
                }else if (time == 130L){
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(), 7,dissapearTimer = 100),
                        createCoin("Coin", (screenWidth * 0.8).toInt(), (screenHeight * 0.8).toInt(), 8,dissapearTimer = 100))
                }else if (time == 320L){
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(), 6,dissapearTimer = 100))
                }else if (time == 430L){
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(), 6,dissapearTimer = 100))
                }
                var contador : Int = 0
                while(contador < listOfCoins.size){
                    if(listOfCoins.get(contador).dissapearTimer == 0){
                        listOfCoins.removeAt(contador)
                        contador--
                    }
                    contador++
                }
            }
            6 -> {
            }
            7 -> {
            }
            8 -> {
            }
            9 -> {
            }
            10 -> {
            }
            11 -> {
            }
            12 -> {
            }
        }
        listOfCoins.addAll(tmpListOfCoins)
    }

    override fun createLimits(levelWorld: Int): ArrayList<Int> {

        var listOfLimits: ArrayList<Int> = ArrayList()

        when (levelWorld) {
            0 -> {
                listOfLimits.add(2)
                listOfLimits.add(10)
            }
            1 -> {
                listOfLimits.add(10)
                listOfLimits.add(25)
            }
            2 -> {
                listOfLimits.add(10)
                listOfLimits.add(30)
            }
            3 -> {
                listOfLimits.add(10)
                listOfLimits.add(100)
            }
            4 -> {
                listOfLimits.add(12)
                listOfLimits.add(100)
            }
            5 -> {
                listOfLimits.add(12)
                listOfLimits.add(100)
            }
            6 -> {
                listOfLimits.add(50)
                listOfLimits.add(100)
            }
            7 -> {
                listOfLimits.add(50)
                listOfLimits.add(100)
            }
            8 -> {
                listOfLimits.add(50)
                listOfLimits.add(100)
            }
            9 -> {
                listOfLimits.add(50)
                listOfLimits.add(100)
            }
            10 -> {
                listOfLimits.add(50)
                listOfLimits.add(100)

            }
            11 -> {
                listOfLimits.add(50)
                listOfLimits.add(100)

            }
            12 -> {
                listOfLimits.add(50)
                listOfLimits.add(100)
            }
        }
        return listOfLimits
    }

}
