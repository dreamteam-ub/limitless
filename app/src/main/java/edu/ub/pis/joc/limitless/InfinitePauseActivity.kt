package edu.ub.pis.joc.limitless

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton

class InfinitePauseActivity : FullScreenActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infinite_pause)

        val resume : ImageButton = findViewById(R.id.resumeButtonIM)
        resume.setOnClickListener{
            finish()
        }

        val menu : ImageButton = findViewById(R.id.menuButtonPauseIM)
        menu.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
    }
}
