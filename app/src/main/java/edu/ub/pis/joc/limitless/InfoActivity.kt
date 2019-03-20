package edu.ub.pis.joc.limitless

import android.os.Bundle
import android.widget.ImageButton

class InfoActivity : FullScreenActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val infoBackArrow : ImageButton = findViewById(R.id.info_back_button)
        infoBackArrow.setOnClickListener{
            finish()
        }
    }
}
