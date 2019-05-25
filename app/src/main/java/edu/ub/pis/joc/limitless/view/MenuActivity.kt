package edu.ub.pis.joc.limitless.view

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.view.ViewAdjuster.adjustView

class MenuActivity : FullScreenActivity() {

    private val TAG = "MenuActivity"

    private lateinit var playButton: ImageButton
    private lateinit var rankButton: ImageButton
    private lateinit var optButton: ImageButton
    private lateinit var infoButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val menuLogo: ImageView = findViewById(R.id.menu_game_logo)
        var clickcount = 0
        menuLogo.setOnClickListener {
            clickcount++
            if (clickcount == 4) {
                customImageToast(
                    R.drawable.calvo, getString(R.string.easter_egg_menu),
                    Toast.LENGTH_LONG, Gravity.TOP or Gravity.FILL_HORIZONTAL, 0, 100
                ).show()
                clickcount = 0
            }
        }

        adjustView(findViewById(R.id.menu_game_logo))

        playButton = findViewById(R.id.play_btn)
        playButton.setOnClickListener {
            val gameModeInt = Intent(this, GameModeActivity::class.java)
            startActivity(gameModeInt)
            playButton.isClickable = false
        }

        adjustView(playButton)

        rankButton = findViewById(R.id.rankings_btn)
        rankButton.setOnClickListener {
            val gameModeInt = Intent(this, RankingActivity::class.java)
            startActivity(gameModeInt)
            rankButton.isClickable = false
        }

        adjustView(rankButton)

        optButton = findViewById(R.id.option_btn)
        optButton.setOnClickListener {
            val gameModeInt = Intent(this, OptionsActivity::class.java)
            startActivity(gameModeInt)
            optButton.isClickable = false
        }

        adjustView(optButton)

        infoButton = findViewById(R.id.info_btn)
        infoButton.setOnClickListener {
            val gameModeInt = Intent(this, InfoActivity::class.java)
            startActivity(gameModeInt)
            infoButton.isClickable = false
        }

        adjustView(infoButton)

    }

    override fun onStart() {
        super.onStart()
        playButton.isClickable = true
        rankButton.isClickable = true
        optButton.isClickable = true
        infoButton.isClickable = true
    }
}
