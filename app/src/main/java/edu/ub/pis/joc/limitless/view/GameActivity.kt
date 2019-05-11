package edu.ub.pis.joc.limitless.view

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageButton
import edu.ub.pis.joc.limitless.R
import android.view.Gravity
import android.view.WindowManager
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.Data.versus_survived
import edu.ub.pis.joc.limitless.model.SURVIVED

var end_game = false

class GameActivity : FullScreenActivity() {

    private val TAG = "GameActivity"

    private lateinit var surface: GameView

    private var exit: Boolean = false

    lateinit var dialog: Dialog

    var mode: Boolean = false

    private var modeVersus: Boolean = false
    private var round: Int = 0

    private lateinit var mAuth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    private lateinit var resumeDiag: ImageButton
    private lateinit var worldsDiag: ImageButton
    private lateinit var menuDiag: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mAuth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        end_game = false

        val intentExtras = intent.extras!!

        mode = intentExtras.getBoolean(MODE_INFINITY)

        val tmpVersus: Boolean? = intentExtras.getBoolean(MODE_INFINITY_VERSUS)

        if (tmpVersus == null || !tmpVersus) {
            modeVersus = false
        } else {
            modeVersus = true
            round = intentExtras.getInt(MODE_INFINITY_VERSUS_COUNT)

            val icon: Int
            val player: String
            if (round == 0) {
                icon = R.drawable.world1_select
                player = "1"
            } else {
                icon = R.drawable.world2_select
                player = "2"
            }

            customImageToast(
                icon, getString(R.string.player) + " " + player,
                Toast.LENGTH_SHORT, Gravity.TOP or
                        Gravity.FILL_HORIZONTAL, 0, 200
            ).show()

        }

        dialog = Dialog(this)

        surface = GameView(this, dialog, mode, modeVersus)
        setContentView(surface)

        val layoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val vista = layoutInflater.inflate(R.layout.game_pause_dialog, null)
        dialog.setContentView(vista)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCanceledOnTouchOutside(false)

        dialog.window!!.setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE)
        dialog.window!!.decorView.systemUiVisibility = window.decorView.systemUiVisibility

        resumeDiag = vista.findViewById(R.id.resumeButtonDiag)
        worldsDiag = vista.findViewById(R.id.worldsButtonPauseDiag)
        menuDiag = vista.findViewById(R.id.menuButtonPauseDiag)

        if (mode) {
            worldsDiag.visibility = View.GONE
        }

        resumeDiag.setOnClickListener {
            surface.resumeThread()
            dialog.dismiss()
        }

        dialog.setOnDismissListener { resumeDiag.isClickable = true }

        worldsDiag.setOnClickListener {
            exit = true
            surface.surfaceDestroyed(surface.holder)
            dialog.dismiss()

            val intent = Intent().setClass(this, WorldSelectorActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
            worldsDiag.isClickable = false
        }

        menuDiag.setOnClickListener {
            exit = true
            surface.surfaceDestroyed(surface.holder)
            dialog.dismiss()

            val intent = Intent().setClass(this, MenuActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
            menuDiag.isClickable = false
        }

        dialog.setOnCancelListener { resumeDiag.performClick() }
        dialog.setOnShowListener { surface.pauseThread() }
    }

    // DESACTIVAMOS EL BACK DENTRO DEL JUEGO
    override fun onBackPressed() {
        //does nothing
    }

    override fun onPause() {
        super.onPause()
        if (!end_game) {
            if (!dialog.isShowing and !exit) {
                dialog.show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        if (dialog.isShowing) {
            dialog.dismiss()
        }
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

    fun onEndGame(context: Context, updateDb: Boolean, time: Long, dead: Boolean, gOverPoints : Boolean) {
        if (dead) {
            if (modeVersus) {
                if (round == 1) {
                    val intent = Intent(context, VersusActivityEnd::class.java)
                    intent.putExtra(MODE_INFINITY, mode)
                    versus_survived[1] = time
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    startActivity(intent)
                    finish()
                } else {
                    val intent = Intent(context, SecondPlayerVsActivity::class.java)
                    intent.putExtra(MODE_INFINITY, mode)
                    intent.putExtra(MODE_INFINITY_VERSUS, modeVersus)
                    intent.putExtra(MODE_INFINITY_VERSUS_COUNT, 1)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    versus_survived[0] = time
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    startActivity(intent)
                    finish()
                }
            } else {
                if (updateDb) {
                    db.collection(USERS).document(mAuth.currentUser!!.uid).update(SURVIVED, Data.user.survived!!)
                }
                val intent = Intent(context, GameDeadActivity::class.java)
                intent.putExtra(MODE_INFINITY, mode)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                startActivity(intent)
                finish()
            }
        } else {
            val intent = Intent(context, GameWonActivity::class.java)
            intent.putExtra(MODE_INFINITY, mode)
            startActivity(intent)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        resumeDiag.isClickable = true
        worldsDiag.isClickable = true
        menuDiag.isClickable = true
    }
}