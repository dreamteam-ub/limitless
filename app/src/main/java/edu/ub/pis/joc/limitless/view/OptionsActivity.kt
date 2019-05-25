package edu.ub.pis.joc.limitless.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.User
import edu.ub.pis.joc.limitless.model.VIBRATION
import edu.ub.pis.joc.limitless.presenter.OptionsPresenter
import kotlinx.android.synthetic.main.activity_options.*

class OptionsActivity : FullScreenActivity(), OptionsPresenter.View {

    private val TAG = "OptionsActivity"

    private lateinit var presenter : OptionsPresenter

    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var mAuth: FirebaseAuth
    private lateinit var db : FirebaseFirestore

    private lateinit var userListener: ListenerRegistration

    private lateinit var userName : TextView

    private lateinit var vibrateButton: ImageButton
    private lateinit var musicSeekBar: SeekBar

    private lateinit var optionsBackArrow: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)

        presenter = OptionsPresenter(this)

        mGoogleSignInClient = GoogleSignIn.getClient(this, GoogleSignInOptions.DEFAULT_SIGN_IN)
        mAuth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        vibrateButton = findViewById(R.id.vibrationButton)
        musicSeekBar = findViewById(R.id.music_seekbar)

        if (Data.user.vibration == null) {
            Data.user.vibration = true
            db.collection(USERS).document(mAuth.currentUser!!.uid).update(VIBRATION, Data.user.vibration)
        }

        if (Data.user.vibration!!) {
            vibrateButton.setImageResource(R.drawable.active_vibration)
        } else {
            vibrateButton.setImageResource(R.drawable.no_vibration)
        }

        musicSeekBar.progress = if (Data.user.music != null) Data.user.music!! else 100

        optionsBackArrow = findViewById(R.id.ranking_back_button)
        optionsBackArrow.setOnClickListener {
            finish()
            optionsBackArrow.isClickable = false
        }

        userName = findViewById(R.id.userNameTv)

        userListener = db.collection(USERS).document(mAuth.currentUser!!.uid).addSnapshotListener { docSnapshot, exception ->
            if (exception != null) {
                Log.w(TAG, "Listen failed.", exception)
            }
            if (docSnapshot != null && docSnapshot.exists()) {
                presenter.updateUser(docSnapshot.toObject(User::class.java)!!)
            }
        }

        val logoutButton: ImageButton = findViewById(R.id.logout_button)
        logoutButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

            // LOGOUT
            mAuth.signOut()
            mGoogleSignInClient.signOut()
            startActivity(intent)
            logoutButton.isClickable = false
        }

        vibrateButton.setOnClickListener {
            presenter.updateVibrate(Data.user.vibration!!)
        }

        musicSeekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                presenter.updateMusic(musicSeekBar.progress)
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        userListener.remove() // IMPORTANTE
    }

    override fun updateUserInfo(user: User) {
        userName.text = user.userName
    }

    override fun updateVibrateButton(value: Boolean) {
        if (value) {
            vibrateButton.setImageResource(R.drawable.active_vibration)
        } else {
            vibrateButton.setImageResource(R.drawable.no_vibration)
        }
    }

    override fun onStart() {
        super.onStart()
        optionsBackArrow.isClickable = true
        logout_button.isClickable = true
    }
}