package edu.ub.pis.joc.limitless.engine


import android.content.Context
import android.graphics.*
import android.os.AsyncTask
import android.util.Log
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.game.*
import edu.ub.pis.joc.limitless.view.GameActivity
import edu.ub.pis.joc.limitless.view.gamescreen.InGameBorder
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

    init {
        if (mode) {
            currentLevelWorld = NIVEL_INFINITO
            level = LevelInfinite(contextEngine, listOfEnemyCharacters, listOfCoins)
        } else {
            currentLevelWorld = Data.getCurrenLevel()
            level = LevelPractice(contextEngine, listOfEnemyCharacters, listOfCoins)
        }

        Log.d("CURRENT LEVEL", currentLevelWorld.toString())

    }

    private var inGameBorder: InGameBorder = InGameBorder(
        BitmapFactory.decodeResource(
            contextEngine.resources,
            R.drawable.in_game_border
        )
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

        BuildTask(level, currentLevelWorld, gameTime).execute()
        gameTime++
    }

    /**
     * Everything that has to be drawn on Canvas
     */

    fun draw(canvas: Canvas) {
        inGameBorder.draw(canvas)
        pauseButton.draw(canvas)

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

    class BuildTask(
        private var level: Level,
        private var currentLevelWorld: Int,
        private var gameTime: Long
    ) : AsyncTask<Void, Void, Boolean>() {
        override fun doInBackground(vararg params: Void?): Boolean? {
            level.buildEnemies(currentLevelWorld, gameTime)
            level.buildCoins(currentLevelWorld, gameTime)
            return true
        }

        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun onPostExecute(result: Boolean?) {
            super.onPostExecute(result)
        }
    }

    fun endThisGame() {
        val time = gameTime/30
        var infinity = mode
        var type_end = 0
        if (player.imageList[0].isRecycled) {
            // PERDER POR MUERTE
            if (mode) {
                if (time > Data.user.survived!!) {
                    Data.user.survived = time
                } else {
                    if (!versus) {
                        infinity = false
                    }
                }
            }
        } else {
            if (player.accumulate > scoreLimits[0] && player.accumulate < scoreLimits[1]) {
                // GANAR PUNTUACION
                type_end = 1
            } else {
                // PERDER PUNTUACION
                type_end = 2
            }
        }
        (contextEngine as GameActivity).endGame(contextEngine, infinity, time, type_end)
    }
}