package edu.ub.pis.joc.limitless

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class InfinitePauseActivity : ActivityNoTopBar() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infinite_pause)

        val resume : ImageButton = findViewById(R.id.resumeButtonIM)
        resume.setOnClickListener{
            finish()
        }

        val menu : ImageButton = findViewById(R.id.menuButtonPauseIM)
        menu.setOnClickListener {
            val backToMenu = Intent(this, MenuActivity::class.java)
            startActivity(backToMenu)
        }
    }
}
