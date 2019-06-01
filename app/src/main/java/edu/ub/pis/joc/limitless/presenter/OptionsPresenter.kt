package edu.ub.pis.joc.limitless.presenter

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import edu.ub.pis.joc.limitless.model.*
import edu.ub.pis.joc.limitless.model.game.ANDROID_CHAR_INDEX
import edu.ub.pis.joc.limitless.view.USERS

class OptionsPresenter(var view: OptionsPresenter.View) {

    val mAuth = FirebaseAuth.getInstance()
    val db = FirebaseFirestore.getInstance()

    fun updateUser(user: User) {
        Data.user = user
        view.updateUserInfo(user)
    }

    fun updateVibrate(value: Boolean) {
        val newVibrate = !value
        db.collection(USERS).document(mAuth.currentUser!!.uid).update(VIBRATION, newVibrate).addOnSuccessListener {
            view.updateVibrateButton(newVibrate)
        }
    }

    fun updateMusic(value: Int) {
        db.collection(USERS).document(mAuth.currentUser!!.uid).update(MUSIC, value)
    }

    fun enableAndroidChar(tmp: Boolean) {
        val setting = !tmp
        db.collection(USERS).document(mAuth.currentUser!!.uid).update(ANDROIDCHAR, setting).addOnSuccessListener {
            if (!setting && Data.user.skinSelected == ANDROID_CHAR_INDEX) {
                db.collection(USERS).document(mAuth.currentUser!!.uid).update(SKINSELECTED, 0).addOnSuccessListener {
                    view.updateChar(setting)
                }
            } else {
                view.updateChar(setting)
            }
        }
    }

    interface View {
        fun updateUserInfo(user: User)
        fun updateVibrateButton(value: Boolean)
        fun updateChar(value: Boolean)
    }
}