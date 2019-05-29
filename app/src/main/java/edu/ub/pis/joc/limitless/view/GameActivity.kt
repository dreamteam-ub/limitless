package edu.ub.pis.joc.limitless.view

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.Data.versus_score
import edu.ub.pis.joc.limitless.model.Data.versus_survived
import edu.ub.pis.joc.limitless.model.SURVIVED
import edu.ub.pis.joc.limitless.model.VIBRATION
import java.io.File

const val SOUND_ASSETS = "sound"

var end_game = false

class GameActivity : FullScreenActivity() {

    private val TAG = "GameActivity"

    private lateinit var musicPlayer: MediaPlayer

    private var length: Int = 0

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

        val volume = if (Data.user.music != null) Data.user.music!!.toFloat() / 100.0f else 0.0f
        musicPlayer = MediaPlayer()

        val descriptor = assets.openFd(SOUND_ASSETS + File.separator + "stage.mp3")
        musicPlayer.setDataSource(descriptor.fileDescriptor, descriptor.startOffset, descriptor.length)
        descriptor.close()
        musicPlayer.prepare()

        musicPlayer.setVolume(volume, volume)

        musicPlayer.isLooping = true

        if (Data.user.vibration == null) {
            Data.user.vibration = true
            db.collection(USERS).document(mAuth.currentUser!!.uid).update(VIBRATION, Data.user.vibration)
        }

        end_game = false

        val intentExtras = intent.extras!!

        mode = intentExtras.getBoolean(MODE_INFINITY)
        round = intentExtras.getInt(MODE_INFINITY_VERSUS_COUNT)
        val tmpVersus: Boolean? = intentExtras.getBoolean(MODE_INFINITY_VERSUS)

        if (tmpVersus == null || !tmpVersus) {
            modeVersus = false
        } else {
            modeVersus = true
            var icon: Int
            val player: String
            if (round == 0) {
                icon = R.drawable.player_1
                if (Data.user.androidchar != null && Data.user.androidchar!!) {
                    icon = R.drawable.player_1_android
                }
                player = "1"
            } else {
                icon = R.drawable.player_2
                player = "2"
            }

            customImageToast(
                icon, getString(R.string.player) + " " + player,
                Toast.LENGTH_SHORT, Gravity.TOP or
                        Gravity.FILL_HORIZONTAL, 0, 200
                , font = R.font.roadrage
            ).show()

        }

        dialog = Dialog(this)

        surface = GameView(this, mode, modeVersus, round)
        setContentView(surface)

        val layoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val vista = layoutInflater.inflate(R.layout.game_pause_dialog, null)
        dialog.setContentView(vista)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCanceledOnTouchOutside(false)

        dialog.window!!.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
        )
        dialog.window!!.decorView.systemUiVisibility = window.decorView.systemUiVisibility

        resumeDiag = vista.findViewById(R.id.resumeButtonDiag)
        ViewAdjuster.adjustView(resumeDiag)

        worldsDiag = vista.findViewById(R.id.worldsButtonPauseDiag)
        ViewAdjuster.adjustView(worldsDiag)

        menuDiag = vista.findViewById(R.id.menuButtonPauseDiag)
        ViewAdjuster.adjustView(menuDiag)

        ViewAdjuster.adjustView(vista.findViewById(R.id.pauseHeartDiag))

        if (mode) {
            worldsDiag.visibility = View.GONE
        }

        resumeDiag.setOnClickListener {
            surface.resumeThread()
            onResume()
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

        musicPlayer.start()
        musicPlayer.seekTo(0)
    }

    // DESACTIVAMOS EL BACK DENTRO DEL JUEGO
    override fun onBackPressed() {
        //does nothing
    }

    override fun onPause() {
        super.onPause()
        musicPlayer.pause()
        length = musicPlayer.currentPosition

        if (!end_game) {
            if (!dialog.isShowing and !exit) {
                dialog.show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        musicPlayer.start()
        musicPlayer.seekTo(length)
    }

    override fun onDestroy() {
        super.onDestroy()

        if (dialog.isShowing) {
            dialog.dismiss()
        }

        musicPlayer.release()
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

    fun onEndGame(
        context: Context,
        updateDb: Boolean,
        time: Long,
        dead: Boolean,
        gOverPoints: Boolean,
        score: Int
    ) {
        runOnUiThread {
            if (dead) {
                if (modeVersus) {
                    if (round == 1) {
                        val intent = Intent(context, VersusActivityEnd::class.java)
                        intent.putExtra(MODE_INFINITY, mode)
                        versus_survived[1] = time
                        versus_score[1] = score
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
                        versus_score[0] = score
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
                    intent.putExtra(SCORE, score)
                    versus_survived[0] = time
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    startActivity(intent)
                    finish()
                }
            } else if (gOverPoints) {
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
                        intent.putExtra(LOST_GAME_NOT_DEAD, gOverPoints)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        versus_survived[0] = time
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                        startActivity(intent)
                        finish()
                    }
                } else if (mode && !modeVersus) {
                    if (updateDb) {
                        db.collection(USERS).document(mAuth.currentUser!!.uid).update(SURVIVED, Data.user.survived!!)
                    }
                    val intent = Intent(context, GameDeadActivity::class.java)
                    intent.putExtra(MODE_INFINITY, mode)
                    intent.putExtra(LOST_GAME_NOT_DEAD, gOverPoints)
                    intent.putExtra(SCORE, score)
                    versus_survived[0] = time
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    startActivity(intent)
                    finish()
                } else {
                    val intent = Intent(context, GameDeadActivity::class.java)
                    intent.putExtra(MODE_INFINITY, mode)
                    intent.putExtra(LOST_GAME_NOT_DEAD, gOverPoints)
                    intent.putExtra(SCORE, score)
                    versus_survived[0] = time
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    startActivity(intent)
                    finish()
                }

            } else if (!dead && !mode && !modeVersus) {
                val intent = Intent(context, GameWonActivity::class.java)
                intent.putExtra(MODE_INFINITY, mode)
                startActivity(intent)
                finish()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        resumeDiag.isClickable = true
        worldsDiag.isClickable = true
        menuDiag.isClickable = true
    }

    fun pause() {
        onPause()
    }

}