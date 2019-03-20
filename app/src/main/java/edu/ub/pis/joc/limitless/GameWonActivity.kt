package edu.ub.pis.joc.limitless

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast

class GameWonActivity : ActivityNoTopBar() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_won)

        val nextLevel : ImageButton = findViewById(R.id.nextlvlButton)
        nextLevel.setOnClickListener{
            val nextlvlIntent = Intent(this, GameActivity::class.java)
            nextlvlIntent.putExtra("mode","My Map")
            startActivity(nextlvlIntent)
        }

        val worlds : ImageButton = findViewById(R.id.worldsButton)
        worlds.setOnClickListener{
            val worldsIntent = Intent(this,WorldSelectorActivity::class.java)
            startActivity(worldsIntent)
        }

        val backToMenu : ImageButton = findViewById(R.id.menuButton)
        backToMenu.setOnClickListener{
            val toMenuInt = Intent (this, MenuActivity::class.java)
            startActivity(toMenuInt)
        }
    }

}
