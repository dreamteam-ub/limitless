package edu.ub.pis.joc.limitless.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import edu.ub.pis.joc.limitless.R

const val LOST_GAME_NOT_DEAD = "lost_game"

class GameDeadActivity : FullScreenActivity() {

    private val TAG = "GameDeadActivity"

    private lateinit var retryButton: ImageButton
    private lateinit var worldsButton: ImageButton
    private lateinit var menuButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_dead)

        val modo = intent.extras!!.getBoolean(MODE_INFINITY)

        if (intent.extras!!.getBoolean(LOST_GAME_NOT_DEAD)) {
            val textLose : ImageView = findViewById(R.id.youDiedImg)
            textLose.setImageDrawable(getDrawable(R.drawable.you_lost))
        }

        retryButton = findViewById(R.id.retryButton_normal)
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

        worldsButton = findViewById(R.id.dead_worldsButton)
        if (modo) {
            worldsButton.visibility = View.GONE

        } else if (!modo) {
            worldsButton.visibility = View.VISIBLE
        }

        worldsButton.setOnClickListener {
            val intent = Intent(this, WorldSelectorActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
            worldsButton.isClickable = false
        }

        menuButton = findViewById(R.id.dead_menuButton)
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

    override fun onStart() {
        super.onStart()
        retryButton.isClickable = true
        worldsButton.isClickable = true
        menuButton.isClickable = true
    }

}
