package edu.ub.pis.joc.limitless.view

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import edu.ub.pis.joc.limitless.R

const val USER_NAME = "uname"
const val USER_REAL_NAME = "urealname"
const val USER_MAIL = "umail"

class WelcomeActivity : FullScreenActivity() {

    private val TAG = "WelcomeActivity"

    private lateinit var db : FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_welcome)

        db = FirebaseFirestore.getInstance()

        val uid = intent.extras!!.getString(NEW_USER_UID)
        val name = intent.extras!!.getString(NEW_USER_NAME)
        val email = intent.extras!!.getString(NEW_USER_MAIL)

        val realNameTv : TextView = findViewById(R.id.usermail_tv)

        realNameTv.text = name!!.split('@')[0]

        val nameField: EditText = findViewById(R.id.input_name_et)

        val setnameButton: ImageButton = findViewById(R.id.setname_btn)
        setnameButton.setOnClickListener {
            if (nameField.text.isNotBlank()) {
                db.collection(USERS).whereEqualTo(USER_NAME, nameField.text.toString()).get().addOnCompleteListener { task ->
                    if(task.isSuccessful) {
                        if (task.result!!.documents.isEmpty()) {
                            createUser(uid, name, email, nameField.text.toString())
                        } else {
                            customToast(getString(R.string.user_name_exist),
                                Toast.LENGTH_SHORT, Gravity.BOTTOM).show()
                        }
                    }
                }
            } else {
                customToast(getString(R.string.bad_user_name),
                    Toast.LENGTH_SHORT, Gravity.BOTTOM).show()
            }
        }
    }

    private fun createUser(uid: String?, realName: String?, email: String?, userName: String?) {
        val users = db.collection(USERS)

        val user : HashMap<String, String?> = HashMap()
        user[USER_NAME] = userName
        user[USER_MAIL] = email
        user[USER_REAL_NAME] = realName

        users.document(uid!!).set(user).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val intent = Intent(this, MenuActivity::class.java)
                customImageToast(
                    R.drawable.world4_select, getString(R.string.user_created),
                    Toast.LENGTH_SHORT, Gravity.BOTTOM or Gravity.FILL_HORIZONTAL).show()
                startActivity(intent)
            } else {
                customToast(getString(R.string.fail_create_user),
                    Toast.LENGTH_SHORT, Gravity.BOTTOM or Gravity.FILL_HORIZONTAL).show()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, LoginActivity::class.java)
        intent.putExtra(LOGOUT, true)
        startActivity(intent)
    }
}
