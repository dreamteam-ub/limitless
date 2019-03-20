package edu.ub.pis.joc.limitless

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton

class InfinityDeadActivity : ActivityNoTopBar() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infinity_dead)

        val retryButton: ImageButton = findViewById(R.id.retryButton_inf)
        retryButton.setOnClickListener {
            val retryIntent = Intent(this,GameActivity::class.java)
            retryIntent.putExtra("mode","Infinity")
            startActivity(retryIntent)
        }



        val menuButton: ImageButton = findViewById(R.id.menuButtonPauseImg_inf)
        menuButton.setOnClickListener {
            val menuIntent = Intent(this, MenuActivity::class.java)
            startActivity(menuIntent)
        }
    }
}
