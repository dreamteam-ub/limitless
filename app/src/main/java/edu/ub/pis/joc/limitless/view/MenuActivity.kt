package edu.ub.pis.joc.limitless.view

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import edu.ub.pis.joc.limitless.R

class MenuActivity : FullScreenActivity() {

    private val TAG = "MenuActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val playButton: ImageButton = findViewById(R.id.play_btn)
        playButton.setOnClickListener {
            val gameModeInt = Intent(this, GameModeActivity::class.java)
            startActivity(gameModeInt)
            playButton.isClickable = false
        }

        val rankButton: ImageButton = findViewById(R.id.rankings_btn)
        rankButton.setOnClickListener {
            val gameModeInt = Intent(this, RankingActivity::class.java)
            startActivity(gameModeInt)
            rankButton.isClickable = false
        }

        val optButton: ImageButton = findViewById(R.id.option_btn)
        optButton.setOnClickListener {
            val gameModeInt = Intent(this, OptionsActivity::class.java)
            startActivity(gameModeInt)
            optButton.isClickable = false
        }

        val infoButton: ImageButton = findViewById(R.id.info_btn)
        infoButton.setOnClickListener {
            val gameModeInt = Intent(this, InfoActivity::class.java)
            startActivity(gameModeInt)
            infoButton.isClickable = false
        }

    }
}
