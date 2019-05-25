package edu.ub.pis.joc.limitless.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.User
import edu.ub.pis.joc.limitless.presenter.WorldSelectorPresenter

const val MAX_LEVEL = 2 // 0-2
const val MAX_WORLD = 3 // 0-3
const val MIN_LVL_WORLD = 0
const val LEVEL = "level"
const val WORLD = "world"

const val WORLD1 = 0
const val WORLD2 = 1
const val WORLD3 = 2
const val WORLD4 = 3


const val MANUAL_TUTORIAL = "manual_tutorial"

class WorldSelectorActivity : FullScreenActivity(), WorldSelectorPresenter.View {

    private val TAG = "WorldSelectorActivity"

    private lateinit var presenter: WorldSelectorPresenter

    private lateinit var mAuth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    private lateinit var userListener: ListenerRegistration

    private lateinit var worldTitle: TextView
    private lateinit var lvlTitle: TextView
    private lateinit var arrowBack: ImageButton
    private lateinit var worldPhoto: ImageButton
    private lateinit var leftArrow: ImageButton
    private lateinit var rightArrow: ImageButton
    private lateinit var downArrow: ImageButton
    private lateinit var upArrow: ImageButton
    private lateinit var playWorlds : ImageButton
    private lateinit var tutorialBtn : ImageButton

    private lateinit var imgWorld: Array<Int>
    private lateinit var strWorld: Array<Int>
    private lateinit var strLvl: Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_world_selector)

        presenter = WorldSelectorPresenter(this)

        mAuth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        worldTitle = findViewById(R.id.world_one_title)
        ViewAdjuster.adjustView(worldTitle)

        lvlTitle = findViewById(R.id.level_title)
        ViewAdjuster.adjustView(lvlTitle)

        arrowBack = findViewById(R.id.world_back_button)
        ViewAdjuster.adjustView(arrowBack)

        worldPhoto = findViewById(R.id.world_one)
        ViewAdjuster.adjustView(worldPhoto)

        leftArrow = findViewById(R.id.change_left_arrow)
        ViewAdjuster.adjustView(leftArrow)

        rightArrow = findViewById(R.id.change_right_arrow)
        ViewAdjuster.adjustView(rightArrow)

        downArrow = findViewById(R.id.change_down_arrow)
        ViewAdjuster.adjustView(downArrow)

        upArrow = findViewById(R.id.change_up_arrow)
        ViewAdjuster.adjustView(upArrow)

        playWorlds = findViewById(R.id.playButtonWorlds)
        ViewAdjuster.adjustView(playWorlds)

        tutorialBtn = findViewById(R.id.tutorialButton)
        ViewAdjuster.adjustView(tutorialBtn)

        userListener =
            db.collection(USERS).document(mAuth.currentUser!!.uid).addSnapshotListener { docSnapshot, exception ->
                if (exception != null) {
                    Log.w(TAG, "Listen failed.", exception)
                }
                if (docSnapshot != null && docSnapshot.exists()) {
                    presenter.updateUser(docSnapshot.toObject(User::class.java)!!)
                    presenter.updateWorld()
                    presenter.updateLevel()
                }
            }

        imgWorld = arrayOf(
            R.drawable.world1_select,
            R.drawable.world2_select,
            R.drawable.world3_select,
            R.drawable.world4_select
        )

        strWorld = arrayOf(
            R.string.world_one_title,
            R.string.world_two_title,
            R.string.world_three_title,
            R.string.world_four_title
        )

        strLvl = arrayOf(
            R.string.first_level,
            R.string.second_level,
            R.string.third_level
        )

        worldPhoto.setImageResource(imgWorld[Data.currentWorld])
        worldTitle.text = resources.getString(strWorld[Data.currentWorld])
        lvlTitle.text = resources.getString(strLvl[Data.currentLvl])

        arrowBack.setOnClickListener {
            finish()
            arrowBack.isClickable = false
        }

        leftArrow.setOnClickListener {
            presenter.updateLevel(-1)
            presenter.updateWorld()
        }

        rightArrow.setOnClickListener {
            presenter.updateLevel(+1)
            presenter.updateWorld()
        }

        upArrow.setOnClickListener {
            presenter.updateWorld(-1)
            presenter.updateLevel()
        }

        downArrow.setOnClickListener {
            presenter.updateWorld(+1)
            presenter.updateLevel()
        }

        playWorlds.setOnClickListener {
            if (
                ((Data.user.tutorial == null || Data.user.tutorial == WORLD1) && Data.currentLvl == 0 && Data.currentWorld == WORLD1)
                || (Data.user.tutorial == WORLD2 && Data.currentLvl == 0 && Data.currentWorld == WORLD2)
                || (Data.user.tutorial == WORLD3 && Data.currentLvl == 0 && Data.currentWorld == WORLD3)
                || (Data.user.tutorial == WORLD4 && Data.currentLvl == 0 && Data.currentWorld == WORLD4)
            ) {
                val intent = Intent(this, TutorialActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, GameActivity::class.java)
                intent.putExtra(MODE_INFINITY, false)
                startActivity(intent)
                finish()
            }
            playWorlds.isClickable = false
        }

        tutorialBtn.setOnClickListener {
            val intent = Intent(this, TutorialActivity::class.java)
            intent.putExtra(MANUAL_TUTORIAL,true)
            startActivity(intent)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        userListener.remove() // IMPORTANTE
    }

    override fun changeWorldView(world: Int, hideTop: Boolean, hideDown: Boolean) {
        if (hideTop) {
            upArrow.visibility = View.INVISIBLE
        } else {
            upArrow.visibility = View.VISIBLE
        }

        if (hideDown) {
            downArrow.visibility = View.INVISIBLE
        } else {
            downArrow.visibility = View.VISIBLE
        }

        worldPhoto.setImageResource(imgWorld[world])
        worldTitle.text = resources.getString(strWorld[world])
    }

    override fun changeLevelView(level: Int, hideLeft: Boolean, hideRight: Boolean) {
        if (hideLeft) {
            leftArrow.visibility = View.INVISIBLE
        } else {
            leftArrow.visibility = View.VISIBLE
        }

        if (hideRight) {
            rightArrow.visibility = View.INVISIBLE
        } else {
            rightArrow.visibility = View.VISIBLE
        }

        lvlTitle.text = resources.getString(strLvl[level])

    }

    override fun onStart() {
        super.onStart()
        arrowBack.isClickable = true
        playWorlds.isClickable = true
        tutorialBtn.isClickable = true
    }

}
