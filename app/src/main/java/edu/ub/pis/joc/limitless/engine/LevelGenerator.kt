package edu.ub.pis.joc.limitless.engine

import android.content.Context
import android.graphics.Typeface
import android.util.Log
import edu.ub.pis.joc.limitless.model.Data.screenHeight
import edu.ub.pis.joc.limitless.model.Data.screenWidth
import edu.ub.pis.joc.limitless.model.game.*
import java.util.ArrayList

class LevelGenerator(
    var contextApp: Context,
    var listOfEnemyCharacters: ArrayList<Enemy>,
    var listOfCoins: ArrayList<NumberCharacter>
) {

    var characterFactory: CharacterFactory =
        CharacterFactory(contextApp)

    var enemyCounter: Int = 0
    var coinCounter: Int = 0

    fun addNumberToList(
        character: String,
        posX: Int = (screenWidth * 0.5).toInt(),
        posY: Int = (screenHeight * 0.5).toInt(),
        value : Int = 1,
        font : Typeface = Typeface.createFromAsset(contextApp.assets, "fonts/Crimes Times Six.ttf")
    ) {
        Log.d("AÑADE MONEDA", character)
        val num: NumberCharacter =
            characterFactory.createCharacter(character, posX, posY, value, font) as NumberCharacter
        listOfCoins.add(num)
    }

    fun addCharacterToList(character: String, posX: Int = (screenWidth * 0.5).toInt(), posY: Int = (screenHeight * 0.5).toInt()) {
        Log.d("AÑADE ENEMY", character)
        val enemy: Enemy = characterFactory.createCharacter(character, posX, posY) as Enemy
        listOfEnemyCharacters.add(enemy)
    }

    fun buildEnemies(levelWorld: Int, time: Long) {
        //Log.d("TIME", (time).toInt().toString())
        //Log.d("CONTADOR ENEMIGOS", enemyCounter.toString())

        when (levelWorld) {
            0 -> {
                if (time == 0L && enemyCounter == 0) {
                    listOfEnemyCharacters.clear()
                    addCharacterToList(DEMON_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt())
                    enemyCounter = 1

                } else if (time > 200L && enemyCounter == 1) {
                    listOfEnemyCharacters.clear()
                    addCharacterToList(SKULL_CHAR, (screenWidth * 0.5).toInt(), (screenHeight * 0.1).toInt())
                    addCharacterToList(SKULL_LASER, (screenWidth * 0.5).toInt(), (screenHeight * 0.1).toInt())
                    enemyCounter = 2

                } else if (time > 400L && enemyCounter == 2) {
                    listOfEnemyCharacters.clear()
                    addCharacterToList(DEMON_CHAR, (screenWidth * 0.6).toInt(), (screenHeight * 0.7).toInt())
                    addCharacterToList(DEMON_CHAR, (screenWidth * 0.3).toInt(), (screenHeight * 0.5).toInt())
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
    }

    fun buildCoins(levelWorld: Int, time: Long) {
        //Log.d("TIME", (time).toInt().toString())
        //Log.d("CONTADOR MONEDAS", coinCounter.toString())

        when (levelWorld) {
            0 -> {
                if (time > 100L && coinCounter == 0) {
                    listOfCoins.clear()
                    addNumberToList("NumberCharacter", (screenWidth * 0.3).toInt(), (screenHeight * 0.3).toInt(), 5)
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
    }

    fun buildPlayer(): PlayerCharacter {
        return characterFactory.createCharacter(
            "PlayerCharacter",
            (screenWidth * 0.75).toInt(),
            (screenHeight * 0.75).toInt()
        ) as PlayerCharacter
    }
}