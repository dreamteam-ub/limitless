package edu.ub.pis.joc.limitless

import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast

class MenuActivity : ActivityNoTopBar() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val playButton : ImageButton = findViewById(R.id.play_btn)
        val rankButton : ImageButton = findViewById(R.id.rankings_btn)
        val optButton : ImageButton = findViewById(R.id.option_btn)
        val infoButton : ImageButton = findViewById(R.id.info_btn)

        playButton.setOnClickListener {
            Toast.makeText(this,"PLAY",Toast.LENGTH_SHORT).show()
        }

        rankButton.setOnClickListener {
            Toast.makeText(this,"RANKINGS",Toast.LENGTH_SHORT).show()
        }

        optButton.setOnClickListener {
            Toast.makeText(this,"OPTIONS",Toast.LENGTH_SHORT).show()
        }

        infoButton.setOnClickListener {
            Toast.makeText(this,"INFO",Toast.LENGTH_SHORT).show()
        }

    }
}
