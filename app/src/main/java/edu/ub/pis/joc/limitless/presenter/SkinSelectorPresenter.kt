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
        Data.currentSkin = Data.user.skinSelected!!
    }
    fun updateSkinPreview(levelPlus: Int = 0) {
        var hideLeft = false
        var hideRight = false

        if (Data.currentSkin + levelPlus in MIN_SKIN..(MAX_SKIN+1)) {
            Data.currentSkin += levelPlus
            if (Data.currentSkin == MIN_SKIN) {
                hideLeft = true
            }
            if (Data.currentSkin == MAX_SKIN) {
                hideRight = true
            }
        }

        db.collection(USERS).document(mAuth.currentUser!!.uid).update(SKINSELECTED, Data.currentSkin)
        view.changeSkinPreview(Data.currentSkin, hideLeft, hideRight)
    }


    interface View {
        fun changeSkinPreview(skin : Int, hideRight: Boolean, hideLeft: Boolean)
    }
}