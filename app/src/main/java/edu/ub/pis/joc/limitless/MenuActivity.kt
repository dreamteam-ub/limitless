package edu.ub.pis.joc.limitless

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast

class MenuActivity : ActivityNoTopBar() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val playButton : ImageButton = findViewById(R.id.play_btn)
        playButton.setOnClickListener {
            val gameModeInt = Intent(this, GameModeActivity::class.java)
            startActivity(gameModeInt)
        }

        val rankButton : ImageButton = findViewById(R.id.rankings_btn)
        rankButton.setOnClickListener {
            Toast.makeText(this,"RANKINGS",Toast.LENGTH_SHORT).show()
        }

        val optButton : ImageButton = findViewById(R.id.option_btn)
        optButton.setOnClickListener {
            Toast.makeText(this,"OPTIONS",Toast.LENGTH_SHORT).show()
        }

        val infoButton : ImageButton = findViewById(R.id.info_btn)
        infoButton.setOnClickListener {
            Toast.makeText(this,"INFO",Toast.LENGTH_SHORT).show()
        }

    }
}
