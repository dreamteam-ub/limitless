package edu.ub.pis.joc.limitless.view

import android.content.Intent
import android.os.Bundle
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

    private lateinit var nextLevel: ImageButton
    private lateinit var worlds: ImageButton
    private lateinit var backToMenu: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_won)

        ViewAdjuster.adjustViewLayoutPadding(findViewById(R.id.root))

        mAuth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        nextLevel = findViewById(R.id.nextlvlButton)
        nextLevel.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra(MODE_INFINITY,false)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
            nextLevel.isClickable = false
        }

        ViewAdjuster.adjustView(nextLevel)

        if (Data.user.level!! != MAX_LEVEL + 1 && Data.user.world!! != MAX_WORLD) {
            if (Data.user.level!! <= Data.currentLvl && Data.user.world == Data.currentWorld) {
                Data.user.level = (Data.user.level!! + 1)
            }
            db.collection(USERS).document(mAuth.currentUser!!.uid).update(LEVEL, Data.user.level!!)
            db.collection(USERS).document(mAuth.currentUser!!.uid).update(WORLD, Data.user.world!!)

        }
        if (Data.user.level!! == MAX_LEVEL + 1) {
            Data.user.level = 0
            Data.user.world = Data.user.world!! + 1

            db.collection(USERS).document(mAuth.currentUser!!.uid).update(LEVEL, Data.user.level!!)
            db.collection(USERS).document(mAuth.currentUser!!.uid).update(WORLD, Data.user.world!!)
        }

        if (Data.currentLvl != MAX_LEVEL + 1 && Data.currentWorld != MAX_WORLD) {
            Data.currentLvl = (Data.currentLvl + 1)
        }
        if (Data.currentLvl == MAX_LEVEL + 1) {
            Data.currentLvl = 0
            Data.currentWorld = Data.currentWorld + 1
        } else if (Data.currentLvl == MAX_LEVEL && Data.currentWorld == MAX_WORLD) {
            nextLevel.visibility = View.GONE
        }

        worlds = findViewById(R.id.worldsButton)
        worlds.setOnClickListener {
            val intent = Intent(this, WorldSelectorActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
            worlds.isClickable = false
        }

        ViewAdjuster.adjustView(worlds)

        backToMenu = findViewById(R.id.menuButton)
        backToMenu.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
            backToMenu.isClickable = false
        }
        ViewAdjuster.adjustView(backToMenu)

        ViewAdjuster.adjustView(findViewById(R.id.youWonImage))
        ViewAdjuster.adjustView(findViewById(R.id.heartWon))
    }

    // DESACTIVAMOS EL BACK DENTRO DEL JUEGO
    override fun onBackPressed() {
    }

    override fun onStart() {
        super.onStart()
        nextLevel.isClickable = true
        worlds.isClickable = true
        backToMenu.isClickable = true
    }
}
