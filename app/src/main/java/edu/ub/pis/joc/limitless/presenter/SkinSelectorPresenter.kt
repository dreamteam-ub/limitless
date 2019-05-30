package edu.ub.pis.joc.limitless.presenter

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.SKINSELECTED
import edu.ub.pis.joc.limitless.model.User
import edu.ub.pis.joc.limitless.view.*

class SkinSelectorPresenter(var view: View) {

    val mAuth = FirebaseAuth.getInstance()
    val db = FirebaseFirestore.getInstance()

    fun updateUser(user: User) {
        Data.user = user
    }
    fun updateSkinPreview(levelPlus: Int = 0, listSize : Int) {
        var hideLeft = false
        var hideRight = false

        if (Data.user.skinSelected!! >= listSize) {
            Data.user.skinSelected = 0
        }

        if (Data.user.skinSelected!! + levelPlus in 0..(listSize+1)) {
            Data.user.skinSelected = Data.user.skinSelected!! + levelPlus
            if (Data.user.skinSelected == 0) {
                hideLeft = true
            }
            if (Data.user.skinSelected == listSize-1) {
                hideRight = true
            }
        }

        db.collection(USERS).document(mAuth.currentUser!!.uid).update(SKINSELECTED, Data.user.skinSelected)
        view.changeSkinPreview(Data.user.skinSelected!!, hideLeft, hideRight)
    }


    interface View {
        fun changeSkinPreview(skin : Int, hideLeft: Boolean, hideRight: Boolean)
    }
}