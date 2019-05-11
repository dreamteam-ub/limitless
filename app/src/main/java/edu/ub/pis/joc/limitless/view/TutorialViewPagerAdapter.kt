package edu.ub.pis.joc.limitless.view

import android.content.Context
import android.content.Intent
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.Page

const val TUTORIAL = "tutorial"

class TutorialViewPagerAdapter(private val context: Context, private val pages : Array<Page>, private val level : Int, private val world : Int) : PagerAdapter() {
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val tutorialPage : Page = pages[position]
        val inflater = LayoutInflater.from(context)

        val layout : ViewGroup
        if (!tutorialPage.end_layout) {
            layout = inflater.inflate(R.layout.tutorial_item, container, false) as ViewGroup
        } else {
            layout = inflater.inflate(R.layout.finish_tutorial_item, container, false) as ViewGroup
            val button_exit_tutorial : ImageButton = layout.findViewById(R.id.finish_tutorial)
            button_exit_tutorial.setOnClickListener {
                Data.currentLvl = level
                Data.currentWorld = world
                val intent = Intent(context, GameActivity::class.java)
                intent.putExtra(MODE_INFINITY, false)
                context.startActivity(intent)
                (context as TutorialActivity).finish()
                button_exit_tutorial.isClickable = false
                if (Data.user.tutorial == null) {
                    Data.user.tutorial = 0
                }
                if (Data.user.tutorial!! < 3) {
                    Data.user.tutorial = Data.user.tutorial!! + 1
                    FirebaseFirestore.getInstance().collection(USERS)
                        .document(FirebaseAuth.getInstance().currentUser!!.uid)
                        .update(TUTORIAL, Data.user.tutorial!!)
                }
            }
        }

        val image : ImageView = layout.findViewById(R.id.image)
        image.setImageResource(tutorialPage.id_image)

        container.addView(layout)
        return layout
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        val tutorialPage = pages[position]
        return tutorialPage.name
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view === obj
    }

    override fun getCount(): Int {
        return pages.size
    }
}