package edu.ub.pis.joc.limitless.view

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.ImageButton
import android.widget.Toast
import edu.ub.pis.joc.limitless.R
import kotlin.concurrent.thread

class GameActivity : FullScreenActivity() {

    private val TAG = "GameActivity"
    private var surface : GameView? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)



        val setMode: Intent = intent
        val nivell = setMode.extras!!.getInt("nivell")

        surface = GameView(this,nivell)
        setContentView(surface)


    }


    override fun onStop() {
        super.onStop()
    }


    // DESACTIVAMOS EL BACK DENTRO DEL JUEGO
    override fun onBackPressed() {
        //does nothing

    }




}
