package edu.ub.pis.joc.limitless.model

import android.content.res.Resources
import edu.ub.pis.joc.limitless.view.MAX_LEVEL
import edu.ub.pis.joc.limitless.view.MAX_WORLD
import edu.ub.pis.joc.limitless.view.MIN_LVL_WORLD

object Data  {
    var currentLvl : Int = 0
    var currentWorld : Int = 0


    var user : User = User()
    set(u) {
        u.world = when {
            u.world!! > MAX_WORLD -> MAX_WORLD
            u.world!! < MIN_LVL_WORLD -> 0
            else -> u.world
        }
        u.level = when {
            u.level!! > MAX_LEVEL -> MAX_LEVEL
            u.level!! < MIN_LVL_WORLD -> 0
            else -> u.level
        }
        field = u
    }

    fun getCurrenLevel():Int{
        return Data.currentWorld * MAX_WORLD + Data.currentLvl
    }

    var ranking : ArrayList<Ranking> = ArrayList()

    val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    val screenHeight = Resources.getSystem().displayMetrics.heightPixels

    var versus_survived : Array <Long> = arrayOf(0L,0L)

    fun numberToMMSS(num: Long): String {
        return String.format("%02d:%02d", num / 60, num % 60)
    }

}