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
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.Data.versus_survived
import edu.ub.pis.joc.limitless.model.SURVIVED

var end_game = false

class GameActivity : FullScreenActivity() {

    private val TAG = "GameActivity"

    private var surface: GameView? = null

    private var exit: Boolean = false

    lateinit var dialog: Dialog

    var mode: Boolean = false

    private var modeVersus : Boolean = false
    private var round : Int = 0

    private lateinit var mAuth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mAuth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        end_game = false

        val intentExtras = intent.extras!!

        mode = intentExtras.getBoolean(MODE_INFINITY)

        val tmpVersus : Boolean? = intentExtras.getBoolean(MODE_INFINITY_VERSUS)

        if (tmpVersus == null || !tmpVersus) {
            modeVersus = false
        } else {
            modeVersus = true
            round = intentExtras.getInt(MODE_INFINITY_VERSUS_COUNT)

            val icon : Int
            val player : String
            if (round == 0) {
                icon = R.drawable.world1_select
                player = "1"
            } else {
                icon = R.drawable.world2_select
                player = "2"
            }

            customImageToast(icon,getString(R.string.player) + player,
                Toast.LENGTH_SHORT, Gravity.TOP or
                        Gravity.FILL_HORIZONTAL,0,200).show()

        }

        dialog = Dialog(this)

        surface = GameView(this, dialog, mode, modeVersus)
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

    fun endGame(context: Context, infinity: Boolean, time: Long, type_end: Int) {
        if (type_end == 0 || type_end == 2) {
            if(modeVersus) {
                if (round == 1) {
                    val intent = Intent(context, VersusActivityEnd::class.java)
                    intent.putExtra(MODE_INFINITY, infinity)
                    versus_survived[1] = time
                    startActivity(intent)
                    finish()
                } else {
                    val intent = Intent(context, GameActivity::class.java)
                    intent.putExtra(MODE_INFINITY, infinity)
                    intent.putExtra(MODE_INFINITY_VERSUS, modeVersus)
                    intent.putExtra(MODE_INFINITY_VERSUS_COUNT, 1)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    versus_survived[0] = time
                    startActivity(intent)
                }
            } else {
                if (infinity) {
                    db.collection(USERS).document(mAuth.currentUser!!.uid).update(SURVIVED, Data.user.survived!!)
                }
                val intent = Intent(context, GameDeadActivity::class.java)
                intent.putExtra(MODE_INFINITY, infinity)
                startActivity(intent)
                finish()
            }
        } else if (type_end == 1) {
            val intent = Intent(context, GameWonActivity::class.java)
            intent.putExtra(MODE_INFINITY, infinity)
            startActivity(intent)
            finish()
        }
    }
}