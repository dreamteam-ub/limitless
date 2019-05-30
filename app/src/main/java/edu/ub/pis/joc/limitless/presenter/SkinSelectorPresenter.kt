package edu.ub.pis.joc.limitless.presenter

import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.User
import edu.ub.pis.joc.limitless.view.*

class SkinSelectorPresenter(var view: View) {

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

        view.changeSkinPreview(Data.currentSkin, hideLeft, hideRight)
    }


    interface View {
        fun changeSkinPreview(currentSkin: Int, hideRight: Boolean, hideLeft: Boolean)
    }
}