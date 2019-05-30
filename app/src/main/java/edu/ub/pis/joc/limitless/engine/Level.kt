package edu.ub.pis.joc.limitless.engine

import android.content.res.AssetManager
import android.graphics.Typeface
import android.util.Log
import edu.ub.pis.joc.limitless.model.game.*
import edu.ub.pis.joc.limitless.view.ViewAdjuster
import edu.ub.pis.joc.limitless.view.gamescreen.Limits
import java.io.File
import java.util.*

const val NIVEL_INFINITO = -1

const val FONTS_ASSETS = "fonts"
const val FONT_LIMITS = "roadrage.otf"
const val FONT_COINS = "crimestimessix.ttf"

abstract class Level(
    var assets: AssetManager,
    var listOfEnemyCharacters: ArrayList<Enemy>,
    var listOfCoins: ArrayList<Coin>
) {

    lateinit var limits: Limits
    var newStage = false
    var infiniteMode = false //usamos este booleano para saber si estamos en los preeliminares del Infinito
    //o en el modo de generación automática
    var characterFactory: CharacterFactory =
        CharacterFactory(assets)
    /*
    Funcio amb la que crearem monedes
    @params : String
    @params : Int
    @params : Int
    @params : Int
    @params : Typeface
    @params : Int

    @return : Coin
     */
    fun createCoin(
        character: String,
        posX: Int ,
        posY: Int ,
        value: Int,
        font: Typeface = Typeface.createFromAsset(assets, FONTS_ASSETS + File.separator + FONT_COINS),
        dissapearTimer: Int
    ): Coin {
        Log.d("AÑADE MONEDA", character)
        val coin = characterFactory.createCharacter(character, posX, posY) as Coin
        coin.value = value
        coin.paint.typeface = font
        coin.dissapearTimer = dissapearTimer
        return coin
    }
    /*
    Funcio amb la que crearem Enemics simples
    @params : String
    @params : Int
    @params : Int
    @params : Int
    @params : Int

    @return : Enemy
     */
    fun createEnemy(
        character: String,
        posX: Int,
        posY: Int,
        behaviour: Int,
        dissapearTimer: Int
    ): Enemy {
        Log.d("AÑADE ENEMY", character)
        val enemy = characterFactory.createCharacter(character, posX, posY, behaviour) as Enemy
        enemy.dissapearTimer = dissapearTimer
        return enemy
    }
    /*
    Funcio amb la que crearem Enemics complexes
    @params : String
    @params : Int
    @params : Int
    @params : Int
    @params : Int
    @params : Int

    @return : Enemy
     */
    fun createComplexEnemy(
        character: String,
        posX: Int = (ViewAdjuster.screenWidth * 0.5).toInt(),
        posY: Int = (ViewAdjuster.screenHeight * 0.5).toInt(),
        behaviour: Int,
        dissapearTimer: Int,
        childList : Int
    ): Enemy {
        Log.d("AÑADE COMPLEX ENEMY", character)
        val enemy = characterFactory.createComplexCharacter(character, posX, posY,childList, assets, behaviour) as Enemy
        enemy.dissapearTimer = dissapearTimer
        return enemy
    }
    /*
    Funcio amb la que crearem el jugador principal
    @params : Int

    @return : PlayerCharacter
     */

    fun buildPlayer(round : Int): PlayerCharacter {
        val player = if (round == -1) PLAYER_CHARACTER else if (round == 0) PLAYER_CHARACTER1 else PLAYER_CHARACTER2
        return characterFactory.createCharacter(
            player,
            (ViewAdjuster.screenWidth * 0.5).toInt(),
            (ViewAdjuster.screenHeight * 0.5).toInt()
        ) as PlayerCharacter
    }
    /*
    Funcions abstractes que s'utilitzaran a LevelPractice i LevelInfinite
     */
    abstract fun buildEnemies(levelWorld: Int, time: Long)
    abstract fun buildCoins(levelWorld: Int, time: Long)
    abstract fun createLimits(levelWorld: Int): ArrayList<Int>

}