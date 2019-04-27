package edu.ub.pis.joc.limitless.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.model.Data

class GameWonActivity : FullScreenActivity() {

    private val TAG = "GameWonActivity"


    private lateinit var mAuth: FirebaseAuth
    private lateinit var db: FirebaseFirestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_won)
        mAuth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        val nextLevel: ImageButton = findViewById(R.id.nextlvlButton)
        nextLevel.setOnClickListener {
            //NO CAMBIA DE NIVEL
            if (Data.currentLvl != MAX_LEVEL && Data.currentWorld != MAX_WORLD) {
                Log.d("CURRENT LVL",Data.currentLvl.toString())
                Data.currentLvl = (Data.currentLvl + 1) % MAX_LEVEL
                if (Data.currentLvl == 0) {
                    Data.currentWorld = Data.currentWorld + 1
                }
            }
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra(MODE_GAME, LEVEL_BY_WORLD)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        if (Data.user.level!! != MAX_LEVEL && Data.user.world!! != MAX_WORLD) {

            Data.user.level = (Data.user.level!! + 1) % MAX_LEVEL
            Log.d("NIVEL",Thread.currentThread().name)

            if (Data.user.level!! == 0) {
                Data.user.world = Data.user.world!! + 1
                Log.d("level",Data.user.level!!.toString())
            }

            db.collection(USERS).document(mAuth.currentUser!!.uid).update(LEVEL, Data.user.level!!)
            db.collection(USERS).document(mAuth.currentUser!!.uid).update(WORLD, Data.user.world!!)

        }
        if (Data.currentLvl != MAX_LEVEL && Data.currentWorld != MAX_WORLD) {
            Data.currentLvl = (Data.currentLvl + 1) % MAX_LEVEL
            if (Data.currentLvl == 0) {
                Data.currentWorld = Data.currentWorld + 1
            }
        } else {
            nextLevel.visibility = View.GONE
        }


        val worlds: ImageButton = findViewById(R.id.worldsButton)
        worlds.setOnClickListener {
            val intent = Intent(this, WorldSelectorActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }

        val backToMenu: ImageButton = findViewById(R.id.menuButton)
        backToMenu.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }
    }

    // DESACTIVAMOS EL BACK DENTRO DEL JUEGO
    override fun onBackPressed() {

    }
}
