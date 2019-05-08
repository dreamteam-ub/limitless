package edu.ub.pis.joc.limitless.view

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import edu.ub.pis.joc.limitless.R

const val MODE_INFINITY = "infinity"
const val MODE_INFINITY_VERSUS = "infinity_versus"
const val MODE_INFINITY_VERSUS_COUNT = "infinity_versus_count"

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
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        val infiniteModeVersus: ImageButton = findViewById(R.id.infiniteModeVersusButton)
        infiniteModeVersus.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra(MODE_INFINITY, true)
            intent.putExtra(MODE_INFINITY_VERSUS, true)
            intent.putExtra(MODE_INFINITY_VERSUS_COUNT, 0)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        val textMyMap: TextView = findViewById(R.id.MyMapText)
        textMyMap.text = getString(R.string.text_mymap)

        val textInf: TextView = findViewById(R.id.infiniteText)
        textInf.text = getString(R.string.text_infinite)

    }
}
