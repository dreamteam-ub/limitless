package edu.ub.pis.joc.limitless

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast

class MyMapPauseActivity : ActivityNoTopBar() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_map_pause)

        val resumeBtn : ImageButton = findViewById(R.id.resumeButtonMM)
        resumeBtn.setOnClickListener{
            finish()
        }
        val worlds : ImageButton = findViewById(R.id.worldsButtonPauseMM)
        worlds.setOnClickListener{
            //TO DO
            Toast.makeText(this,"Worlds", Toast.LENGTH_SHORT).show()
        }
        val menu : ImageButton = findViewById(R.id.menuButtonPauseMM)
        menu.setOnClickListener{
            val backToMenu = Intent(this, MenuActivity::class.java)
            startActivity(backToMenu)
        }

    }
}
