package edu.ub.pis.joc.limitless.engine


import android.content.Context
import android.content.Intent
import android.graphics.*
import android.support.v4.content.LocalBroadcastManager
import android.util.Log
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.game.*
import edu.ub.pis.joc.limitless.view.*
import edu.ub.pis.joc.limitless.view.gamescreen.InGameBorder
import edu.ub.pis.joc.limitless.view.gamescreen.PauseButton
import java.util.*

class GameEngine(private var contextEngine: Context, var mode : Boolean) {

    var touched_x = 0
    var touched_y = 0
    var touched: Int = 0

    var gameTime: Long = 0
    val context = contextEngine

    var listOfEnemyCharacters =
        ArrayList<Enemy>() //tendremos una lista de enemigos la cual iteraremos donde nos interese
    var listOfCoins = ArrayList<Coin>()

    var level: Level? = null
    private var currentLevelWorld: Int? = null


    init{
        if (mode){
            currentLevelWorld = NIVEL_INFINITO
            level = LevelInfinite(contextEngine, listOfEnemyCharacters, listOfCoins)
        }else{
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



    var player: PlayerCharacter = level!!.buildPlayer()

    private var archThread: ArchThread = ArchThread(level!!, currentLevelWorld!!, gameTime)

    private var scoreLimits = level!!.createLimits(currentLevelWorld!!)

    private var lockGame = false

    fun update() {
        for (i in 0 until listOfEnemyCharacters.size) {
            listOfEnemyCharacters[i].update()
            (listOfEnemyCharacters[i].characterHitsPlayer(player))

        }
        if (!player.imageList[0].isRecycled) {
            if (touched == 1) {
                player.update(touched_x, touched_y, false)
            } else if (touched == 2) {
                player.update(touched_x, touched_y, true)
            }
        }

        for (i in 0 until listOfCoins.size) {
            player.takesCoin(listOfCoins[i])

        }

    }

    /**
     * Everything that has to be drawn on Canvas
     */

    fun draw(canvas: Canvas) {
        inGameBorder.draw(canvas)
        pauseButton.draw(canvas)

        if (!player.imageList[0].isRecycled) {
            player.draw(canvas)
        } else {
            level!!.endOfLevel = true
        }

        for (i in 0 until listOfEnemyCharacters.size) {
            listOfEnemyCharacters[i].draw(canvas)

        }
        for (i in 0 until listOfCoins.size) {
            if (listOfCoins[i].imageList[0].isRecycled) {
                listOfCoins.remove(listOfCoins[i])
            } else {
                listOfCoins[i].update()
                listOfCoins[i].draw(canvas)
            }
        }
    }

    fun architect() {
        // start the game thread
        if (archThread.state == Thread.State.TERMINATED) {
            archThread = ArchThread(level!!, currentLevelWorld!!, gameTime)
        }

        if (!archThread.isAlive) {
            archThread.start()
        }
    }

    class ArchThread(
        private var level: Level,
        private var currentLevelWorld: Int,
        private var gameTime: Long
    ) : Thread() {
        init {
            this.name = "ArchitectThread"
        }

        override fun run() {
            level.buildEnemies(currentLevelWorld, gameTime)
            level.buildCoins(currentLevelWorld, gameTime)
        }
    }

    fun endLevel(gameThread: GameThread) {
        if (level!!.endOfLevel) {
            Log.d("LEVEL", "END_LEVEL MSG")
            val intent = Intent(END_LEVEL)
            intent.putExtra(RECYCLED, player.imageList[0].isRecycled)
            intent.putExtra(PLAYER_ACC_SCORE, player.accumulate)
            intent.putExtra(SCORES, scoreLimits)
            LocalBroadcastManager.getInstance(contextEngine).sendBroadcast(intent)
            gameThread.setRunning(false)
        }
    }

}