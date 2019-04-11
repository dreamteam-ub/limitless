package edu.ub.pis.joc.limitless.presenter

import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.User

class OptionsPresenter(var view : OptionsPresenter.View) {

    fun updateUser(user: User) {
        Data.user = user
        view.updateUserInfo(user)
    }

    // TODO FALTAN METODOS SFX Y AUDIO

    interface View {
        fun updateUserInfo(user: User)
        // TODO FALTAN METODOS SFX Y AUDIO
    }
}