package edu.ub.pis.joc.limitless.view

import android.os.Bundle
import edu.ub.pis.joc.limitless.R
import android.support.v4.view.ViewPager
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.Page

class TutorialActivity : FullScreenActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)
        val viewPager = findViewById<ViewPager>(R.id.tutorialpage)

        val pages : Array<Page>

        if (Data.user.tutorial == null || Data.user.tutorial == 0) { // tutorial mundo 1
            pages = arrayOf(
                Page(false, R.drawable.world4_select,"0"),
                Page(false, R.drawable.world3_select,"1"),
                Page(true, R.drawable.skull,"3")
            )
            viewPager.adapter = TutorialViewPagerAdapter(this, pages, 0, 0)
        } else if (Data.user.tutorial == 1) { // tutorial mundo 2
            pages = arrayOf(
                Page(false, R.drawable.world4_select,"0"),
                Page(false, R.drawable.world3_select,"1"),
                Page(true, R.drawable.skull,"3")
            )
            viewPager.adapter = TutorialViewPagerAdapter(this, pages, 0, 0)
        } else if (Data.user.tutorial == 2) {  // tutorial mundo 3
            pages = arrayOf(
                Page(false, R.drawable.world4_select,"0"),
                Page(false, R.drawable.world3_select,"1"),
                Page(true, R.drawable.skull,"3")
            )
            viewPager.adapter = TutorialViewPagerAdapter(this, pages, 0, 0)
        }
    }
}
