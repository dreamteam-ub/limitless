package edu.ub.pis.joc.limitless.view

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import edu.ub.pis.joc.limitless.R

class SecondPlayerVsActivity : FullScreenActivity() {

    private lateinit var start_player2_btn : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_player_vs)

        val infinity = intent.extras!!.getBoolean(MODE_INFINITY)
        val versus = intent.extras!!.getBoolean(MODE_INFINITY_VERSUS)
        val round = intent.extras!!.getInt(MODE_INFINITY_VERSUS_COUNT)

        val textLose : TextView = findViewById(R.id.player1_dead)

        if (intent.extras!!.getBoolean(LOST_GAME_NOT_DEAD)) {
            textLose.text = getString(R.string.player1_lost)
        }

        ViewAdjuster.adjustView(textLose)

        ViewAdjuster.adjustView(findViewById(R.id.losePlayer1))

        start_player2_btn = findViewById(R.id.player2_start_button)
        start_player2_btn.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra(MODE_INFINITY, infinity)
            intent.putExtra(MODE_INFINITY_VERSUS, versus)
            intent.putExtra(MODE_INFINITY_VERSUS_COUNT, round)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            finish()
            start_player2_btn.isClickable = false
        }
        ViewAdjuster.adjustView(start_player2_btn)

    }

    override fun onBackPressed() {
        //does nothing
    }

    override fun onStart() {
        super.onStart()
        start_player2_btn.isClickable = true
    }
}
