package edu.ub.pis.joc.limitless

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

class GameActivity : FullScreenActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        val setMode : Intent = intent
        val mode = setMode.extras!!.getString("mode")

        val winButton: Button = findViewById(R.id.winButton)

        if (mode =="Infinity"){
            winButton.visibility= View.GONE
            winButton.isClickable=false

        }else if (mode == "My Map"){
            winButton.visibility= View.VISIBLE
            winButton.isClickable=true
        }

        winButton.setOnClickListener {
            val winIntent = Intent(this, GameWonActivity::class.java)
            startActivity(winIntent)
        }

        //LOSE BUTTON
        val loseButton : Button = findViewById(R.id.loseButton)
        loseButton.setOnClickListener {
            if(mode=="Infinity"){
                val DeadIntent = Intent(this,GameDeadActivity::class.java)
                DeadIntent.putExtra("mode","inf")
                startActivity(DeadIntent)


            }else if(mode=="My Map"){
                val DeadIntent = Intent(this,GameDeadActivity::class.java)
                DeadIntent.putExtra("mode","mymap")
                startActivity(DeadIntent)
            }
        }


        //PAUSE BUTTOM
        val pauseButton :  Button = findViewById(R.id.pauseButton)
        pauseButton.setOnClickListener {

            if (mode == "My Map"){
                val pauseIntent = Intent(this,MyMapPauseActivity::class.java)
                pauseIntent.putExtra("mode","mymap")
                startActivity(pauseIntent)

            }else if (mode == "Infinity"){
                val pauseIntent = Intent(this,MyMapPauseActivity::class.java)
                pauseIntent.putExtra("mode","inf")
                startActivity(pauseIntent)
            }

        }
    }

    // DESACTIVAMOS EL BACK DENTRO DEL JUEGO
    override fun onBackPressed() {
    }
}
