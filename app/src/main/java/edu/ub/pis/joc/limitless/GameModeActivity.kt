package edu.ub.pis.joc.limitless

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class GameModeActivity : ActivityNoTopBar() {

    var mode : String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_mode)


        val backArrow : ImageButton = findViewById(R.id.blackArrowButton)
        backArrow.setOnClickListener{
            finish()
        }

        val myMap : ImageButton = findViewById(R.id.myMapButton)
        myMap.setOnClickListener{
            mode="My Map"
            val myMapGameInt = Intent(this, GameActivity::class.java)
            myMapGameInt.putExtra("mode",mode)
            startActivity(myMapGameInt)
        }

        val infiniteMode : ImageButton = findViewById(R.id.infiniteModeButton)
        infiniteMode.setOnClickListener{
            mode="Infinity"
            val infiniteGameInt = Intent (this, GameActivity::class.java)
            infiniteGameInt.putExtra("mode", mode)
            startActivity(infiniteGameInt)
        }

        val textMyMap : TextView = findViewById(R.id.MyMapText)
        textMyMap.text = getString(R.string.text_mymap)

    }
}
