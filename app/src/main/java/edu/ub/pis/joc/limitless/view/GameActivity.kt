package edu.ub.pis.joc.limitless.view

import android.app.Dialog
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton
import edu.ub.pis.joc.limitless.R

class GameActivity : FullScreenActivity() {

    private val TAG = "GameActivity"

    lateinit var dialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        val setMode: Intent = intent
        val mode = setMode.extras!!.getString("mode")

        val winButton: Button = findViewById(R.id.winButton)

        if (mode == "Infinity") {
            winButton.visibility = View.GONE
            winButton.isClickable = false

        } else if (mode == "My Map") {
            winButton.visibility = View.VISIBLE
            winButton.isClickable = true
        }

        winButton.setOnClickListener {
            val winIntent = Intent(this, GameWonActivity::class.java)
            startActivity(winIntent)
            finish()
        }

        //LOSE BUTTON
        val loseButton: Button = findViewById(R.id.loseButton)
        loseButton.setOnClickListener {
            if (mode == "Infinity") {
                val DeadIntent = Intent(this, GameDeadActivity::class.java)
                DeadIntent.putExtra("mode", "inf")
                startActivity(DeadIntent)
                finish()


            } else if (mode == "My Map") {
                val DeadIntent = Intent(this, GameDeadActivity::class.java)
                DeadIntent.putExtra("mode", "mymap")
                startActivity(DeadIntent)
                finish()
            }
        }

        dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        val vista = layoutInflater.inflate(R.layout.game_pause_dialog, null)
        val resumeDiag: ImageButton = vista.findViewById(R.id.resumeButtonDiag)
        val worldsDiag: ImageButton = vista.findViewById(R.id.worldsButtonPauseDiag)
        val menuDiag: ImageButton = vista.findViewById(R.id.menuButtonPauseDiag)
        dialog.setContentView(vista)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))

        //PAUSE BUTTOM
        val pauseButton: Button = findViewById(R.id.pauseButton)
        pauseButton.setOnClickListener {
            if (mode!! == "Infinity") {
                worldsDiag.visibility = View.GONE
                worldsDiag.isClickable = false
            } else if (mode == "My Map") {
                worldsDiag.visibility = View.VISIBLE
                worldsDiag.isClickable = true

            }

            dialog.window!!.setFlags(
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
            )

            dialog.show()

            resumeDiag.setOnClickListener {
                dialog.dismiss()

            }

            worldsDiag.setOnClickListener {
                val intent = Intent(this, WorldSelectorActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
                finish()
            }

            menuDiag.setOnClickListener {
                val intent = Intent(this, MenuActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
                finish()
            }

        }
    }

    // DESACTIVAMOS EL BACK DENTRO DEL JUEGO
    override fun onBackPressed() {
        if (dialog.isShowing) {
            dialog.dismiss()
        }
    }

}
