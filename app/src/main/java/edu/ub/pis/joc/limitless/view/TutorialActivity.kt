package edu.ub.pis.joc.limitless.view

import android.os.Bundle
import edu.ub.pis.joc.limitless.R
import android.support.v4.view.ViewPager
import android.view.Gravity
import android.widget.Toast
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.Page

class TutorialActivity : FullScreenActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)
        val viewPager = findViewById<ViewPager>(R.id.tutorialpage)

        customToast(
            getString(R.string.swipe_tutorial),
            Toast.LENGTH_SHORT, Gravity.BOTTOM, 0, 100
        ).show()

        var manual : Boolean = false

        if (intent.extras != null) {
            manual = intent.extras!!.getBoolean(MANUAL_TUTORIAL)
        }

        if (manual) {
            viewPager.adapter = TutorialViewPagerAdapter(this, getTutorial(Data.currentWorld), 0, Data.currentWorld, manual)
        } else {
            if (Data.user.tutorial == null || Data.user.tutorial == 0) { // tutorial mundo 1
                viewPager.adapter = TutorialViewPagerAdapter(this, getTutorial(0), 0, 0)
            } else if (Data.user.tutorial == 1) { // tutorial mundo 2
                viewPager.adapter = TutorialViewPagerAdapter(this, getTutorial(1), 0, 1)
            } else if (Data.user.tutorial == 2) {  // tutorial mundo 3
                viewPager.adapter = TutorialViewPagerAdapter(this, getTutorial(2), 0, 2)
            }
        }
    }

    fun getTutorial(world : Int) : Array<Page> {
        return when(world) {
            WORLD1 -> {
                arrayOf(
                    Page(false, R.drawable.tutorial_w1_1,"0"),
                    Page(false, R.drawable.tutorial_w1_2,"1"),
                    Page(false, R.drawable.tutorial_w1_3,"2"),
                    Page(false, R.drawable.tutorial_w1_4,"3"),
                    Page(false, R.drawable.tutorial_w1_5,"4"),
                    Page(false, R.drawable.tutorial_w1_6,"5"),
                    Page(true, R.drawable.tutorial_w1_7,"6")
                )
            }
            WORLD2 -> {
                arrayOf(
                    Page(false, R.drawable.world2_select,"0"),
                    Page(false, R.drawable.world2_select,"1"),
                    Page(true, R.drawable.eye1,"3")
                )
            }
            WORLD3 -> {
                arrayOf(
                    Page(false, R.drawable.world3_select,"0"),
                    Page(false, R.drawable.world3_select,"1"),
                    Page(true, R.drawable.demon,"3")
                )
            }
            WORLD4 -> {
                arrayOf(
                    Page(false, R.drawable.world4_select,"0"),
                    Page(false, R.drawable.world4_select,"1"),
                    Page(true, R.drawable.skull,"3")
                )
            }
            else -> {
                getTutorial(0)
            }
        }
    }
}
