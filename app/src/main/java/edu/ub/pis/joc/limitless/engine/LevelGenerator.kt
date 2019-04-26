package edu.ub.pis.joc.limitless.engine

import android.content.Context
import android.graphics.Typeface
import android.util.Log
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
        posY: Int = (screenHeight * 0.5).toInt()
    ): Enemy {
        Log.d("AÑADE ENEMY", character)
        val tmpChar : Character
        tmpChar=characterFactory.createCharacter(character, posX, posY) as Enemy
        return tmpChar

    }



    fun buildEnemies(levelWorld: Int, time: Long) {
        //Log.d("TIME", (time).toInt().toString())
        //Log.d("CONTADOR ENEMIGOS", enemyCounter.toString())
        var tmpListOfEnemyCharacters: ArrayList<Enemy> = ArrayList()
        var listOfTmpEnemies = ArrayList<Enemy>()
        var tmp : Enemy
        when (levelWorld) {
            0 -> {
                if (time == 0L && enemyCounter == 0) {
                    tmp = createEnemy(DEMON_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt())
                    tmp.behaviour = 0
                    listOfTmpEnemies.add(tmp)
                    tmpListOfEnemyCharacters = listOfTmpEnemies
                    enemyCounter = 1
                } else if (time > 200L && enemyCounter == 1) {
                    tmp = createEnemy(SKULL_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.1).toInt())
                    tmp.behaviour=0
                    listOfTmpEnemies.add(tmp)
                    tmp = createEnemy(SKULL_LASER, (screenWidth * 0.5).toInt(), (screenHeight * 0.1).toInt())
                    tmp.behaviour=0
                    listOfTmpEnemies.add(tmp)
                    tmpListOfEnemyCharacters = listOfTmpEnemies
                    enemyCounter = 2
                } else if (time > 400L && enemyCounter == 2) {
                    listOfEnemyCharacters.clear()
                    tmp=createEnemy(DEMON_CHAR, (screenWidth * 0.6).toInt(), (screenHeight * 0.7).toInt())
                    tmp.behaviour=1
                    listOfTmpEnemies.add(tmp)
                    tmp=createEnemy(DEMON_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.5).toInt())
                    tmp.behaviour=2
                    listOfTmpEnemies.add(tmp)
                    tmpListOfEnemyCharacters = listOfTmpEnemies
                    enemyCounter = 3
                }
            }
            1 -> {
            }
            2 -> {
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
                    createCoin("Coin", (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(), 5))
                    coinCounter = 1
                }
            }
            1 -> {
            }
            2 -> {
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

    fun buildPlayer(): PlayerCharacter {
        return characterFactory.createCharacter(
            "PlayerCharacter",
            (screenWidth * 0.75).toInt(),
            (screenHeight * 0.75).toInt()


        ) as PlayerCharacter
    }
}