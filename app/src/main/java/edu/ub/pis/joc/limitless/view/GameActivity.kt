package edu.ub.pis.joc.limitless.view

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import edu.ub.pis.joc.limitless.engine.GameEngine

class GameActivity : FullScreenActivity() {

    private val TAG = "GameActivity"


    lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


        val setMode: Intent = intent
        val nivell = setMode.extras!!.getInt("nivell")

        val surface = GameView(this,nivell)
        setContentView(surface)
    }


    override fun onStop() {
        super.onStop()
    }

    // DESACTIVAMOS EL BACK DENTRO DEL JUEGO
    override fun onBackPressed() {
        super.onBackPressed() // TEMPORAL
    }


}
