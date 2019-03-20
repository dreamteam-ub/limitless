package edu.ub.pis.joc.limitless

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton

class MyMapPauseActivity : FullScreenActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_map_pause)

        val resumeBtn : ImageButton = findViewById(R.id.resumeButtonMM)
        resumeBtn.setOnClickListener{
            finish()
        }
        val worlds : ImageButton = findViewById(R.id.worldsButtonPauseMM)
        worlds.setOnClickListener{
            val intent = Intent(this,WorldSelectorActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
        val menu : ImageButton = findViewById(R.id.menuButtonPauseMM)
        menu.setOnClickListener{
            val intent = Intent(this, MenuActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

    }
}
