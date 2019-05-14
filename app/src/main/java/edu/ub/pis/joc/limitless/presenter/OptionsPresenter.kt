package edu.ub.pis.joc.limitless.presenter

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.MUSIC
import edu.ub.pis.joc.limitless.model.User
import edu.ub.pis.joc.limitless.model.VIBRATION
import edu.ub.pis.joc.limitless.view.*

class OptionsPresenter(var view : OptionsPresenter.View) {

    fun updateUser(user: User) {
        Data.user = user
        view.updateUserInfo(user)
    }

    fun updateVibrate(value: Boolean) {
        val mAuth = FirebaseAuth.getInstance()
        val db = FirebaseFirestore.getInstance()

        val newVibrate = !value

        db.collection(USERS).document(mAuth.currentUser!!.uid).update(VIBRATION, newVibrate)
        view.updateVibrateButton(newVibrate)
    }

    fun updateMusic(value: Int) {
        val mAuth = FirebaseAuth.getInstance()
        val db = FirebaseFirestore.getInstance()

        db.collection(USERS).document(mAuth.currentUser!!.uid).update(MUSIC, value)
    }

    interface View {
        fun updateUserInfo(user: User)
        fun updateVibrateButton(value : Boolean)
    }
}