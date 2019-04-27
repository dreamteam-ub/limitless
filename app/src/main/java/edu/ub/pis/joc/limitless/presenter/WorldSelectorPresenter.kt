package edu.ub.pis.joc.limitless.presenter

import android.util.Log
import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.User
import edu.ub.pis.joc.limitless.view.MAX_LEVEL
import edu.ub.pis.joc.limitless.view.MAX_WORLD
import edu.ub.pis.joc.limitless.view.MIN_LVL_WORLD

class WorldSelectorPresenter(var view: View) {

    fun updateUser(user: User) {
        Data.user = user
        if (Data.currentWorld > Data.user.world!!) {
            Data.currentWorld = Data.user.world!!
        }
        if (Data.currentLvl > Data.user.level!!) {
            Data.currentLvl = Data.user.level!!
        }
    }

    fun updateWorld(worldPlus: Int = 0) {
        var hideTop = false
        var hideDown = false

        val maxWorld = if (Data.user.world!! <= MAX_WORLD) {
            Data.user.world!!
        } else {
            MAX_WORLD
        }

        if (Data.currentWorld + worldPlus in MIN_LVL_WORLD..maxWorld) {
            Data.currentWorld += worldPlus
            if (Data.currentWorld == MIN_LVL_WORLD) {
                hideTop = true
            }
            if (Data.currentWorld == maxWorld) {
                if (Data.currentLvl > Data.user.level!!) {
                    Data.currentLvl = Data.user.level!!
                }
                hideDown = true
            }
        }
        view.changeWorldView(Data.currentWorld, hideTop, hideDown)
    }

    fun updateLevel(levelPlus: Int = 0) {
        var hideLeft = false
        var hideRight = false

        val maxLvl = if (Data.currentWorld < Data.user.world!!) {
            MAX_LEVEL
        } else {
            Data.user.level!!
        }

        if (Data.currentLvl + levelPlus in MIN_LVL_WORLD..maxLvl) {
            Data.currentLvl += levelPlus
            if (Data.currentLvl == MIN_LVL_WORLD) {
                hideLeft = true
            }
            if (Data.currentLvl == maxLvl) {
                hideRight = true
            }
        }

        view.changeLevelView(Data.currentLvl, hideLeft, hideRight)
    }


    interface View {
        fun changeWorldView(world: Int, hideTop: Boolean, hideDown: Boolean)
        fun changeLevelView(level: Int, hideLeft: Boolean, hideRight: Boolean)
    }
}