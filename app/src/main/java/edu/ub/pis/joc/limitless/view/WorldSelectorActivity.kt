package edu.ub.pis.joc.limitless.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.User
import edu.ub.pis.joc.limitless.presenter.WorldSelectorPresenter

const val N_LEVELS = 3
const val N_WORLDS = 4

class WorldSelectorActivity : FullScreenActivity() {

    private val TAG = "WorldSelectorActivity"
    private val wsPresenter = WorldSelectorPresenter()

    private lateinit var mAuth: FirebaseAuth
    private lateinit var db : FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_world_selector)

        mAuth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()


        //Variables
        //var selectLevel: Boolean = false
        var lvl = 0
        var world = 0

        val img = arrayOf(
            R.drawable.world1_select,
            R.drawable.world2_select,
            R.drawable.world3_select,
            R.drawable.world4_select
        )



        //Variables
        val worldTitle: TextView = findViewById(R.id.world_one_title)
        val lvlTitle: TextView = findViewById(R.id.level_title)
        val arrowBack: ImageButton = findViewById(R.id.world_back_button)
        val worldPhoto: ImageButton = findViewById(R.id.world_one)
        val leftArrow: ImageButton = findViewById(R.id.change_left_arrow)
        val rightArrow: ImageButton = findViewById(R.id.change_right_arrow)
        val downArrow: ImageButton = findViewById(R.id.change_down_arrow)
        val upArrow: ImageButton = findViewById(R.id.change_up_arrow)

        upArrow.visibility = View.INVISIBLE
        leftArrow.visibility = View.INVISIBLE

        db.collection(USERS).document(mAuth.currentUser!!.uid).get().addOnSuccessListener { u ->
            Data.getInstance().user = u.toObject(User::class.java)!!
        }



        arrowBack.setOnClickListener {
            finish()
        }

        worldPhoto.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra("mode", "My Map")
            startActivity(intent)
            finish()
        }

        leftArrow.setOnClickListener {
            lvl -= 1
            when (lvl) {
                0 -> {
                    lvlTitle.text = resources.getString(R.string.first_level)
                    leftArrow.visibility = View.INVISIBLE
                }
                1 -> {
                    lvlTitle.text = resources.getString(R.string.second_level)
                    rightArrow.visibility = View.VISIBLE
                }
            }

        }

        rightArrow.setOnClickListener {
            lvl += 1
            when (lvl) {
                1 -> {
                    lvlTitle.text = resources.getString(R.string.second_level)
                    leftArrow.visibility = View.VISIBLE
                }
                2 -> {
                    lvlTitle.text = resources.getString(R.string.third_level)
                    rightArrow.visibility = View.INVISIBLE
                }
            }

        }

        downArrow.setOnClickListener {
            lvl = 0
            lvlTitle.text = resources.getString(R.string.first_level)
            leftArrow.visibility = View.INVISIBLE
            rightArrow.visibility = View.VISIBLE

            if (world + 1 <= Data.getInstance().user!!.world!!) {
                world += 1
                worldPhoto.setImageResource(img[world])
                when (world) {
                    1 -> {
                        worldTitle.text = resources.getString(R.string.world_two_title)
                        upArrow.visibility = View.VISIBLE
                    }
                    2 -> {
                        worldTitle.text = resources.getString(R.string.world_three_title)
                    }
                    3 -> {
                        worldTitle.text = resources.getString(R.string.world_four_title)
                        downArrow.visibility = View.INVISIBLE
                    }
                }
                if (world == Data.getInstance().user!!.world) {
                    downArrow.visibility = View.INVISIBLE
                }
            }
        }

        upArrow.setOnClickListener {
            //SETEAMOS EL Nivel
            lvl = 0
            lvlTitle.text = resources.getString(R.string.first_level)
            leftArrow.visibility = View.INVISIBLE
            rightArrow.visibility = View.VISIBLE

            world -= 1
            worldPhoto.setImageResource(img[world])
            when (world) {
                0 -> {
                    worldTitle.text = resources.getString(R.string.world_one_title)
                    upArrow.visibility = View.INVISIBLE
                }
                1 -> {
                    worldTitle.text = resources.getString(R.string.world_two_title)
                }
                2 -> {
                    worldTitle.text = resources.getString(R.string.world_three_title)
                    downArrow.visibility = View.VISIBLE
                }
            }
            if (world != Data.getInstance().user!!.world) {
                downArrow.visibility = View.VISIBLE
            }
        }
    }


}
