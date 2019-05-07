package edu.ub.pis.joc.limitless.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import edu.ub.pis.joc.limitless.R

class GameDeadActivity : FullScreenActivity() {

    private val TAG = "GameDeadActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_dead)

        val modo = intent.extras!!.getBoolean(MODE_INFINITY)
        val retryButton: ImageButton = findViewById(R.id.retryButton_normal)
        retryButton.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            if (modo) {
                intent.putExtra(MODE_INFINITY, true)
            } else {
                intent.putExtra(MODE_INFINITY, false)
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
            retryButton.isClickable = false
        }

        val worldsButton: ImageButton = findViewById(R.id.dead_worldsButton)
        if (modo) {
            worldsButton.visibility = View.GONE
            worldsButton.isClickable = false

        } else if (!modo) {
            worldsButton.visibility = View.VISIBLE
            worldsButton.isClickable = true
        }

        worldsButton.setOnClickListener {
            val intent = Intent(this, WorldSelectorActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
            worldsButton.isClickable = false
        }

        val menuButton: ImageButton = findViewById(R.id.dead_menuButton)
        menuButton.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
            menuButton.isClickable = false
        }
    }

    // DESACTIVAMOS EL BACK DENTRO DEL JUEGO
    override fun onBackPressed() {

    }

}
