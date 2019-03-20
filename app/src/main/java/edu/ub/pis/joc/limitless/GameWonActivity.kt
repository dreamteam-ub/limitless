package edu.ub.pis.joc.limitless

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton

class GameWonActivity : FullScreenActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_won)

        val nextLevel : ImageButton = findViewById(R.id.nextlvlButton)
        nextLevel.setOnClickListener{
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra("mode","My Map")
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        val worlds : ImageButton = findViewById(R.id.worldsButton)
        worlds.setOnClickListener{
            val intent = Intent(this,WorldSelectorActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        val backToMenu : ImageButton = findViewById(R.id.menuButton)
        backToMenu.setOnClickListener{
            val intent = Intent (this, MenuActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
    }

    // DESACTIVAMOS EL BACK DENTRO DEL JUEGO
    override fun onBackPressed() {
    }

}
