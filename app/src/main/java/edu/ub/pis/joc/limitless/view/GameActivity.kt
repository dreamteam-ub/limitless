package edu.ub.pis.joc.limitless.view

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageButton
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.engine.Level
import edu.ub.pis.joc.limitless.model.game.PlayerCharacter

var end_game = false

class GameActivity : FullScreenActivity() {

    private val TAG = "GameActivity"

    private var surface: GameView? = null

    private var exit: Boolean = false

    lateinit var dialog: Dialog

    var mode: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        end_game = false

        mode = intent.extras!!.getBoolean(MODE_INFINITY)
        dialog = Dialog(this)

        surface = GameView(this, dialog, mode)
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
                resumeDiag.isClickable = false
        }

        dialog.setOnDismissListener { resumeDiag.isClickable = true }

        worldsDiag.setOnClickListener {
            exit = true
            surface!!.surfaceDestroyed(surface!!.holder)
            dialog.dismiss()

            val intent = Intent().setClass(this, WorldSelectorActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
            worldsDiag.isClickable = false
        }

        menuDiag.setOnClickListener {
            exit = true
            surface!!.surfaceDestroyed(surface!!.holder)
            dialog.dismiss()

            val intent = Intent().setClass(this, MenuActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
            menuDiag.isClickable = false
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

    override fun onStop() {
        super.onStop()

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