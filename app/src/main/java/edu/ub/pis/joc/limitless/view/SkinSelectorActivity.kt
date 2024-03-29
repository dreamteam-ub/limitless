package edu.ub.pis.joc.limitless.view

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.User
import edu.ub.pis.joc.limitless.presenter.SkinSelectorPresenter

const val MEDAL_1 = 180
const val MEDAL_2 = 300

class SkinSelectorActivity : FullScreenActivity(), SkinSelectorPresenter.View {

    private val TAG = "WorldSelectorActivity"

    private lateinit var presenter: SkinSelectorPresenter

    private lateinit var mAuth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    private lateinit var userListener: ListenerRegistration

    private lateinit var skinSelectInfo: TextView
    private lateinit var arrowBack: ImageButton
    private lateinit var skinPhoto: ImageButton
    private lateinit var leftArrow: ImageButton
    private lateinit var rightArrow: ImageButton

    private lateinit var imgSkins: ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skin_selector)

        ViewAdjuster.adjustViewLayoutPadding(findViewById(R.id.root))

        presenter = SkinSelectorPresenter(this)

        mAuth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        skinSelectInfo = findViewById(R.id.skins_selection)
        ViewAdjuster.adjustView(skinSelectInfo)

        arrowBack = findViewById(R.id.skins_back_button)
        ViewAdjuster.adjustView(arrowBack)

        skinPhoto = findViewById(R.id.skin_preview)
        ViewAdjuster.adjustView(skinPhoto)

        leftArrow = findViewById(R.id.change_left_arrow_skins)
        ViewAdjuster.adjustView(leftArrow)

        rightArrow = findViewById(R.id.change_right_arrow_skins)
        ViewAdjuster.adjustView(rightArrow)

        imgSkins = arrayListOf(
            R.drawable.skin_select_default,
            R.drawable.skin_select_ghost,
            R.drawable.skin_select_eye,
            R.drawable.skin_select_demon,
            R.drawable.skin_select_skull
        )

        if (Data.user.survived!! >= MEDAL_1) {
            imgSkins.add(R.drawable.skin_select_medal1)
        }

        if (Data.user.survived!! >= MEDAL_2) {
            imgSkins.add(R.drawable.skin_select_medal2)
        }

        if (Data.user.androidchar != null && Data.user.androidchar!!) {
            imgSkins.add(R.drawable.skin_select_android)
        }

        userListener =
            db.collection(USERS).document(mAuth.currentUser!!.uid).addSnapshotListener { docSnapshot, exception ->
                if (exception != null) {
                    Log.w(TAG, "Listen failed.", exception)
                }
                if (docSnapshot != null && docSnapshot.exists()) {
                    presenter.updateUser(docSnapshot.toObject(User::class.java)!!)
                }
            }

        presenter.updateSkinPreview(list = imgSkins)

        arrowBack.setOnClickListener {
            finish()
            arrowBack.isClickable = false
        }

        leftArrow.setOnClickListener {
            presenter.updateSkinPreview(-1, imgSkins)
        }

        rightArrow.setOnClickListener {
            presenter.updateSkinPreview(+1, imgSkins)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        userListener.remove() // IMPORTANTE
    }

    override fun changeSkinPreview(levelPlus : Int, skin: Int, hideLeft: Boolean, hideRight: Boolean) {
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

        skinPhoto.setImageResource(imgSkins[skin])

        if (levelPlus != 0) {
            customToast(
                getString(R.string.skin_changed),
                Toast.LENGTH_SHORT, Gravity.BOTTOM or Gravity.FILL_HORIZONTAL, 0, 100
            ).show()
        }

    }

    override fun onStart() {
        super.onStart()
        arrowBack.isClickable = true
    }

}