package edu.ub.pis.joc.limitless.view

import android.app.Dialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageButton
import edu.ub.pis.joc.limitless.R
import android.content.IntentFilter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.SURVIVED


const val END_GAME = "endgame"

var end_game = false

class GameActivity : FullScreenActivity() {

    private val TAG = "GameActivity"

    private var surface: GameView? = null

    private var exit: Boolean = false

    lateinit var dialog: Dialog

    var mode: Boolean = false

    private lateinit var mAuth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    val endGameMsg = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val endGameType = intent.extras!!.getInt(END_GAME)
            val modeType = intent.extras!!.getBoolean(MODE_INFINITY)
            if (endGameType == 0) {
                if (modeType) {
                    db.collection(USERS).document(mAuth.currentUser!!.uid).update(SURVIVED, Data.user.survived!!)
                }
                val intent = Intent(context, GameDeadActivity::class.java)
                intent.putExtra(MODE_INFINITY, mode)
                startActivity(intent)
                finish()
            } else if (endGameType == 1) {
                val intent = Intent(context, GameWonActivity::class.java)
                intent.putExtra(MODE_INFINITY, mode)
                startActivity(intent)
                finish()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        LocalBroadcastManager.getInstance(this).registerReceiver(endGameMsg, IntentFilter(END_GAME))

        mAuth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        end_game = false

        mode = intent.extras!!.getBoolean(MODE_INFINITY)
        dialog = Dialog(this)

        surface = GameView(this, dialog, mode)
        setContentView(surface)

        val layoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val vista = layoutInflater.inflate(R.layout.game_pause_dialog, null)
        dialog.setContentView(vista)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCanceledOnTouchOutside(false)

        val resumeDiag: ImageButton = vista.findViewById(R.id.resumeButtonDiag)
        val worldsDiag: ImageButton = vista.findViewById(R.id.worldsButtonPauseDiag)
        val menuDiag: ImageButton = vista.findViewById(R.id.menuButtonPauseDiag)

        if (mode) {
            worldsDiag.visibility = View.GONE
            worldsDiag.isClickable = false
        }

        resumeDiag.setOnClickListener {
            surface!!.resumeThread()
            dialog.dismiss()
                resumeDiag.isClickable = false
        }

        dialog.setOnDismissListener { resumeDiag.isClickable = true }

        worldsDiag.setOnClickListener {
            exit = true
            surface!!.surfaceDestroyed(surface!!.holder)
            dialog.dismiss()

            val intent = Intent().setClass(this, WorldSelectorActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
            worldsDiag.isClickable = false
        }

        menuDiag.setOnClickListener {
            exit = true
            surface!!.surfaceDestroyed(surface!!.holder)
            dialog.dismiss()

            val intent = Intent().setClass(this, MenuActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
            menuDiag.isClickable = false
        }

        dialog.setOnCancelListener { resumeDiag.performClick() }
        dialog.setOnShowListener { surface!!.pauseThread() }
    }

    // DESACTIVAMOS EL BACK DENTRO DEL JUEGO
    override fun onBackPressed() {
        //does nothing
    }

    override fun onPause() {
        super.onPause()
        if (!end_game) {
            if (surface != null) {
                if (!dialog.isShowing and !exit) {
                    dialog.show()
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()

        if (dialog.isShowing) {
            dialog.dismiss()
        }
    }

    override fun onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(endGameMsg)
        super.onDestroy()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        if (!end_game) {
            if (!hasFocus) {
                if (!dialog.isShowing and !exit) {
                    dialog.show()
                }
            }
        }
        super.onWindowFocusChanged(hasFocus)
    }
}