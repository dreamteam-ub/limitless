package edu.ub.pis.joc.limitless

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast

class GameDeadActivity : ActivityNoTopBar() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_dead)

        val retryButton: ImageButton = findViewById(R.id.retryButton_normal)
        retryButton.setOnClickListener {
           val retryIntent = Intent(this,GameActivity::class.java)
            retryIntent.putExtra("mode","My Map")
            startActivity(retryIntent)
        }

        val worldsButton: ImageButton = findViewById(R.id.dead_worldsButton)
        worldsButton.setOnClickListener {
            Toast.makeText(this,"WORLDS",Toast.LENGTH_SHORT).show()
        }

        val menuButton: ImageButton = findViewById(R.id.dead_menuButton)
        menuButton.setOnClickListener {
            val menuIntent = Intent(this, MenuActivity::class.java)
            startActivity(menuIntent)
        }
    }
}
