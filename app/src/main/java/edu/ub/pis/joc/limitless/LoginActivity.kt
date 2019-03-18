package edu.ub.pis.joc.limitless

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.google.android.gms.common.SignInButton

class LoginActivity : AppCompatActivity() {

    public val TAG = "LoginActivity"
    private val RC_LOGIN = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        val signInButton: SignInButton = findViewById(R.id.signin_btn)
        signInButton.setOnClickListener {
            signIn()
        }
    }

    override fun onStart() {
        super.onStart()
    }

    private fun signIn() {
        val welcomeInt = Intent(this, WelcomeActivity::class.java)
        startActivity(welcomeInt)
    }
}
