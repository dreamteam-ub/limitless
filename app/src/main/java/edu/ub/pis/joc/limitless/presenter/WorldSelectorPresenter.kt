package edu.ub.pis.joc.limitless.presenter

import edu.ub.pis.joc.limitless.model.Data
import edu.ub.pis.joc.limitless.model.User
import edu.ub.pis.joc.limitless.view.MAX_LEVEL
import edu.ub.pis.joc.limitless.view.MAX_WORLD
import edu.ub.pis.joc.limitless.view.MIN_LVL_WORLD

class WorldSelectorPresenter(var view : View) {

    fun updateUser(user: User) {
        Data.user = user
    }

    fun updateLvl(lvl : Int) {
        var hideLeft = false
        var hideRight = false
        val tmp = Data.currentLvl + lvl

        val maxLvl = if (Data.currentWorld < Data.user!!.world!!) {
            MAX_LEVEL
        } else {
            if (Data.user!!.level!! <= MAX_LEVEL) {
                Data.user!!.level!!
            } else {
                MAX_LEVEL
            }
        }

        if (tmp in MIN_LVL_WORLD..maxLvl) {
            if (tmp == MIN_LVL_WORLD) {
                hideLeft = true
            } else if (tmp == maxLvl) {
                hideRight = true
            }
            Data.currentLvl += lvl
            view.changeLvlView(Data.currentLvl, hideLeft, hideRight)
        }
    }

    fun updateWorld(world : Int) {
        var hideTop = false
        var hideDown = false

        var hideLeft = false
        var hideRight = false

        val tmp = Data.currentWorld + world
        val maxWorld = if (Data.user!!.world!! <= MAX_WORLD) {
            Data.user!!.world!!
        } else {
            MAX_WORLD
        }

        if (tmp in MIN_LVL_WORLD..maxWorld) {
            if (tmp == MIN_LVL_WORLD) {
                hideTop = true
            } else if (tmp == maxWorld) {
                hideDown = true
            }
            Data.currentWorld += world
            view.changeWorldView(Data.currentWorld, hideTop, hideDown)

            if (Data.user!!.level!! < MAX_LEVEL && Data.user!!.world == Data.currentWorld) {
                Data.currentLvl = Data.user!!.level!!
                hideRight = true
            } else if (Data.currentLvl == MAX_LEVEL) {
                hideRight = true
            }

            if (Data.currentLvl == MIN_LVL_WORLD) {
                hideLeft = true
            }

            view.changeLvlView(Data.currentLvl, hideLeft, hideRight)
        }
    }

    interface View {
        fun changeLvlView(lvl: Int, hideLeft : Boolean, hideRight : Boolean)
        fun changeWorldView(world : Int, hideTop : Boolean, hideDown : Boolean)
    }
}