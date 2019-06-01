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
import edu.ub.pis.joc.limitless.model.TUTORIAL_INF
import edu.ub.pis.joc.limitless.model.TUTORIAL_VS

const val TUTORIAL = "tutorial"

class TutorialViewPagerAdapter(
    private val context: Context,
    private val mode: Int = 0,
    private val pages: Array<Page>,
    private val level: Int = 0,
    private val world: Int = 0,
    private val manual: Boolean = false
) : PagerAdapter() {
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val tutorialPage: Page = pages[position]
        val inflater = LayoutInflater.from(context)

        val layout: ViewGroup
        if (!tutorialPage.end_layout) {
            layout = inflater.inflate(R.layout.tutorial_item, container, false) as ViewGroup
        } else {
            layout = inflater.inflate(R.layout.finish_tutorial_item, container, false) as ViewGroup
            val button_exit_tutorial: ImageButton = layout.findViewById(R.id.finish_tutorial)
            button_exit_tutorial.setOnClickListener {
                var intent: Intent
                if (!manual && mode == 0) {
                    Data.currentLvl = level
                    Data.currentWorld = world

                    if (Data.user.tutorial == null) {
                        Data.user.tutorial = 0
                    }
                    if (Data.user.tutorial!! <= MAX_WORLD) {
                        Data.user.tutorial = Data.user.tutorial!! + 1
                        FirebaseFirestore.getInstance().collection(USERS)
                            .document(FirebaseAuth.getInstance().currentUser!!.uid)
                            .update(TUTORIAL, Data.user.tutorial!!)
                    }

                    intent = Intent(context, GameActivity::class.java)
                    intent.putExtra(MODE_INFINITY, false)
                } else if (mode == INF) {
                    intent = Intent(context, GameActivity::class.java)
                    intent.putExtra(MODE_INFINITY, true)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

                    Data.user.tutorial_inf = true
                    FirebaseFirestore.getInstance().collection(USERS)
                        .document(FirebaseAuth.getInstance().currentUser!!.uid)
                        .update(TUTORIAL_INF, true)
                } else if (mode == VS) {
                    intent = Intent(context, GameActivity::class.java)
                    intent.putExtra(MODE_INFINITY, true)
                    intent.putExtra(MODE_INFINITY_VERSUS, true)
                    intent.putExtra(MODE_INFINITY_VERSUS_COUNT, 0)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

                    Data.user.tutorial_vs = true
                    FirebaseFirestore.getInstance().collection(USERS)
                        .document(FirebaseAuth.getInstance().currentUser!!.uid)
                        .update(TUTORIAL_VS, true)
                } else {
                    intent = Intent(context, WorldSelectorActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                }
                context.startActivity(intent)
                (context as TutorialActivity).finish()
                button_exit_tutorial.isClickable = false
            }
            ViewAdjuster.adjustView(button_exit_tutorial)
        }

        val image: ImageView = layout.findViewById(R.id.image)
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