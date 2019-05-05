package edu.ub.pis.joc.limitless.engine

import android.app.backup.FullBackupDataOutput
import android.content.Context
import android.graphics.Typeface
import android.util.Log
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.game.CharacterFactory
import edu.ub.pis.joc.limitless.model.game.Coin
import edu.ub.pis.joc.limitless.model.game.Enemy
import edu.ub.pis.joc.limitless.model.game.PlayerCharacter
import edu.ub.pis.joc.limitless.view.FullScreenActivity
import java.util.ArrayList
const val NIVEL_INFINITO = -1
abstract class Level(
    var contextApp: Context,
    var listOfEnemyCharacters: ArrayList<Enemy>,
    var listOfCoins: ArrayList<Coin>
) {


    var characterFactory: CharacterFactory =
        CharacterFactory(contextApp)

    var endOfLevel: Boolean = false

    fun createCoin(
        character: String,
        posX: Int ,
        posY: Int ,
        value: Int,
        font: Typeface = Typeface.createFromAsset(contextApp.assets, FONT_CRIME_SIX),
        dissapearTimer: Int
    ): Coin {
        Log.d("AÑADE MONEDA", character)
        val coin = characterFactory.createCharacter(character, posX, posY) as Coin
        coin.value = value
        coin.paint.typeface = font
        coin.dissapearTimer = dissapearTimer
        return coin
    }

    fun createEnemy(
        character: String,
        posX: Int,
        posY: Int,
        behaviour: Int,
        dissapearTimer: Int
    ): Enemy {
        Log.d("AÑADE ENEMY", character)
        val enemy = characterFactory.createCharacter(character, posX, posY) as Enemy
        enemy.concreteBehavior = behaviour
        enemy.dissapearTimer = dissapearTimer
        return enemy
    }

    fun createComplexEnemy(
        character: String,
        posX: Int = (Data.screenWidth * 0.5).toInt(),
        posY: Int = (Data.screenHeight * 0.5).toInt(),
        behaviour: Int,
        dissapearTimer: Int,
        childList : Int
    ): Enemy {
        Log.d("AÑADE COMPLEX ENEMY", character)
        val enemy = characterFactory.createComplexCharacter(character, posX, posY,childList,contextApp) as Enemy
        enemy.concreteBehavior = behaviour
        enemy.dissapearTimer = dissapearTimer
        return enemy
    }


    fun buildPlayer(): PlayerCharacter {
        return characterFactory.createCharacter(
            "PlayerCharacter",
            (Data.screenWidth * 0.75).toInt(),
            (Data.screenHeight * 0.75).toInt()
        ) as PlayerCharacter
    }



    abstract fun buildEnemies(levelWorld: Int, time: Long)
    abstract fun buildCoins(levelWorld: Int, time: Long)
    abstract fun createLimits(levelWorld: Int): ArrayList<Int>

}