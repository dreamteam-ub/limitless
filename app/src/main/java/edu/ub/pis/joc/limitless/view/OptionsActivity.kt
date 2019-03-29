package edu.ub.pis.joc.limitless.view

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import edu.ub.pis.joc.limitless.R

class OptionsActivity : FullScreenActivity() {

    private val TAG = "OptionsActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)

        val optionsBackArrow : ImageButton = findViewById(R.id.ranking_back_button)
        optionsBackArrow.setOnClickListener{
            finish()
        }

        val logoutButton : ImageButton = findViewById(R.id.logout_button)
        logoutButton.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra(LOGOUT, "logout")
            startActivity(intent)
        }
    }
}