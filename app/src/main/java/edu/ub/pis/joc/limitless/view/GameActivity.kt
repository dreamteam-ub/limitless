package edu.ub.pis.joc.limitless.view

import android.app.Dialog
import android.os.Bundle

class GameActivity : FullScreenActivity() {

    private val TAG = "GameActivity"

    lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val surface = GameView(this)

        setContentView(surface)
    }

    override fun onStop() {
        super.onStop()
        if (dialog.isShowing) {
            dialog.dismiss()
        }
    }

    // DESACTIVAMOS EL BACK DENTRO DEL JUEGO
    override fun onBackPressed() {
        System.exit(0) // TEMPORAL
    }
}
