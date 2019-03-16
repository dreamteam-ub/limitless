package edu.ub.pis.joc.limitless

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class GameActivity : ActivityNoTopBar() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val setMode : Intent = intent
        val mode = setMode.extras.getString("mode")

        val winButton: Button = findViewById<Button>(R.id.winButton)
        if (mode.equals("Infinity")){
            winButton.visibility= View.GONE
            winButton.isClickable=false

        }else if (mode.equals("My Map")){
            winButton.visibility= View.VISIBLE
            winButton.isClickable=true
        }
        winButton.setOnClickListener {
            val winIntent = Intent(this, GameWonActivity::class.java)
            startActivity(winIntent)
        }
        val loseButton : Button = findViewById(R.id.loseButton)
        loseButton.setOnClickListener {
            //TO DO by Aarón
            Toast.makeText(this, "You Lose", Toast.LENGTH_SHORT).show()
        }

        val pauseButton :  Button = findViewById(R.id.pauseButton)
        pauseButton.setOnClickListener {

            if (mode.equals("My Map")){
                val pauseIntent = Intent(this,MyMapPauseActivity::class.java)
                startActivity(pauseIntent)

            }else if (mode.equals("Infinity")){
                val pauseIntent = Intent(this,InfinitePauseActivity::class.java)
                startActivity(pauseIntent)
            }

        }
    }
}
