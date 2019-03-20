package edu.ub.pis.joc.limitless

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton

class GameDeadActivity : FullScreenActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_dead)

        val retryButton: ImageButton = findViewById(R.id.retryButton_normal)
        retryButton.setOnClickListener {
           val intent = Intent(this,GameActivity::class.java)
            intent.putExtra("mode","My Map")
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        val worldsButton: ImageButton = findViewById(R.id.dead_worldsButton)
        worldsButton.setOnClickListener {
            val intent = Intent(this,WorldSelectorActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        val menuButton: ImageButton = findViewById(R.id.dead_menuButton)
        menuButton.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
    }

    // DESACTIVAMOS EL BACK DENTRO DEL JUEGO
    override fun onBackPressed() {
    }
}
