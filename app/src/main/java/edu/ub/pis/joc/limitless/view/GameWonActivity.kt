package edu.ub.pis.joc.limitless.view

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.presenter.GameWonPresenter

class GameWonActivity : FullScreenActivity() {

    private val TAG = "GameWonActivity"
    private val gameWonPresenter = GameWonPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_won)

        val nextLevel: ImageButton = findViewById(R.id.nextlvlButton)
        nextLevel.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra("mode", "My Map")
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }

        val worlds: ImageButton = findViewById(R.id.worldsButton)
        worlds.setOnClickListener {
            val intent = Intent(this, WorldSelectorActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }

        val backToMenu: ImageButton = findViewById(R.id.menuButton)
        backToMenu.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }
    }

    // DESACTIVAMOS EL BACK DENTRO DEL JUEGO
    override fun onBackPressed() {

    }
}
