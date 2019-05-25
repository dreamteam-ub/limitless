package edu.ub.pis.joc.limitless.view

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.engine.FONT_LIMITS
import edu.ub.pis.joc.limitless.model.Data

const val LOST_GAME_NOT_DEAD = "lost_game"
const val SCORE = "score"
const val TIME = "time"

class GameDeadActivity : FullScreenActivity() {

    private val TAG = "GameDeadActivity"

    private lateinit var retryButton: ImageButton
    private lateinit var worldsButton: ImageButton
    private lateinit var menuButton: ImageButton
    private lateinit var final_score: TextView
    private lateinit var time_text: TextView
    private lateinit var time: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_dead)

        val modo = intent.extras!!.getBoolean(MODE_INFINITY)
        val score = intent.extras!!.getInt(SCORE)

        val typeface = Typeface.createFromAsset(assets, FONT_LIMITS)

        if (intent.extras!!.getBoolean(LOST_GAME_NOT_DEAD)) {
            val textLose: ImageView = findViewById(R.id.youDiedImg)
            textLose.setImageDrawable(getDrawable(R.drawable.you_lost))
        }

        retryButton = findViewById(R.id.retryButton_normal)
        retryButton.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            if (modo) {
                intent.putExtra(MODE_INFINITY, true)
            } else {
                intent.putExtra(MODE_INFINITY, false)
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
            retryButton.isClickable = false
        }
        ViewAdjuster.adjustView(retryButton)

        worldsButton = findViewById(R.id.dead_worldsButton)
        if (modo) {
            worldsButton.visibility = View.GONE

        } else if (!modo) {
            worldsButton.visibility = View.VISIBLE
        }

        worldsButton.setOnClickListener {
            val intent = Intent(this, WorldSelectorActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
            worldsButton.isClickable = false
        }
        ViewAdjuster.adjustView(worldsButton)

        menuButton = findViewById(R.id.dead_menuButton)
        menuButton.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
            menuButton.isClickable = false
        }
        ViewAdjuster.adjustView(menuButton)

        final_score = findViewById(R.id.score_puntuation)
        final_score.typeface = typeface
        final_score.text = score.toString()

        ViewAdjuster.adjustView(findViewById(R.id.score_text))
        ViewAdjuster.adjustView(final_score)

        time_text = findViewById(R.id.time_text)
        time_text.typeface = typeface

        ViewAdjuster.adjustView(time_text)

        time = findViewById(R.id.time)
        if (modo) {
            time_text.text = Data.numberToMMSS(Data.versus_survived[0])
        } else {
            time_text.visibility = View.GONE
            time.visibility = View.GONE
        }
        ViewAdjuster.adjustView(time)

        ViewAdjuster.adjustView(findViewById(R.id.youDiedImg))
        ViewAdjuster.adjustView(findViewById(R.id.dead_heart))

    }

    // DESACTIVAMOS EL BACK DENTRO DEL JUEGO
    override fun onBackPressed() {
    }

    override fun onStart() {
        super.onStart()
        retryButton.isClickable = true
        worldsButton.isClickable = true
        menuButton.isClickable = true
    }

}
