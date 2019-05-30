package edu.ub.pis.joc.limitless.model

import edu.ub.pis.joc.limitless.view.MAX_LEVEL
import edu.ub.pis.joc.limitless.view.MAX_WORLD
import edu.ub.pis.joc.limitless.view.MIN_LVL_WORLD

object Data  {
    var currentLvl : Int = 0
    var currentWorld : Int = 0
    var currentSkin : Int = 0

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
    //Relacion que nos indica que nivel del modo practica es
    fun getCurrenLevel():Int{
        return Data.currentWorld * MAX_WORLD + Data.currentLvl
    }

    fun getTotalLevel():Int{
        return user.world!! * MAX_WORLD + user.level!!
    }

    var ranking : ArrayList<Ranking> = ArrayList()

    var versus_survived : Array <Long> = arrayOf(0L,0L)
    var versus_score : Array<Int> = arrayOf(0,0)

    /*
    Pasamos al formato MMSS el numero de tiempo que ha sobrevivido
     */
    fun numberToMMSS(num: Long): String {
        return String.format("%02d:%02d", num / 60, num % 60)
    }

}