package edu.ub.pis.joc.limitless.presenter

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.SKINSELECTED
import edu.ub.pis.joc.limitless.model.User
import edu.ub.pis.joc.limitless.model.game.ANDROID_CHAR_INDEX
import edu.ub.pis.joc.limitless.model.game.MEDAL1_CHAR_INDEX
import edu.ub.pis.joc.limitless.view.*

class SkinSelectorPresenter(var view: View) {

    val mAuth = FirebaseAuth.getInstance()
    val db = FirebaseFirestore.getInstance()

    fun updateUser(user: User) {
        Data.user = user
    }
    fun updateSkinPreview(levelPlus: Int = 0, list : ArrayList<Int>) {
        var hideLeft = false
        var hideRight = false
        var index = 0

        if (Data.user.skinSelected!! >= list.size) {
            Data.user.skinSelected = list.size-1
        }

        index = Data.user.skinSelected!!

        if (index + levelPlus in 0..(list.size+1)) {
            index += levelPlus
            Data.user.skinSelected = if (list[index] == R.drawable.skin_select_android) {
                ANDROID_CHAR_INDEX
            } else {
                index
            }
            if (index == 0) {
                hideLeft = true
            }
            if (index == list.size-1) {
                hideRight = true
            }

            db.collection(USERS).document(mAuth.currentUser!!.uid).update(SKINSELECTED, Data.user.skinSelected)
            view.changeSkinPreview(levelPlus, index, hideLeft, hideRight)
        }
    }


    interface View {
        fun changeSkinPreview(levelPlus : Int, skin : Int, hideLeft: Boolean, hideRight: Boolean)
    }
}