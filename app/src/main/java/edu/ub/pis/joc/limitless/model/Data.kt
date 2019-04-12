package edu.ub.pis.joc.limitless.model

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
    var ranking : ArrayList<Ranking> = ArrayList()

}