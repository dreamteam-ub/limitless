package edu.ub.pis.joc.limitless

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class GameDeadActivity : FullScreenActivity() {

    private val TAG = "GameDeadActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_dead)

        val setMode : Intent = intent
        val modo = setMode.extras!!.getString("mode")

        val retryButton: ImageButton = findViewById(R.id.retryButton_normal)
        retryButton.setOnClickListener {
           val intent = Intent(this,GameActivity::class.java)
            if (modo == "inf"){
                intent.putExtra("mode","Infinity")
            }else if(modo == "mymap"){
                intent.putExtra("mode","My Map")
            }
            startActivity(intent)
        }

        val worldsButton: ImageButton = findViewById(R.id.dead_worldsButton)
        if (modo == "inf"){
            worldsButton.visibility= View.GONE
            worldsButton.isClickable = false

        }else if (modo == "mymap"){
            worldsButton.visibility = View.VISIBLE
            worldsButton.isClickable = true
        }
        worldsButton.setOnClickListener {
            val intent = Intent(this,WorldSelectorActivity::class.java)
            startActivity(intent)
        }

        val menuButton: ImageButton = findViewById(R.id.dead_menuButton)
        menuButton.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }

}
