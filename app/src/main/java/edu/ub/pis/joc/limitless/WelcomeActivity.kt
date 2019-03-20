package edu.ub.pis.joc.limitless

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton

class WelcomeActivity : ActivityNoTopBar() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_welcome)

        val setnameButton: ImageButton = findViewById(R.id.setname_btn)
        setnameButton.setOnClickListener {
            setName()
        }
    }

    private fun setName() {
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
    }
}
