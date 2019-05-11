package edu.ub.pis.joc.limitless.view

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.model.Data

class VersusActivityEnd : FullScreenActivity() {

    private lateinit var title : TextView
    private lateinit var first_pos : TextView
    private lateinit var second_pos : TextView
    private lateinit var first_punt : TextView
    private lateinit var second_punt : TextView
    private lateinit var retry_p2m: ImageView
    private lateinit var menu_p2m: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_versus_end)

        var puntuacio1 : Long = Data.versus_survived[0]
        var puntuacio2: Long = Data.versus_survived[1]


        title = findViewById(R.id.winners)
        first_pos = findViewById(R.id.first_pos)
        second_pos = findViewById(R.id.second_pos)
        first_punt = findViewById(R.id.first_punt)
        second_punt = findViewById(R.id.second_punt)
        retry_p2m = findViewById(R.id.retryButton_2PM)
        menu_p2m = findViewById(R.id.menuButton_2PM)


        if(puntuacio1 < puntuacio2){
            title.text = "P2 WINS"

            first_pos.text = "P2."
            second_pos.text = "P1."
            first_punt.text = puntuacio2.toString()
            second_punt.text = puntuacio1.toString()

        }else {

            first_punt.text = puntuacio1.toString()
            second_punt.text = puntuacio2.toString()
        }

        menu_p2m.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
            menu_p2m.isClickable = false
        }

        retry_p2m.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra(MODE_INFINITY, true)
            intent.putExtra(MODE_INFINITY_VERSUS, true)
            intent.putExtra(MODE_INFINITY_VERSUS_COUNT, 0)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            retry_p2m.isClickable = false
        }


    }
}
