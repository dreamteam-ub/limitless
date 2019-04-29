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

    var enemyCounter: Int = 0
    var coinCounter: Int = 0
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
        var tmpListOfEnemyCharacters: ArrayList<Enemy> = ArrayList()
        var listOfTmpEnemies = ArrayList<Enemy>()
        var tmp : Enemy
        when (levelWorld) {
            0 -> {
                endOfLevel = false
                if (time == 0L && enemyCounter == 0) {
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.2).toInt(), (screenHeight * 0.5).toInt(), 0, 300)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.5).toInt(), 0, 300)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.4).toInt(), (screenHeight * 0.5).toInt(), 0, 300)
                    listOfTmpEnemies.add(tmp)
                    tmpListOfEnemyCharacters = listOfTmpEnemies
                    enemyCounter = 1
                } else if (time > 100L && enemyCounter == 1) {
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.2).toInt(), 0, 300)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.3).toInt(), 0, 300)
                    listOfTmpEnemies.add(tmp)
                    tmpListOfEnemyCharacters = listOfTmpEnemies
                    enemyCounter = 2
                } else if (time > 400L && enemyCounter == 2) {
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.8).toInt(), (screenHeight * 0.5).toInt(), 0, 300)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.7).toInt(), (screenHeight * 0.5).toInt(), 0, 300)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.6).toInt(), (screenHeight * 0.5).toInt(), 0, 300)
                    listOfTmpEnemies.add(tmp)
                    tmpListOfEnemyCharacters = listOfTmpEnemies
                    enemyCounter = 3
                } else if (time > 800L && enemyCounter == 3) {
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
                if (time == 0L && enemyCounter == 0) {
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(),0,100)
                    listOfTmpEnemies.add(tmp)
                    tmpListOfEnemyCharacters = listOfTmpEnemies
                    enemyCounter = 1
                } else if (time > 200L && enemyCounter == 1) {
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.1).toInt(),1,300)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.1).toInt(),2,300)
                    listOfTmpEnemies.add(tmp)
                    tmpListOfEnemyCharacters = listOfTmpEnemies
                    enemyCounter = 2
                } else if (time > 400L && enemyCounter == 2) {
                    listOfEnemyCharacters.clear()
                    tmp=createEnemy(GHOST_CHAR, (screenWidth * 0.6).toInt(), (screenHeight * 0.7).toInt(),0,300)
                    listOfTmpEnemies.add(tmp)
                    tmp=createEnemy(GHOST_CHAR, (screenWidth * 0.2).toInt(), (screenHeight * 0.5).toInt(),0,300)
                    listOfTmpEnemies.add(tmp)
                    tmpListOfEnemyCharacters = listOfTmpEnemies
                    enemyCounter = 3
                }else if(time > 700L && enemyCounter == 3){
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
                if (time == 0L && enemyCounter == 0) {
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(),1,300)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.7).toInt(), (screenHeight * 0.3).toInt(),1,300)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.3).toInt(),0,300)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.6).toInt(),0,300)
                    listOfTmpEnemies.add(tmp)
                    tmpListOfEnemyCharacters = listOfTmpEnemies
                    enemyCounter = 1
                } else if (time > 200L && enemyCounter == 1) {
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.1).toInt(),1,300)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.2).toInt(),2,300)
                    listOfTmpEnemies.add(tmp)
                    tmpListOfEnemyCharacters = listOfTmpEnemies
                    enemyCounter = 2
                } else if (time > 400L && enemyCounter == 2) {
                    listOfEnemyCharacters.clear()
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(), 1, 300)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.7).toInt(), (screenHeight * 0.3).toInt(), 1, 300)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(), 2, 300)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(GHOST_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.7).toInt(), 2, 300)
                    listOfTmpEnemies.add(tmp)
                    tmpListOfEnemyCharacters = listOfTmpEnemies
                    enemyCounter = 3
                }else if(time > 500L && enemyCounter == 3){
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.4).toInt(), (screenHeight * 0.75).toInt(),0,300)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.6).toInt(),0,300)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.7).toInt(), (screenHeight * 0.75).toInt(),0,300)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(BOMB_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.6).toInt(),0,300)
                    listOfTmpEnemies.add(tmp)
                    tmpListOfEnemyCharacters = listOfTmpEnemies
                    enemyCounter = 4
                }else if(time > 800L && enemyCounter == 4){
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
                if (time == 0L && enemyCounter == 0) {
                    tmp = createEnemy(EYE_CHAR, 0, (screenHeight * 0.5).toInt(), 0, 100)
                    listOfTmpEnemies.add(tmp)
                    tmpListOfEnemyCharacters = listOfTmpEnemies
                    enemyCounter = 1
                } else if(time > 100L && enemyCounter == 1){
                    var x =  listOfEnemyCharacters[0].x
                    var y = listOfEnemyCharacters[0].y
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 0, 80)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 1, 80)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 2, 80)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 3, 80)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 4, 80)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 5, 80)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 6, 80)
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(EYE_PROJECTILE, x, y, 7, 80)
                    listOfTmpEnemies.add(tmp)
                    tmpListOfEnemyCharacters = listOfTmpEnemies
                    enemyCounter = 2
                }else if(time > 300L && enemyCounter == 2){
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

        listOfEnemyCharacters.addAll(tmpListOfEnemyCharacters)
    }

    fun buildCoins(levelWorld: Int, time: Long) {
        //Log.d("TIME", (time).toInt().toString())
        //Log.d("CONTADOR MONEDAS", coinCounter.toString())

        var tmpListOfCoins: ArrayList<Coin> = ArrayList()

        when (levelWorld) {
            0 -> {
                if (time > 100L && coinCounter == 0) {
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                    createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(), 3))
                    coinCounter = 1
                } else if (time > 600L && coinCounter == 1){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.7).toInt(), (screenHeight * 0.7).toInt(), 4))
                    coinCounter = 2
                }
            }
            1 -> {
                if (time > 100L && coinCounter == 0) {
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(), 5))
                    coinCounter = 1
                } else if (time > 400L && coinCounter == 1){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.6).toInt(), (screenHeight * 0.7).toInt(), 6),
                        createCoin("Coin", (screenWidth * 0.2).toInt(), (screenHeight * 0.5).toInt(), 1))
                    coinCounter = 2
                }

            }
            2 -> {

                if (time > 100L && coinCounter == 0) {
                    listOfCoins.clear()
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.5).toInt(), 3))
                    coinCounter = 1
                } else if (time > 200L && coinCounter == 1){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.2).toInt(), 2))
                    coinCounter = 2
                } else if (time > 400L && coinCounter == 2){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.75).toInt(), 7))
                    coinCounter = 3
                } else if (time > 600L && coinCounter == 3){
                    tmpListOfCoins = arrayListOf(
                        createCoin("Coin", (screenWidth * 0.5).toInt(), (screenHeight * 0.4).toInt(), 5))
                    coinCounter = 4
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