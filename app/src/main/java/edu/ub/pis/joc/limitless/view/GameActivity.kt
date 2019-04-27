package edu.ub.pis.joc.limitless.view

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageButton
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.engine.LevelGenerator
import edu.ub.pis.joc.limitless.model.game.PlayerCharacter

var END_GAME = false

class GameActivity : FullScreenActivity() {

    private val TAG = "GameActivity"

    private var surface: GameView? = null

    private var exit: Boolean = false

    lateinit var dialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val level: Int = intent.extras!!.getInt(LEVEL_BY_WORLD)
        val mode: Boolean = intent.extras!!.getBoolean(MODE_INFINITY)
        END_GAME = false

        dialog = Dialog(this)

        surface = GameView(this, dialog, level)
        setContentView(surface)

        val layoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val vista = layoutInflater.inflate(R.layout.game_pause_dialog, null)
        dialog.setContentView(vista)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCanceledOnTouchOutside(false)

        val resumeDiag: ImageButton = vista.findViewById(R.id.resumeButtonDiag)
        val worldsDiag: ImageButton = vista.findViewById(R.id.worldsButtonPauseDiag)
        val menuDiag: ImageButton = vista.findViewById(R.id.menuButtonPauseDiag)

        if (mode) {
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
        if (!END_GAME) {
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
        if (!END_GAME) {
            if (!hasFocus) {
                if (!dialog.isShowing and !exit) {
                    dialog.show()
                }
            }
        }
        super.onWindowFocusChanged(hasFocus)
    }

    fun endGame(levelGen: LevelGenerator, player: PlayerCharacter, scoreLimtis: ArrayList<Int>, context: Context) {

        if (levelGen.endOfLevel) {
            if (player.accumulate > scoreLimtis[0] && player.accumulate < scoreLimtis[1]) {
                END_GAME = true
                levelGen.endOfLevel = false
                //ACTIVITY DE GANAR PUNTUACION
                var intent = Intent(context, GameWonActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                context.startActivity(intent)
                finish()
            } else {
                END_GAME = true
                //PERDER por PUNTUACIÓN
                levelGen.endOfLevel = false
                var intent = Intent(context, GameDeadActivity::class.java)
                intent.putExtra(MODE_GAME, LEVEL_BY_WORLD)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                context.startActivity(intent)
                finish()
            }
        } else if (player.imageList[0].isRecycled) {
            //ACTIVITY DE PERDER POR MUERTE
            END_GAME = true
            levelGen.endOfLevel = true
            var intent = Intent(context, GameDeadActivity::class.java)
            intent.putExtra(MODE_GAME, LEVEL_BY_WORLD)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            context.startActivity(intent)
            finish()
        }
    }
}