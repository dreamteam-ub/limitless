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

    private lateinit var backArrow: ImageButton
    private lateinit var myMap: ImageButton
    private lateinit var infiniteMode: ImageButton
    private lateinit var infiniteModeVersus: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_mode)


        backArrow = findViewById(R.id.blackArrowButton)
        backArrow.setOnClickListener {
            finish()
            backArrow.isClickable = false
        }

        myMap = findViewById(R.id.myMapButton)
        myMap.setOnClickListener {
            val intent = Intent(this, WorldSelectorActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            myMap.isClickable = false
        }

        infiniteMode = findViewById(R.id.infiniteModeButton)
        infiniteMode.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra(MODE_INFINITY, true)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
            infiniteMode.isClickable = false
        }

        infiniteModeVersus = findViewById(R.id.infiniteModeVersusButton)
        infiniteModeVersus.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra(MODE_INFINITY, true)
            intent.putExtra(MODE_INFINITY_VERSUS, true)
            intent.putExtra(MODE_INFINITY_VERSUS_COUNT, 0)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
            infiniteModeVersus.isClickable = false
        }

        val textMyMap: TextView = findViewById(R.id.MyMapText)
        textMyMap.text = getString(R.string.text_mymap)

        val textInf: TextView = findViewById(R.id.infiniteText)
        textInf.text = getString(R.string.text_infinite)
    }

    override fun onStart() {
        super.onStart()
        backArrow.isClickable = true
        myMap.isClickable = true
        infiniteMode.isClickable = true
        infiniteModeVersus.isClickable = true
    }
}
