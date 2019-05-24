package edu.ub.pis.joc.limitless.engine


import android.content.Context
import android.graphics.*
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.game.*
import edu.ub.pis.joc.limitless.view.GameActivity
import edu.ub.pis.joc.limitless.view.IMG_ASSETS
import edu.ub.pis.joc.limitless.view.end_game
import edu.ub.pis.joc.limitless.view.gamescreen.InGameBorder
import edu.ub.pis.joc.limitless.view.gamescreen.PauseButton
import java.io.BufferedInputStream
import java.io.File
import java.util.*

@Suppress("DEPRECATION")
class GameEngine(private var contextEngine: Context, var mode: Boolean, var versus: Boolean) {

    var assets = contextEngine.resources.assets

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
    var vibrator = contextEngine.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    var optionsGameBorder: BitmapFactory.Options = BitmapFactory.Options()
    var optionsPauseButton: BitmapFactory.Options = BitmapFactory.Options()


    init {
        if (mode) {
            currentLevelWorld = NIVEL_INFINITO
            level = LevelInfinite(assets, listOfEnemyCharacters, listOfCoins)
        } else {
            currentLevelWorld = Data.getCurrenLevel()
            level = LevelPractice(assets, listOfEnemyCharacters, listOfCoins, currentLevelWorld)
        }

        Log.d("CURRENT LEVEL", currentLevelWorld.toString())


        optionsGameBorder.inSampleSize = 16
        optionsPauseButton.inSampleSize = 8
    }

    private var inGameBorder: InGameBorder = InGameBorder(
        BitmapFactory.decodeStream(
            BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "in_game_border.png")), null, optionsGameBorder)!!
    )

    var pauseButton: PauseButton =
        PauseButton(
            BitmapFactory.decodeStream(BufferedInputStream(assets.open(IMG_ASSETS + File.separator + "pause_button.png")), null, optionsPauseButton)!!
        )


    var player: PlayerCharacter = level.buildPlayer()

    var scoreLimits = level.createLimits(currentLevelWorld)

    fun update() {
        for (i in 0 until listOfEnemyCharacters.size) {
            if (listOfEnemyCharacters[i].appearTime <= gameTime) {
                listOfEnemyCharacters[i].update()
            }
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
        }else if (player.imageList[0].isRecycled){
            if (Data.user.vibration!!) {
                if (android.os.Build.VERSION.SDK_INT >= 26) {
                    vibrator.vibrate(VibrationEffect.createOneShot(30, VibrationEffect.DEFAULT_AMPLITUDE))
                } else {
                    vibrator.vibrate(30)
                }
            }
        }

        var coinIterator = 0
        while (coinIterator < listOfCoins.size) {
            val taken: Boolean = player.takesCoin(listOfCoins[coinIterator])
            if (taken) {
                if (Data.user.vibration!!) {
                    if (android.os.Build.VERSION.SDK_INT >= 26) {
                        vibrator.vibrate(VibrationEffect.createOneShot(30, VibrationEffect.DEFAULT_AMPLITUDE))
                    } else {
                        vibrator.vibrate(30)
                    }
                }
                listOfCoins.removeAt(coinIterator)
                coinIterator--
            }
            coinIterator++
        }

        for (i in 0 until listOfCoins.size) {
            if (listOfCoins[i].appearTime <= gameTime) {
                listOfCoins[i].update()
            }
        }

        if (mode && level.newStage && level.infiniteMode) {
            if (!(player.accumulate >= scoreLimits[0] && player.accumulate <= scoreLimits[1])) {
                Log.d("playerACC", player.accumulate.toString())
                end_game = true
            }
            scoreLimits = level.createLimits(-1)
            Log.d("scoreLIM1", scoreLimits[0].toString())
            Log.d("scoreLIM2", scoreLimits[1].toString())
            level.newStage = false
        } else if (mode && level.newStage && !level.infiniteMode) {
            if (!(player.accumulate >= scoreLimits[0] && player.accumulate <= scoreLimits[1])) {
                Log.d("playerACC", player.accumulate.toString())
                Log.d("scoreLIM1", scoreLimits[0].toString())
                Log.d("scoreLIM2", scoreLimits[1].toString())
                end_game = true

            } else {
                scoreLimits = level.createLimits(-1)
                level.newStage = false
            }


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

        level.limits.draw(canvas)

        if (!player.imageList[0].isRecycled) {
            player.draw(canvas)
        }

        for (i in 0 until listOfEnemyCharacters.size) {
            if (listOfEnemyCharacters[i].appearTime <= gameTime) {
                listOfEnemyCharacters[i].draw(canvas)
            }
        }
        for (i in 0 until listOfCoins.size) {
            if (listOfCoins[i].imageList[0].isRecycled) {
                listOfCoins.remove(listOfCoins[i])
            } else {
                if (listOfCoins[i].appearTime <= gameTime) {
                    listOfCoins[i].draw(canvas)
                }
            }
        }
    }

    fun endGame() {
        val activity = (contextEngine as GameActivity)
        val time = gameTime / 30
        var updateDb = false
        val dead = player.imageList[0].isRecycled
        val gOverPoints = !(player.accumulate >= scoreLimits[0] && player.accumulate <= scoreLimits[1])
        var score: Int = player.accumulate
        if (dead) {
            if (mode) {
                if (!versus) {
                    if (time > Data.user.survived!!) {
                        Data.user.survived = time
                        updateDb = true
                    }
                }
            }

        } else if (gOverPoints && mode) {
            if (time > Data.user.survived!!) {
                Data.user.survived = time
                updateDb = true
            }
        }
        activity.onEndGame(contextEngine, updateDb, time, dead, gOverPoints,score)

    }
}
