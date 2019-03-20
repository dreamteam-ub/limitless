package edu.ub.pis.joc.limitless

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton

class InfinityDeadActivity : FullScreenActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infinity_dead)

        val retryButton: ImageButton = findViewById(R.id.retryButton_inf)
        retryButton.setOnClickListener {
            val intent = Intent(this,GameActivity::class.java)
            intent.putExtra("mode","Infinity")
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }



        val menuButton: ImageButton = findViewById(R.id.menuButtonPauseImg_inf)
        menuButton.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
    }

    // DESACTIVAMOS EL BACK DENTRO DEL JUEGO
    override fun onBackPressed() {
    }
}
