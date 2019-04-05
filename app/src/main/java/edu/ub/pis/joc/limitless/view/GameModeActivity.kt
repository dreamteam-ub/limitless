package edu.ub.pis.joc.limitless.view

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.presenter.GameModePresenter

class GameModeActivity : FullScreenActivity() {

    private val TAG = "GameModeActivity"
    private val gmPresenter=GameModePresenter()

    var mode: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_mode)


        val backArrow: ImageButton = findViewById(R.id.blackArrowButton)
        backArrow.setOnClickListener {
            finish()
        }

        val myMap: ImageButton = findViewById(R.id.myMapButton)
        myMap.setOnClickListener {
            /*mode="My Map"
            val myMapGameInt = Intent(this, GameActivity::class.java)
            myMapGameInt.putExtra("mode",mode)
            startActivity(myMapGameInt)*/

            val intent = Intent(this, WorldSelectorActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        val infiniteMode: ImageButton = findViewById(R.id.infiniteModeButton)
        infiniteMode.setOnClickListener {
            mode = "Infinity"
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra("mode", mode)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        val textMyMap: TextView = findViewById(R.id.MyMapText)
        textMyMap.text = getString(R.string.text_mymap)

        val textInf: TextView = findViewById(R.id.infiniteText)
        textInf.text = getString(R.string.text_infinite)

    }
}
