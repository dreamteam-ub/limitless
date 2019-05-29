package edu.ub.pis.joc.limitless.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import edu.ub.pis.joc.limitless.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.SplashTheme)
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
