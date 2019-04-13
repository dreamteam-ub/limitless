package edu.ub.pis.joc.limitless.presenter

import edu.ub.pis.joc.limitless.view.ranking.model.Data
import edu.ub.pis.joc.limitless.view.ranking.model.User

class OptionsPresenter(var view : OptionsPresenter.View) {

    fun updateUser(user: User) {
        Data.user = user
        view.updateUserInfo(user)
    }

    fun updateSFX(value: Int) {
        Data.user.sfx = value
        view.updateSFX(value)
    }

    fun updateMusic(value: Int) {
        Data.user.music = value
        view.updateMusic(value)
    }

    interface View {
        fun updateUserInfo(user: User)
        fun updateSFX(value: Int)
        fun updateMusic(value: Int)
    }
}