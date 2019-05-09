package edu.ub.pis.joc.limitless.engine


import android.content.Context
import android.graphics.*
import android.util.Log
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.game.*
import edu.ub.pis.joc.limitless.view.GameActivity
import edu.ub.pis.joc.limitless.view.gamescreen.InGameBorder
import edu.ub.pis.joc.limitless.view.gamescreen.Limits
import edu.ub.pis.joc.limitless.view.gamescreen.PauseButton
import java.util.*

class GameEngine(private var contextEngine: Context, var mode: Boolean, var versus: Boolean) {

    var touched_x = 0
    var touched_y = 0
    var touched: Int = 0

    var gameTime: Long = 0

    var listOfEnemyCharacters =
        ArrayList<Enemy>() //tendremos una lista de enemigos la cual iteraremos donde nos interese
    var listOfCoins = ArrayList<Coin>()

    var level: Level
    private var currentLevelWorld: Int

    var ai = ArtificialIntelligence()

    var optionsGameBorder : BitmapFactory.Options = BitmapFactory.Options()

    var limits: Limits? = null

    init {
        if (mode) {
            currentLevelWorld = NIVEL_INFINITO
            level = LevelInfinite(contextEngine, listOfEnemyCharacters, listOfCoins)
        } else {
            currentLevelWorld = Data.getCurrenLevel()
            level = LevelPractice(contextEngine, listOfEnemyCharacters, listOfCoins)

            limits = Limits(level.createLimits(currentLevelWorld)[0],level.createLimits(currentLevelWorld)[1])
        }

        Log.d("CURRENT LEVEL", currentLevelWorld.toString())


        optionsGameBorder.inSampleSize = 2


    }

    private var inGameBorder: InGameBorder = InGameBorder(
        BitmapFactory.decodeResource(contextEngine.resources, R.drawable.in_game_border,optionsGameBorder)
    )

    var pauseButton: PauseButton =
        PauseButton(BitmapFactory.decodeResource(contextEngine.resources, R.drawable.pause_button))


    var player: PlayerCharacter = level.buildPlayer()

    var scoreLimits = level.createLimits(currentLevelWorld)

    fun update() {
            for (i in 0 until listOfEnemyCharacters.size) {
                listOfEnemyCharacters[i].update()
                (listOfEnemyCharacters[i].characterHitsPlayer(player))
                if (mode && (listOfEnemyCharacters[i].characterHitsPlayer(player))) {
                    if (ai.calls < 1) {
                        ai.updateBestBehaviour(listOfEnemyCharacters[i])
                    }
                }


            }
            if (!player.imageList[0].isRecycled) {
                if (touched == 1) {
                    player.update(touched_x, touched_y, false)
                } else if (touched == 2) {
                    player.update(touched_x, touched_y, true)
                }
            }

            var coinIterator = 0
            while (coinIterator < listOfCoins.size) {
                val taken: Boolean = player.takesCoin(listOfCoins[coinIterator])
                if (taken) {
                    listOfCoins.removeAt(coinIterator)
                    coinIterator--
                }
                coinIterator++
            }

            for (i in 0 until listOfCoins.size) {
                listOfCoins[i].update()
            }
        level.buildEnemies(currentLevelWorld, gameTime)
        level.buildCoins(currentLevelWorld, gameTime)
        gameTime++
    }

    /**
     * Everything that has to be drawn on Canvas
     */

    fun draw(canvas: Canvas) {
        inGameBorder.draw(canvas)
        pauseButton.draw(canvas)

        if(limits != null){
            limits!!.draw(canvas)
        }

        if (!player.imageList[0].isRecycled) {
            player.draw(canvas)
        }

        for (i in 0 until listOfEnemyCharacters.size) {
            listOfEnemyCharacters[i].draw(canvas)
        }
        for (i in 0 until listOfCoins.size) {
            if (listOfCoins[i].imageList[0].isRecycled) {
                listOfCoins.remove(listOfCoins[i])
            } else {
                listOfCoins[i].draw(canvas)
            }
        }
    }

    fun endGame() {
        val activity = (contextEngine as GameActivity)
        val time = gameTime/30
        var updateDb = false
        val dead = player.imageList[0].isRecycled
        val gOverPoints = player.accumulate > scoreLimits[0] && player.accumulate < scoreLimits[1]
        if (dead) {
            if (mode) {
                if (!versus) {
                    if (time > Data.user.survived!!) {
                        Data.user.survived = time
                        updateDb = true
                    }
                }
            }
        }
        activity.onEndGame(contextEngine, updateDb, time, dead, gOverPoints)
    }
}