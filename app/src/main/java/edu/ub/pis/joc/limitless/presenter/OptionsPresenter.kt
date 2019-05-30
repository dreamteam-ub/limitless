package edu.ub.pis.joc.limitless.presenter

import android.view.Gravity
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.model.*
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

        db.collection(USERS).document(mAuth.currentUser!!.uid).update(VIBRATION, newVibrate)
        view.updateVibrateButton(newVibrate)
    }

    fun updateMusic(value: Int) {
        db.collection(USERS).document(mAuth.currentUser!!.uid).update(MUSIC, value)
    }


    interface View {
        fun updateUserInfo(user: User)
        fun updateVibrateButton(value: Boolean)
    }
}