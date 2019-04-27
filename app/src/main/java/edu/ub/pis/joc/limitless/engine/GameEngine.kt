package edu.ub.pis.joc.limitless.engine

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.*
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.model.game.*
import edu.ub.pis.joc.limitless.view.*
import edu.ub.pis.joc.limitless.view.gamescreen.InGameBorder
import edu.ub.pis.joc.limitless.view.gamescreen.PauseButton
import java.util.*


class GameEngine(contextEngine: Context, levelWorld: Int) {

    var touched_x = 0
    var touched_y = 0
    var touched: Int = 0

    var gameTime: Long = 0
    val context = contextEngine
    val activityGame = context as GameActivity


    private val currentLevelWorld: Int = levelWorld

    private var inGameBorder: InGameBorder = InGameBorder(
        BitmapFactory.decodeResource(
            contextEngine.resources,
            R.drawable.in_game_border
        )
    )

    var pauseButton: PauseButton =
        PauseButton(BitmapFactory.decodeResource(contextEngine.resources, R.drawable.pause_button))

    var listOfEnemyCharacters =
        ArrayList<Enemy>() //tendremos una lista de enemigos la cual iteraremos donde nos interese
    var listOfCoins = ArrayList<Coin>()

    private var levelGen: LevelGenerator =
        LevelGenerator(contextEngine, listOfEnemyCharacters, listOfCoins)

    var player: PlayerCharacter = levelGen.buildPlayer()

    private var archThread: ArchThread = ArchThread(levelGen, currentLevelWorld, gameTime)

    private var scoreLimtis = levelGen.createLimits(levelWorld)

    fun update() {

        if (!END_GAME){
            activityGame.endGame(levelGen, player, scoreLimtis, context)
        }

        for (i in 0 until listOfEnemyCharacters.size) {
            listOfEnemyCharacters[i].update()
            listOfEnemyCharacters[i].characterHitsPlayer(player)
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

    fun architect() {
        // start the game thread
        if (archThread.state == Thread.State.TERMINATED) {
            archThread = ArchThread(levelGen, currentLevelWorld, gameTime)
        }

        if (!archThread.isAlive) {
            archThread.start()
        }
    }

    class ArchThread(
        private var levelGen: LevelGenerator,
        private var currentLevelWorld: Int,
        private var gameTime: Long
    ) : Thread() {
        init {
            this.name = "ArchitectThread"
        }

        override fun run() {
            levelGen.buildEnemies(currentLevelWorld, gameTime)
            levelGen.buildCoins(currentLevelWorld, gameTime)
        }
    }

}