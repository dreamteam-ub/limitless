package edu.ub.pis.joc.limitless.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.model.User
import edu.ub.pis.joc.limitless.presenter.WorldSelectorPresenter

const val N_LEVELS = 3
const val N_WORLDS = 4

class WorldSelectorActivity : FullScreenActivity() {

    private val TAG = "WorldSelectorActivity"
    private val wsPresenter = WorldSelectorPresenter()

    private lateinit var mAuth: FirebaseAuth
    private lateinit var db : FirebaseFirestore
    private var worlds : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_world_selector)

        mAuth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()


        //Variables
        //var selectLevel: Boolean = false
        var LVL = 0
        var World = 0
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
            val user = u.toObject(User::class.java)!!
            worlds = user.world!!
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
            LVL -= 1
            when (LVL) {
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
            LVL += 1
            when (LVL) {
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
            LVL = 0
            lvlTitle.text = resources.getString(R.string.first_level)
            leftArrow.visibility = View.INVISIBLE
            rightArrow.visibility = View.VISIBLE

            World += 1
            worldPhoto.setImageResource(img[World])
            when (World) {
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
        }

        upArrow.setOnClickListener {
            //SETEAMOS EL Nivel
            LVL = 0
            lvlTitle.text = resources.getString(R.string.first_level)
            leftArrow.visibility = View.INVISIBLE
            rightArrow.visibility = View.VISIBLE

            World -= 1
            worldPhoto.setImageResource(img[World])
            when (World) {
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
        }
    }


}
