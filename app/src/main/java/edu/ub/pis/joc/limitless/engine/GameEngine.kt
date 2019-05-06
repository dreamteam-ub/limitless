package edu.ub.pis.joc.limitless.engine


import android.content.Context
import android.content.Intent
import android.graphics.*
import android.os.AsyncTask
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.SURVIVED
import edu.ub.pis.joc.limitless.model.game.*
import edu.ub.pis.joc.limitless.view.*
import edu.ub.pis.joc.limitless.view.gamescreen.InGameBorder
import edu.ub.pis.joc.limitless.view.gamescreen.PauseButton
import java.util.*

class GameEngine(private var contextEngine: Context, var mode: Boolean) {

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

    private lateinit var mAuth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    init {
        if (mode) {
            currentLevelWorld = NIVEL_INFINITO
            level = LevelInfinite(contextEngine, listOfEnemyCharacters, listOfCoins)
        } else {
            currentLevelWorld = Data.getCurrenLevel()
            level = LevelPractice(contextEngine, listOfEnemyCharacters, listOfCoins)
        }
        mAuth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

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

    private var scoreLimits = level.createLimits(currentLevelWorld)

    fun update() {
        if (!end_game) {
            endGame(level, player, scoreLimits, contextEngine)
        }

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
        while(coinIterator<listOfCoins.size){
            val taken : Boolean = player.takesCoin(listOfCoins[coinIterator])
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
        if (!end_game) {
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
            // ...
        }

        override fun onPostExecute(result: Boolean?) {
            super.onPostExecute(result)
            // ...
        }
    }

    fun endGame(levelGen: Level, player: PlayerCharacter, scoreLimits: ArrayList<Int>, context: Context) {
        //Log.d("THREAD NAME", Thread.currentThread().name)
        if (levelGen.endOfLevel) {
            val activity = (context as FullScreenActivity)
            if (player.accumulate > scoreLimits[0] && player.accumulate < scoreLimits[1]) {
                end_game = true
                levelGen.endOfLevel = false
                //ACTIVITY DE GANAR PUNTUACION
                val intent = Intent(context, GameWonActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                activity.startActivity(intent)
                activity.finish()
            } else {
                end_game = true
                if (mode && gameTime/30 >= Data.user.survived!!){
                    Data.user.survived = gameTime/(30)
                    db.collection(USERS).document(mAuth.currentUser!!.uid).update(SURVIVED, Data.user.survived!!)

                }
                //PERDER por PUNTUACIÓN
                levelGen.endOfLevel = false
                val intent = Intent(context, GameDeadActivity::class.java)
                intent.putExtra(MODE_INFINITY, mode)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                activity.startActivity(intent)
                activity.finish()
            }
        } else if (player.imageList[0].isRecycled) {
            val activity = (context as FullScreenActivity)
            //ACTIVITY DE PERDER POR MUERTE
            end_game = true
            if (mode && gameTime/30 >= Data.user.survived!! ){
                Data.user.survived = gameTime/(30)
                Log.d("gametime", (gameTime/(30)).toString())
                db.collection(USERS).document(mAuth.currentUser!!.uid).update(SURVIVED, Data.user.survived!!)
            }
            levelGen.endOfLevel = true
            val intent = Intent(context, GameDeadActivity::class.java)
            intent.putExtra(MODE_INFINITY, mode)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            activity.startActivity(intent)
            activity.finish()
        }
    }
}