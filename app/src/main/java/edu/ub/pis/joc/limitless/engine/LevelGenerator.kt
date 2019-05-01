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

class LevelGenerator(
    var contextApp: Context,
    var listOfEnemyCharacters: ArrayList<Enemy>,
    var listOfCoins: ArrayList<Coin>
) {

    var characterFactory: CharacterFactory =
        CharacterFactory(contextApp)

    var endOfLevel : Boolean = false

    fun createCoin(
        character: String,
        posX: Int = (screenWidth * 0.5).toInt(),
        posY: Int = (screenHeight * 0.5).toInt(),
        value: Int = 1,
        font : Typeface = Typeface.createFromAsset(contextApp.assets, FONT_CRIME_SIX)
    ): Coin {
        Log.d("AÑADE MONEDA", character)
        val coin = characterFactory.createCharacter(character, posX, posY) as Coin
        coin.value = value
        coin.paint.typeface = font
        return coin
    }

    fun createEnemy(
        character: String,
        posX: Int = (screenWidth * 0.5).toInt(),
        posY: Int = (screenHeight * 0.5).toInt(),
        behaviour : Int,
        dissapearTimer : Int
        ): Enemy {
        Log.d("AÑADE ENEMY", character)
        val enemy =characterFactory.createCharacter(character, posX, posY) as Enemy
        enemy.concreteBehavior = behaviour
        enemy.dissapearTimer = dissapearTimer
        return enemy
    }



    fun buildEnemies(levelWorld: Int, time: Long) {
        //Log.d("TIME", (time).toInt().toString())
        //Log.d("CONTADOR ENEMIGOS", enemyCounter.toString())
        var listOfTmpEnemies = ArrayList<Enemy>()
        var tmp : Enemy
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
                } else if (time == 400L) {
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
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(),0,50)
                    listOfTmpEnemies.add(tmp)
                } else if (time == 100L) {
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.1).toInt(),1,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.1).toInt(),2,150)
                    listOfTmpEnemies.add(tmp)
                } else if (time == 200L) {
                    listOfEnemyCharacters.clear()
                    tmp=createEnemy(GHOST_CHAR, (screenWidth * 0.6).toInt(), (screenHeight * 0.7).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)
                    tmp=createEnemy(GHOST_CHAR, (screenWidth * 0.2).toInt(), (screenHeight * 0.5).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 450L){
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
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(),1,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.7).toInt(), (screenHeight * 0.3).toInt(),1,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.3).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.6).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)
                } else if (time == 100L) {
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.1).toInt(),1,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.2).toInt(),2,150)
                    listOfTmpEnemies.add(tmp)
                } else if (time == 200L) {
                    listOfEnemyCharacters.clear()
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(), 1, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.7).toInt(), (screenHeight * 0.3).toInt(), 1, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(), 2, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.7).toInt(), 2, 150)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 250L){
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.4).toInt(), (screenHeight * 0.75).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.6).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.7).toInt(), (screenHeight * 0.75).toInt(),0,150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.6).toInt(),0,150)
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
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 0, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 4, 40)
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
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 0, 40)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 4, 40)
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
            4 -> {
                endOfLevel = false
                if (time == 0L) {
                    tmp = createEnemy(SKULL_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.1).toInt(), 0, 150)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(SKULL_LASER, (screenWidth * 0.5).toInt(), (screenHeight * 0.1).toInt(), 0, 150)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 200L){
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
                    tmp = createEnemy(EYE_CHAR, 0, (screenHeight * 0.5).toInt(), 1, 150)
                    listOfTmpEnemies.add(tmp)
                }else if(time == 200L){
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

    fun buildCoins(levelWorld: Int, time: Long) {
        //Log.d("TIME", (time).toInt().toString())
        //Log.d("CONTADOR MONEDAS", coinCounter.toString())

        var tmpListOfCoins: ArrayList<Coin> = ArrayList()

        when (levelWorld) {
            0 -> {
                if (time  == 50L) {
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                    createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(), 3))
                } else if (time == 300L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.7).toInt(), 4))
                }
            }
            1 -> {
                if (time == 50L) {
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(), 5))
                } else if (time == 200L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.6).toInt(), (screenHeight * 0.7).toInt(), 6),
                        createCoin("Coin", (screenWidth * 0.2).toInt(), (screenHeight * 0.5).toInt(), 1))
                }

            }
            2 -> {

                if (time == 50L) {
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(), 3))
                } else if (time == 100L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.2).toInt(), 2))
                } else if (time == 200L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.75).toInt(), 7))
                } else if (time == 300L){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.4).toInt(), 5))
                }

            }
            3 -> {
            }
            4 -> {
            }
            5 -> {
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

    fun createLimits(levelWorld: Int):ArrayList<Int> {

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
                listOfLimits.add(50)
                listOfLimits.add(100)
            }
            4 -> {
                listOfLimits.add(50)
                listOfLimits.add(100)
            }
            5 -> {
                listOfLimits.add(50)
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

    fun buildPlayer(): PlayerCharacter {
        return characterFactory.createCharacter(
            "PlayerCharacter",
            (screenWidth * 0.75).toInt(),
            (screenHeight * 0.75).toInt()
        ) as PlayerCharacter
    }
}