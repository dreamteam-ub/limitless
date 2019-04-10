package edu.ub.pis.joc.limitless.view

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.User

const val USER_NAME = "userName"
const val SURVIVED = "survived"

class WelcomeActivity : FullScreenActivity() {

    private val TAG = "WelcomeActivity"

    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var mAuth: FirebaseAuth
    private lateinit var db : FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_welcome)

        mGoogleSignInClient = GoogleSignIn.getClient(this, GoogleSignInOptions.DEFAULT_SIGN_IN)
        mAuth = FirebaseAuth.getInstance()

        db = FirebaseFirestore.getInstance()

        val uid = mAuth.currentUser!!.uid

        val emailNameTv : TextView = findViewById(R.id.usermail_tv)

        emailNameTv.text = mAuth.currentUser!!.email!!.split('@')[0]

        val nameField: EditText = findViewById(R.id.input_name_et)

        val setnameButton: ImageButton = findViewById(R.id.setname_btn)
        setnameButton.setOnClickListener {
            if (nameField.text.isNotBlank()) {
                db.collection(USERS).whereEqualTo(USER_NAME, nameField.text.toString()).get().addOnCompleteListener { task ->
                    if(task.isSuccessful) {
                        if (task.result!!.documents.isEmpty()) {
                            createUser(uid, nameField.text.toString())
                        } else {
                            customToast(getString(R.string.user_name_exist),
                                Toast.LENGTH_SHORT,Gravity.TOP or
                                        Gravity.FILL_HORIZONTAL,0,200).show()
                        }
                    }
                }
            } else {
                customToast(getString(R.string.bad_user_name),
                    Toast.LENGTH_SHORT,Gravity.TOP or
                            Gravity.FILL_HORIZONTAL,0,200).show()
            }
        }
    }

    private fun createUser(uid: String, userName: String) {
        val users = db.collection(USERS)

        val user = User(userName)

        users.document(uid).set(user).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val intent = Intent(this, MenuActivity::class.java)
                customImageToast(
                    R.drawable.world4_select, getString(R.string.user_created),
                    Toast.LENGTH_SHORT, Gravity.TOP or
                            Gravity.FILL_HORIZONTAL,0,200).show()
                Data.getInstance().user = user
                startActivity(intent)
                finish()
            } else {
                customToast(getString(R.string.fail_create_user),
                    Toast.LENGTH_SHORT, Gravity.TOP or
                            Gravity.FILL_HORIZONTAL,0,200).show()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, LoginActivity::class.java)
        // LOGOUT
        mAuth.signOut()
        mGoogleSignInClient.signOut()
        startActivity(intent)
        finish()
    }
}
