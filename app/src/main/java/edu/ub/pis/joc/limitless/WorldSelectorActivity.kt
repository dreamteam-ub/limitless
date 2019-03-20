package edu.ub.pis.joc.limitless


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

const val nLevels = 3
const val nWorlds = 4

class WorldSelectorActivity : ActivityNoTopBar() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_world_selector)

        //Variables
        //var selectLevel: Boolean = false
        var LVL = 0
        var World = 0
        val img = arrayOf(R.drawable.portada_mundo1,
                                         R.drawable.eye,
                                         R.drawable.skull,
                                         R.drawable.demon)

        //TextViews
        val worldTitle: TextView = findViewById(R.id.world_one_title)
        val lvlTitle: TextView = findViewById(R.id.level_title)

        val arrowBack: ImageButton = findViewById(R.id.world_back_button)
        arrowBack.setOnClickListener {
            finish()
        }

        val worldPhoto: ImageButton = findViewById(R.id.world_one)
        worldPhoto.setOnClickListener {
            val myMapGameInt = Intent(this, GameActivity::class.java)
            myMapGameInt.putExtra("mode","My Map")
            startActivity(myMapGameInt)
        }


        val leftArrow: ImageButton = findViewById(R.id.change_left_arrow)
        leftArrow.setOnClickListener {
            LVL -= 1
            if(LVL < 0){LVL = 2}
            when(LVL) {
                0 -> lvlTitle.text = resources.getString(R.string.first_level)
                1 -> lvlTitle.text = resources.getString(R.string.second_level)
                2 -> lvlTitle.text = resources.getString(R.string.third_level)
            }

        }

        val rightArrow: ImageButton = findViewById(R.id.change_right_arrow)
        rightArrow.setOnClickListener {
            LVL += 1
            LVL = LVL% nLevels
            when(LVL){
                0-> lvlTitle.text = resources.getString(R.string.first_level)
                1-> lvlTitle.text = resources.getString(R.string.second_level)
                2-> lvlTitle.text = resources.getString(R.string.third_level)
            }

        }



        val downArrow: ImageButton = findViewById(R.id.change_down_arrow)
        downArrow.setOnClickListener {
            World -= 1
            if(World < 0){World = 3}
            worldPhoto.setImageResource(img[World])
            when(World){
                0-> worldTitle.text = resources.getString(R.string.world_one_title)
                1-> worldTitle.text = resources.getString(R.string.world_two_title)
                2-> worldTitle.text = resources.getString(R.string.world_three_title)
                3-> worldTitle.text = resources.getString(R.string.world_four_title)
            }
        }

        val upArrow: ImageButton = findViewById(R.id.change_up_arrow)
        upArrow.setOnClickListener {
            //SETEAMOS EL Nivel
            LVL = 0
            lvlTitle.text = resources.getString(R.string.first_level)

            World += 1
            World = World % nWorlds
            worldPhoto.setImageResource(img[World])
            when(World){
                0-> worldTitle.text = resources.getString(R.string.world_one_title)
                1-> worldTitle.text = resources.getString(R.string.world_two_title)
                2-> worldTitle.text = resources.getString(R.string.world_three_title)
                3-> worldTitle.text = resources.getString(R.string.world_four_title)
            }

        }
    }


}
