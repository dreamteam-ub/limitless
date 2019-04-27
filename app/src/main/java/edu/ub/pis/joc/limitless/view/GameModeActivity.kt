package edu.ub.pis.joc.limitless.view

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import edu.ub.pis.joc.limitless.R

const val MODE_INFINITY = "infinity"
const val MODE_GAME = "mode"

class GameModeActivity : FullScreenActivity() {
    private val TAG = "GameModeActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_mode)


        val backArrow: ImageButton = findViewById(R.id.blackArrowButton)
        backArrow.setOnClickListener {
            finish()
        }

        val myMap: ImageButton = findViewById(R.id.myMapButton)
        myMap.setOnClickListener {
            val intent = Intent(this, WorldSelectorActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        val infiniteMode: ImageButton = findViewById(R.id.infiniteModeButton)
        infiniteMode.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra(MODE_INFINITY, true)
            intent.putExtra(LEVEL_BY_WORLD, 12) // TMP
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        val textMyMap: TextView = findViewById(R.id.MyMapText)
        textMyMap.text = getString(R.string.text_mymap)

        val textInf: TextView = findViewById(R.id.infiniteText)
        textInf.text = getString(R.string.text_infinite)

    }
}
