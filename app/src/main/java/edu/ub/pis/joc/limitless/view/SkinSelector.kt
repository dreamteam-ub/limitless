package edu.ub.pis.joc.limitless.view

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
import edu.ub.pis.joc.limitless.presenter.SkinSelectorPresenter

const val MAX_SKIN = 5 // 0-5
const val MIN_SKIN= 0

class SkinSelector : FullScreenActivity(), SkinSelectorPresenter.View {

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

    private lateinit var imgSkins: Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skin_selector)

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

        userListener =
            db.collection(USERS).document(mAuth.currentUser!!.uid).addSnapshotListener { docSnapshot, exception ->
                if (exception != null) {
                    Log.w(TAG, "Listen failed.", exception)
                }
                if (docSnapshot != null && docSnapshot.exists()) {
                    presenter.updateUser(docSnapshot.toObject(User::class.java)!!)
                    presenter.updateSkinPreview()
                }
            }

        imgSkins = arrayOf(
            R.drawable.skin_select_default,
            R.drawable.skin_select_ghost,
            R.drawable.skin_select_eye,
            R.drawable.skin_select_demon,
            R.drawable.skin_select_skull,
            R.drawable.skin_select_android
        )

        skinPhoto.setImageResource(imgSkins[Data.currentSkin])

        arrowBack.setOnClickListener {
            finish()
            arrowBack.isClickable = false
        }

        leftArrow.setOnClickListener {
            presenter.updateSkinPreview(-1)
        }

        rightArrow.setOnClickListener {
            presenter.updateSkinPreview(+1)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        userListener.remove() // IMPORTANTE
    }

    override fun changeSkinPreview(skin: Int, hideLeft: Boolean, hideRight: Boolean) {
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

    }

    override fun onStart() {
        super.onStart()
        arrowBack.isClickable = true
    }

}