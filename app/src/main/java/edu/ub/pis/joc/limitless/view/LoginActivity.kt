package edu.ub.pis.joc.limitless.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import edu.ub.pis.joc.limitless.R

const val USERS = "users"

const val NEW_USER_UID = "nuid"
const val NEW_USER_MAIL = "nmail"
const val NEW_USER_NAME = "nname"

class LoginActivity : FullScreenActivity() {

    private val TAG = "LoginActivity"
    private val RC_SIGN_IN : Int = 1000

    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var mAuth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.web_client_id))
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
        mAuth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        val signInButton: SignInButton = findViewById(R.id.signin_btn)
        val textView = signInButton.getChildAt(0) as TextView
        textView.text = getString(R.string.cuenta_google_btn)

        signInButton.setOnClickListener {
            signIn()
        }
    }

    override fun onStart() {
        super.onStart()
        setAuth(mAuth.currentUser)
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                firebaseAuthWithGoogle(account)
            } catch (e: ApiException) {
                // Google Sign In failed
                Log.w(TAG, "Google sign in failed", e)
                customToast(getString(R.string.fail_google_auth),
                    Toast.LENGTH_SHORT, Gravity.TOP or
                            Gravity.FILL_HORIZONTAL,0,200).show()
                setAuth(null)
            }
        }
    }

    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.id!!)
        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")
                    val user = mAuth.currentUser
                    setAuth(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                    customToast(getString(R.string.fail_auth),
                        Toast.LENGTH_SHORT,Gravity.TOP or
                                Gravity.FILL_HORIZONTAL,0,200).show()
                    setAuth(null)
                }
            }
    }

    private fun signIn() {
        val signInIntent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    private fun signOut() {
        // Firebase sign out
        mAuth.signOut()
        // Google sign out
        mGoogleSignInClient.signOut()
    }

    private fun setAuth(user: FirebaseUser?) {
        if (user != null) {
            layoutInflater.inflate(R.layout.activity_login_wait,findViewById(R.id.login_layout), true)
            var intent = Intent(this, MenuActivity::class.java)
            val userDb = db.collection(USERS).document(user.uid)
            userDb.get().addOnSuccessListener { doc ->
                if (doc!!.exists()) {
                    Log.d(TAG, "User document: " + doc.data!!)
                    customImageToast(
                        R.drawable.world4_select, getString(R.string.ok_auth) + "\n" + doc.data!![USER_NAME],
                        Toast.LENGTH_SHORT,Gravity.TOP or
                                Gravity.FILL_HORIZONTAL,0,200).show()
                } else {
                    Log.d(TAG, "No such document")
                    intent = Intent(this, WelcomeActivity::class.java)
                    intent.putExtra(NEW_USER_UID, user.uid)
                    intent.putExtra(NEW_USER_MAIL, user.email)
                    intent.putExtra(NEW_USER_NAME, user.displayName)
                }
            }.continueWith {
                startActivity(intent)
                finish()
            }
        }
    }
}
