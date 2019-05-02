package edu.ub.pis.joc.limitless.view

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageButton
import edu.ub.pis.joc.limitless.R
import android.content.BroadcastReceiver
import android.content.IntentFilter
import android.util.Log

const val END_LEVEL = "end_level"
const val RECYCLED = "recycled"
const val SCORES = "scores"
const val PLAYER_ACC_SCORE = "player_score"

class GameActivity : FullScreenActivity() {

    private val TAG = "GameActivity"

    private var surface: GameView? = null

    private var exit: Boolean = false

    lateinit var dialog: Dialog

    var end_game = false

    var mode : Boolean ?= null

    private val endLevelNotification = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            end_game = true
            val isDead = intent.extras!!.getBoolean(RECYCLED)
            val playerScore = intent.extras!!.getInt(PLAYER_ACC_SCORE)
            val scoreLimits = intent.extras!!.getIntegerArrayList(SCORES)

            Log.d(TAG, "Alive: ${!isDead}")
            Log.d(TAG, "Player Score: $playerScore")
            Log.d(TAG, "ScoreLimits 0: ${scoreLimits!![0]}")
            Log.d(TAG, "ScoreLimits 1: ${scoreLimits[1]}")
            Log.d(TAG, "THREAD ${Thread.currentThread().name}")

            var intent : Intent

            if (isDead) {
                //ACTIVITY DE PERDER POR MUERTE
                intent = Intent(context, GameDeadActivity::class.java)
            } else {
                if (playerScore > scoreLimits[0] && playerScore < scoreLimits[1]) {
                    //ACTIVITY DE GANAR PUNTUACION
                    intent = Intent(context, GameWonActivity::class.java)
                } else {
                    //PERDER por PUNTUACIÓN
                    intent = Intent(context, GameDeadActivity::class.java)
                }
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.putExtra(MODE_INFINITY, mode)
            startActivity(intent)
            finish()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        LocalBroadcastManager.getInstance(this).registerReceiver(endLevelNotification, IntentFilter(END_LEVEL))

        mode= intent.extras!!.getBoolean(MODE_INFINITY)
        end_game = false
        dialog = Dialog(this)

        surface = GameView(this, dialog, mode!!)
        setContentView(surface)

        val layoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val vista = layoutInflater.inflate(R.layout.game_pause_dialog, null)
        dialog.setContentView(vista)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCanceledOnTouchOutside(false)

        val resumeDiag: ImageButton = vista.findViewById(R.id.resumeButtonDiag)
        val worldsDiag: ImageButton = vista.findViewById(R.id.worldsButtonPauseDiag)
        val menuDiag: ImageButton = vista.findViewById(R.id.menuButtonPauseDiag)

        if (mode!!) {
            worldsDiag.visibility = View.GONE
            worldsDiag.isClickable = false
        }

        resumeDiag.setOnClickListener {
            surface!!.resumeThread()
            dialog.dismiss()
        }

        worldsDiag.setOnClickListener {
            exit = true
            surface!!.surfaceDestroyed(surface!!.holder)
            dialog.dismiss()

            val intent = Intent().setClass(this, WorldSelectorActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }

        menuDiag.setOnClickListener {
            exit = true
            surface!!.surfaceDestroyed(surface!!.holder)
            dialog.dismiss()

            val intent = Intent().setClass(this, MenuActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }

        dialog.setOnCancelListener { resumeDiag.performClick() }
        dialog.setOnShowListener { surface!!.pauseThread() }
    }

    // DESACTIVAMOS EL BACK DENTRO DEL JUEGO
    override fun onBackPressed() {
        //does nothing
    }

    override fun onPause() {
        super.onPause()
        if (!end_game) {
            if (surface != null) {
                if (!dialog.isShowing and !exit) {
                    dialog.show()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        if (dialog.isShowing) {
            dialog.dismiss()
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        if (!end_game) {
            if (!hasFocus) {
                if (!dialog.isShowing and !exit) {
                    dialog.show()
                }
            }
        }
        super.onWindowFocusChanged(hasFocus)
    }
}