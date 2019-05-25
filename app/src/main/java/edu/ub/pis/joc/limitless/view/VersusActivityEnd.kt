package edu.ub.pis.joc.limitless.view

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.engine.FONT_LIMITS
import edu.ub.pis.joc.limitless.model.Data

class VersusActivityEnd : FullScreenActivity() {

    private lateinit var title : TextView
    private lateinit var first_pos : TextView
    private lateinit var second_pos : TextView
    private lateinit var first_time : TextView
    private lateinit var second_time : TextView
    private lateinit var retry_p2m: ImageView
    private lateinit var menu_p2m: ImageView
    private lateinit var score1_punt : TextView
    private lateinit var score2_punt : TextView
    private lateinit var score2_text : TextView
    private lateinit var score1_text : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_versus_end)

        var puntuacio1 : Long = Data.versus_survived[0]
        var puntuacio2: Long = Data.versus_survived[1]

        title = findViewById(R.id.winners)
        ViewAdjuster.adjustView(title)

        first_pos = findViewById(R.id.first_pos)
        ViewAdjuster.adjustView(first_pos)

        second_pos = findViewById(R.id.second_pos)
        ViewAdjuster.adjustView(second_pos)

        first_time = findViewById(R.id.first_punt)
        ViewAdjuster.adjustView(first_time)

        second_time = findViewById(R.id.second_punt)
        ViewAdjuster.adjustView(second_time)

        retry_p2m = findViewById(R.id.retryButton_2PM)
        ViewAdjuster.adjustView(retry_p2m)

        menu_p2m = findViewById(R.id.menuButton_2PM)
        ViewAdjuster.adjustView(menu_p2m)

        score1_punt = findViewById(R.id.score1_puntuation)
        ViewAdjuster.adjustView(score1_punt)

        score2_punt = findViewById(R.id.score2_puntuation)
        ViewAdjuster.adjustView(score2_punt)

        score1_text = findViewById(R.id.score1_text)
        ViewAdjuster.adjustView(score1_text)

        score2_text = findViewById(R.id.score2_text)
        ViewAdjuster.adjustView(score2_text)

        ViewAdjuster.adjustView(findViewById(R.id.ranking_lines_1))
        ViewAdjuster.adjustView(findViewById(R.id.ranking_lines_2))

        score1_punt.text = Data.versus_score[0].toString()
        score2_punt.text = Data.versus_score[1].toString()


        if(puntuacio1 < puntuacio2){
            title.text = getString(R.string.p2_wins)

            first_pos.text = getString(R.string.p2)
            second_pos.text = getString(R.string.p1)
            first_time.text = Data.numberToMMSS(puntuacio2)
            second_time.text = Data.numberToMMSS(puntuacio1)

        }else {

            first_time.text = Data.numberToMMSS(puntuacio1)
            second_time.text = Data.numberToMMSS(puntuacio2)
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

    override fun onStart() {
        super.onStart()
        retry_p2m.isClickable = true
        menu_p2m.isClickable=true
    }
}
